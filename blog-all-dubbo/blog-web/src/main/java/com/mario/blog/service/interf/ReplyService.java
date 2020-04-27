package com.mario.blog.service.interf;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Mario on 2015/9/14.
 */
public interface ReplyService {
    public Map<String, Object> insertReply(String cardId, String content, HttpServletRequest request);

    public String getReplyListById(String cardId, int curPage, int pageSize);
}
