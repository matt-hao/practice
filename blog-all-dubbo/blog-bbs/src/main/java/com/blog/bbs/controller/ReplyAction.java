package com.blog.bbs.controller;

import com.blog.bbs.service.interf.ReplyService;
import com.blog.bbs.util.JsonUtil;
import com.blog.bbs.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Mario on 2015/9/14.
 */
@Controller("replyAction")
public class ReplyAction {

    @Autowired
    private ReplyService replyService;

    public String saveReply(Map<String, Object> header, Map<String, Object> params) {
        String userId = MapUtil.getParameter(header, "userId", "");
        String userName = MapUtil.getParameter(header, "userName", "");
        String cardId = MapUtil.getParameter(params, "cardId", "");
        String content = MapUtil.getParameter(params, "content", "");
        Map<String, Object> map = replyService.saveReply(userId, userName, cardId, content);
        return JsonUtil.toJson(map);
    }

    public String queryReplyListById(Map<String, Object> header, Map<String, Object> params) {
        String cardId = MapUtil.getParameter(params, "cardId", "");
        int curPage = MapUtil.getIntParameter(params, "curPage", 1);
        int pageSize = MapUtil.getIntParameter(params, "pageSize", 10);
        return replyService.queryReplyListById(cardId, curPage, pageSize);
    }
}
