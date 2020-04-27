package com.blog.bbs.service.impl;


import com.blog.bbs.dao.interf.ReplyDao;
import com.blog.bbs.service.interf.ReplyService;
import com.blog.bbs.util.GlobalConfJson;
import com.blog.bbs.util.JsonUtil;
import com.blog.bbs.util.StringUtil;
import com.blog.bbs.vo.ReplyVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mario on 2015/9/14.
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    private static  final Logger logger = Logger.getLogger(ReplyServiceImpl.class);

    @Autowired
    private ReplyDao replyDao;

    public Map<String, Object> saveReply(String userId,String userName,String cardId, String content) {
        try {
        //对条件进行判断
        if(StringUtil.isNullOrBlank(cardId)){
            return GlobalConfJson.getErrMsgMap("-1","输入帖子id不能为空");
        }
        if(StringUtil.isNullOrBlank(content)){
            return GlobalConfJson.getErrMsgMap("-1","输入回帖内容不能为空");
        }

        ReplyVO vo = new ReplyVO();

        //获取用户信息
        vo.setContent(content);
        vo.setCardId(cardId);
        vo.setReplyId(0);

        //获取用户信息
        vo.setAuthorId(userId);
        vo.setAuthorName(userName);

        //获取当前时间
        Timestamp curTime = new Timestamp(System.currentTimeMillis());
        vo.setCreateTime(curTime);

        //存入回复信息
        replyDao.saveReply(vo);

        }catch (Exception e){
            logger.error("存入回复信息异常[SERVICE]:",e);
        }

        return GlobalConfJson.getSuccessMsgMap("1","存入回复数据成功");
    }

    public String queryReplyListById(String cardId, int curPage, int pageSize) {
        List<ReplyVO> list = new ArrayList<ReplyVO>();
        Map<String,Object> reMap = new HashMap<String,Object>();
        try{
            if(StringUtil.isNullOrBlank(cardId)){
                return GlobalConfJson.getSuccessMsgString("-1", "传入帖子id不能为空");
            }
            //获取回复列表
            list = replyDao.queryReplyListById(cardId,(curPage-1)*pageSize,pageSize);
            List<Map<String,Object>> newList = new ArrayList<Map<String,Object>>();
            //对回复列表进行数据处理
            for (ReplyVO vo: list){
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("id",vo.getId());
                map.put("replyContent",vo.getContent());
                map.put("cardId",vo.getCardId());
                map.put("authorId",vo.getAuthorId());
                map.put("authorName",vo.getAuthorName());
                map.put("replyId",vo.getReplyId());
                map.put("createTime",vo.getCreateTime().toString().substring(0, 19));
                newList.add(map);
            }
            //计算回复总数
            int count = replyDao.countReply(cardId);

            //计算分页数据
            if (count % pageSize != 0) {
                count = count / pageSize + 1;
            } else {
                count = count / pageSize;
            }

            //返回数据到前台
            reMap = GlobalConfJson.getSuccessMsgMap("-1","数据查询成功");
            reMap.put("data",newList);
            reMap.put("pageCount",count);
            reMap.put("CurrentPage",curPage);
        }catch (Exception e ){
            logger .error("分页获取回复列表异常[SERVICE]:",e);
            return  GlobalConfJson.getErrMsg();
        }
        return JsonUtil.toJson(reMap);
    }
}
