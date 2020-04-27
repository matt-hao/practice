package com.mario.blog.service.impl;

import com.mario.blog.conf.SystemConstant;
import com.mario.blog.dao.interf.ProxyDao;
import com.mario.blog.service.interf.ReplyService;
import com.mario.blog.util.GlobalConfJson;
import com.mario.blog.util.JsonUtil;
import com.mario.blog.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 2015/9/14.
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    private static final Logger logger = Logger.getLogger(ReplyServiceImpl.class);

    @Autowired
    private ProxyDao proxyDao;

    public Map<String, Object> insertReply(String cardId, String content, HttpServletRequest request) {
        String rs = null;
        try {
            //对条件进行判断
            if (StringUtil.isNullOrBlank(cardId)) {
                return GlobalConfJson.getErrMsgMap("-1", "输入帖子id不能为空");
            }
            if (StringUtil.isNullOrBlank(content)) {
                return GlobalConfJson.getErrMsgMap("-1", "输入回帖内容不能为空");
            }

            Map<String, Object> reqMap = new HashMap<String, Object>();
            Map<String, Object> paramMap = new HashMap<String, Object>();
            Map<String, Object> headerMap = new HashMap<String,Object>();
            //获取用户信息
            Map<String,Object> userMap = (Map<String, Object>) request.getSession().getAttribute(SystemConstant.CURRENT_USER);
            headerMap.put("userId", userMap.get("uuid"));
            headerMap.put("userName", userMap.get("name"));
            paramMap.put("cardId", cardId);
            paramMap.put("content", content);
            reqMap.put("method", "replyAction.dubbo.saveReply");
            reqMap.put("params", paramMap);
            reqMap.put("header",headerMap);

            rs = proxyDao.bbsDaoProxy(reqMap);
        } catch (Exception e) {
            logger.error("存入回复信息异常[SERVICE]:", e);
        }
        return JsonUtil.toBean(rs, HashMap.class);
    }

    public String getReplyListById(String cardId, int curPage, int pageSize) {
       String rs = null;
        try {
            if (StringUtil.isNullOrBlank(cardId)) {
                return GlobalConfJson.getSuccessMsgString("-1", "传入帖子id不能为空");
            }
            Map<String, Object> reqMap = new HashMap<String, Object>();
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("cardId",cardId);
            paramMap.put("curPage",curPage);
            paramMap.put("pageSize",pageSize);
            reqMap.put("method","replyAction.dubbo.queryReplyListById");
            reqMap.put("params",paramMap);
            rs = proxyDao.bbsDaoProxy(reqMap);
        } catch (Exception e) {
            logger.error("分页获取回复列表异常[SERVICE]:", e);
            return GlobalConfJson.getErrMsg();
        }
        return rs;
    }
}
