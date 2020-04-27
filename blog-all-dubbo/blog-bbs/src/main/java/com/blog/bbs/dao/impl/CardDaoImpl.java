package com.blog.bbs.dao.impl;

import com.blog.bbs.dao.interf.CardDao;
import com.blog.bbs.vo.CardVO;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario on 2015/10/8.
 */
@Repository
public class CardDaoImpl extends BaseDao implements CardDao {

    private static final Logger logger = Logger.getLogger(CardDaoImpl.class);

    public void saveCard(CardVO vo) {
        try{
            this.getSqlSession().insert("com.mario.blog.mapper.CardMapper.saveCard",vo);
        }catch (Exception e){
            logger.error("存入card异常[dao]",e);
        }
    }

    public List<CardVO> queryCardList(int itemId, int start, int end) {
        List<CardVO> list = new ArrayList<CardVO>();
        try{
            list = this.getSqlSession().selectList("com.mario.blog.mapper.CardMapper.queryCardList",itemId,new RowBounds(start,end));
        }catch (Exception e){
            logger.error("分页查询帖子列表异常[dao]",e);
        }
        return list;
    }

    public int countCard(int itemId) {
        int count = 0;
        try{
            count = this.getSqlSession().selectOne("com.mario.blog.mapper.CardMapper.countCard",itemId);
        }catch (Exception e){
            logger.error("根据itemId计数card异常[dao]",e);
        }
        return count;
    }

    public CardVO queryCardById(String cardId) {
        CardVO cardVO = null;
        try{
            cardVO = this.getSqlSession().selectOne("com.mario.blog.mapper.CardMapper.queryCardById", cardId);
        }catch (Exception e){
            logger.error("根据cardId查询card信息异常[dao]",e);
        }
        return cardVO;
    }
}
