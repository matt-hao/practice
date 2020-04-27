package com.mario.blog.service.impl;

import com.mario.blog.conf.SystemConstant;
import com.mario.blog.dao.interf.ProxyDao;
import com.mario.blog.service.interf.CardService;
import com.mario.blog.util.GlobalConfJson;
import com.mario.blog.util.JsonUtil;
import com.mario.blog.util.StringUtil;
import com.mario.blog.vo.UserVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 2015/9/11.
 */
@Service
public class CardServiceImpl implements CardService {

    private static final Logger logger = Logger.getLogger(CardServiceImpl.class);

    @Autowired
    private ProxyDao proxyDao;

    public Map<String, Object> postCard(int itemId, String title, String content, HttpServletRequest request) {
        String rs = null;
        try {
            Map<String,Object> reqMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            Map<String,Object> headerMap = new HashMap<String,Object>();
            Map<String,Object> userMap = (Map<String, Object>) request.getSession().getAttribute(SystemConstant.CURRENT_USER);
            headerMap.put("userId",userMap.get("uuid"));
            headerMap.put("userName",userMap.get("name"));
            paramMap.put("itemId",itemId);
            paramMap.put("title",title);
            paramMap.put("content",content);
            reqMap.put("header",headerMap);
            reqMap.put("method","cardAction.dubbo.saveCard");
            reqMap.put("params",paramMap);
            rs = proxyDao.bbsDaoProxy(reqMap);
        } catch (Exception e) {
            logger.error("存入帖子失败[SERVICE]:", e);
            return GlobalConfJson.getErrMsgMap("-1", "存入帖子失败");
        }
        return JsonUtil.toBean(rs,HashMap.class);
    }

    public String getCardList(int itemId, int curPage, int pageSize) {
        String rs = null;
        try {
            Map<String,Object> reqMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("itemId",itemId);
            paramMap.put("curPage",curPage);
            paramMap.put("pageSize",pageSize);
            reqMap.put("method","cardAction.dubbo.queryCardList");
            reqMap.put("params",paramMap);
            rs = proxyDao.bbsDaoProxy(reqMap);
        } catch (Exception e) {
            logger.error("分页获取帖子列表异常[SERVICE]:", e);
            return GlobalConfJson.getErrMsg();
        }
        return rs;
    }

    public Map<String, Object> getCardById(String cardId) {
        String rs = null;
        try {
            if (StringUtil.isNullOrBlank(cardId)) {
                return GlobalConfJson.getErrMsgMap("-1", "输入主贴id不能为空");
            }
            Map<String,Object> reqMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("cardId",cardId);
            reqMap.put("method","cardAction.dubbo.queryCardById");
            reqMap.put("params",paramMap);
            rs = proxyDao.bbsDaoProxy(reqMap);
        } catch (Exception e) {
            logger.error("根据id获取主贴信息异常[SERVICE]:", e);
            return GlobalConfJson.getErrMsgMap("-1", "根据id获取主贴信息失败");
        }
        return JsonUtil.toBean(rs,HashMap.class);
    }
}
