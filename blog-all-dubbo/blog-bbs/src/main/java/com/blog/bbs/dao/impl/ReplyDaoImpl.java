package com.blog.bbs.dao.impl;

import com.blog.bbs.dao.interf.ReplyDao;
import com.blog.bbs.service.interf.ReplyService;
import com.blog.bbs.vo.ReplyVO;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mario on 2015/10/8.
 */
@Repository
public class ReplyDaoImpl extends BaseDao implements ReplyDao {

    private static final Logger logger = Logger.getLogger(ReplyDaoImpl.class);

    public void saveReply(ReplyVO replyVO) {
        try {
            this.getSqlSession().insert("com.mario.blog.mapper.ReplyMapper.saveReply", replyVO);
        } catch (Exception e) {
            logger.error("存入回复异常[dao]", e);
        }
    }

    public List<ReplyVO> queryReplyListById(String cardId, int start, int end) {
        List<ReplyVO> list = new ArrayList<ReplyVO>();
        try {
            list = this.getSqlSession().selectList("com.mario.blog.mapper.ReplyMapper.queryReplyListById", cardId, new RowBounds(start, end));
        } catch (Exception e) {
            logger.error("查询回复列表异常[dao]", e);
        }
        return list;
    }

    public int countReply(String cardId) {
        int count = 0;
        try {
            count = this.getSqlSession().selectOne("com.mario.blog.mapper.ReplyMapper.countReply", cardId);
        } catch (Exception e) {
            logger.error("计数回复列表异常[dao]", e);
        }
        return count;
    }
}
