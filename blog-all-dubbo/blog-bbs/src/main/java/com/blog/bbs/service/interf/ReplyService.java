package com.blog.bbs.service.interf;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Mario on 2015/9/14.
 */
public interface ReplyService {
     Map<String, Object> saveReply(String userId,String userName,String cardId, String content);

     String queryReplyListById(String cardId, int curPage, int pageSize);
}
