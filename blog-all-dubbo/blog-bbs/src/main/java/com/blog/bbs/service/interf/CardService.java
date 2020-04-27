package com.blog.bbs.service.interf;

import java.util.Map;

/**
 * Created by Mario on 2015/9/11.
 */
public interface CardService {
     Map<String,Object> saveCard(String userId,String userName,int itemId, String title, String content);

     String queryCardList(int itemId, int curPage, int pageSize);

     Map<String,Object> queryCardById(String cardId);
}
