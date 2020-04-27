package com.blog.bbs.dao.interf;

import com.blog.bbs.vo.CardVO;

import java.util.List;

/**
 * Created by Mario on 2015/10/8.
 */
public interface CardDao {
    void saveCard(CardVO vo);

    List<CardVO> queryCardList(int itemId,int start,int end);

    int countCard(int itemId);

    CardVO queryCardById(String cardId);
}
