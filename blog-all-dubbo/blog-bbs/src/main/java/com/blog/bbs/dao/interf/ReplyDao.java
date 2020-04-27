package com.blog.bbs.dao.interf;

import com.blog.bbs.vo.ReplyVO;

import java.util.List;

/**
 * Created by Mario on 2015/10/8.
 */
public interface ReplyDao {
    void saveReply(ReplyVO replyVO);

    List<ReplyVO> queryReplyListById(String cardId,int start,int end);

    int countReply(String cardId);
}
