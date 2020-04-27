package com.blog.bbs.service.impl;


import com.blog.bbs.dao.interf.CardDao;
import com.blog.bbs.dao.interf.ItemDao;
import com.blog.bbs.service.interf.CardService;
import com.blog.bbs.util.GlobalConfJson;
import com.blog.bbs.util.JsonUtil;
import com.blog.bbs.util.StringUtil;
import com.blog.bbs.vo.CardVO;
import com.blog.bbs.vo.ItemVO;
import com.blog.categoryApi.BlogCategoryProxy;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Mario on 2015/9/11.
 */
@Service
public class CardServiceImpl implements CardService {

    private static final Logger logger = Logger.getLogger(CardServiceImpl.class);

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private CardDao cardDao;

    @Autowired
    private BlogCategoryProxy blogCategoryProxy;

    public Map<String, Object> saveCard(String userId, String userName, int itemId, String title, String content) {


        Map<String, Object> reMap = new HashMap<String, Object>();
        try {
            /**
             * 对输入条件进行判断
             */
            //获取版块信息
            ItemVO itemVO = itemDao.queryItemById(itemId);

            //获取版块对应的类别名字
            Map<String,Object> reqMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("categoryId",itemVO.getCategoryId());
            reqMap.put("method","categoryAction.dubbo.queryCategoryById");
            reqMap.put("params",paramMap);
            String rs = blogCategoryProxy.sayHello(JsonUtil.toJson(reqMap));

            Map<String, Object> categoryMap = (Map<String, Object>) JsonUtil.toBean(rs, HashMap.class).get("data");


            if (itemId < 1) {
                reMap = GlobalConfJson.getErrMsgMap("-2", "版块id不正确");
                reMap.put("data", itemVO);
                reMap.put("categoryName", categoryMap.get("name"));
                return reMap;
            }
            if (StringUtil.isNullOrBlank(title)) {
                reMap = GlobalConfJson.getErrMsgMap("-1", "请输入帖子标题");
                reMap.put("data", itemVO);
                reMap.put("categoryName", categoryMap.get("name"));
                return reMap;
            }
            if (StringUtil.isNullOrBlank(content)) {
                reMap = GlobalConfJson.getErrMsgMap("-1", "请输入文章内容");
                reMap.put("data", itemVO);
                reMap.put("categoryName", categoryMap.get("name"));
                return reMap;
            }
            if (title.getBytes("gbk").length > 40) {
                reMap = GlobalConfJson.getErrMsgMap("-1", "帖子标题不能超过40个字符");
                reMap.put("data", itemVO);
                reMap.put("categoryName", categoryMap.get("name"));
                return reMap;
            }

            if (content.getBytes("gbk").length > 500) {
                reMap = GlobalConfJson.getErrMsgMap("-1", "文章内容不能超过500个字符");
                reMap.put("data", itemVO);
                reMap.put("categoryName", categoryMap.get("name"));
                return reMap;
            }

            String contentCopy = content;
            contentCopy = contentCopy.replace("&nbsp;", "");
            contentCopy = contentCopy.replace("<br>", "");
            contentCopy = contentCopy.replace("<p>", "");
            contentCopy = contentCopy.replace("</p>", "");

            contentCopy = contentCopy.trim();
            if (StringUtil.isNullOrBlank(contentCopy)) {
                reMap = GlobalConfJson.getErrMsgMap("-1", "请输入文章内容");
                reMap.put("data", itemVO);
                reMap.put("categoryName", categoryMap.get("name"));
                return reMap;
            }

            CardVO vo = new CardVO();
            vo.setUuid(UUID.randomUUID().toString().replace("-", ""));
            vo.setItemId(itemId);
            vo.setTitle(title);
            vo.setContent(content);

            //获取当前用户信息
            logger.error("userId==" + userId);
            logger.error("userName==" + userName);
            vo.setAuthorId(userId);
            vo.setAuthorName(userName);

            //获取当前系统时间
            Timestamp curTime = new Timestamp(System.currentTimeMillis());
            vo.setCreateTime(curTime);
            vo.setUpdateTime(curTime);
            cardDao.saveCard(vo);

            //存入下一级页面所需要的信息
            reMap = GlobalConfJson.getSuccessMsgMap("1", "存入帖子成功");
            reMap.put("data", itemVO);
            reMap.put("card", vo); //返回存入的帖子信息
            reMap.put("categoryName", categoryMap.get("name"));
            return reMap;
        } catch (Exception e) {
            logger.error("存入帖子失败[SERVICE]:", e);
            return GlobalConfJson.getErrMsgMap("-1", "存入帖子失败");
        }
    }

    public String queryCardList(int itemId, int curPage, int pageSize) {
        List<CardVO> list = new ArrayList<CardVO>();
        Map<String, Object> reMap = new HashMap<String, Object>();
        try {
            //获取帖子列表
            list = cardDao.queryCardList(itemId, (curPage - 1) * pageSize, pageSize);
            List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();
            //对帖子列表进行处理
            if (!list.isEmpty()) {
                for (CardVO vo : list) {
                    Map<String, Object> dataMap = new HashMap<String, Object>();
                    dataMap.put("uuid", vo.getUuid());
                    dataMap.put("title", vo.getTitle());
                    dataMap.put("itemId", vo.getItemId());
                    dataMap.put("authorId", vo.getAuthorId());
                    dataMap.put("authorName", vo.getAuthorName());
                    dataMap.put("createTime", vo.getCreateTime().toString().substring(0, 10));
                    dataMap.put("updateTime", vo.getUpdateTime().toString().substring(0, 10));
                    newList.add(dataMap);
                }
            }
            //计算帖子总数
            int count = cardDao.countCard(itemId);

            //计算分页数据
            if (count % pageSize != 0) {
                count = count / pageSize + 1;
            } else {
                count = count / pageSize;
            }

            //数据返回前台
            reMap = GlobalConfJson.getSuccessMsgMap("-1", "数据查询成功");
            reMap.put("data", newList);
            reMap.put("pageCount", count);
            reMap.put("CurrentPage", curPage);
        } catch (Exception e) {
            logger.error("分页获取帖子列表异常[SERVICE]:", e);
            return GlobalConfJson.getErrMsg();
        }
        return JsonUtil.toJson(reMap);
    }

    public Map<String, Object> queryCardById(String cardId) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        try {
            if (StringUtil.isNullOrBlank(cardId)) {
                return GlobalConfJson.getErrMsgMap("-1", "输入主贴id不能为空");
            }

            CardVO vo = cardDao.queryCardById(cardId);
            reMap = GlobalConfJson.getSuccessMsgMap("1", "获取主贴信息成功");
            Map<String,Object> cardMap = new HashMap<String,Object>();
            cardMap.put("uuid",vo.getUuid());
            cardMap.put("title",vo.getTitle());
            cardMap.put("content",vo.getContent());
            cardMap.put("itemId",vo.getItemId());
            cardMap.put("authorId",vo.getAuthorId());
            cardMap.put("authorName",vo.getAuthorName());
            cardMap.put("createTime",vo.getCreateTime().toString());
            cardMap.put("updateTime",vo.getUpdateTime());
            reMap.put("data", cardMap);
        } catch (Exception e) {
            logger.error("根据id获取主贴信息异常[SERVICE]:", e);
            return GlobalConfJson.getErrMsgMap("-1", "根据id获取主贴信息失败");
        }
        return reMap;
    }
}
