package com.mario.blog.service.interf;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Mario on 2015/9/11.
 */
public interface CardService {
    public Map<String,Object> postCard(int itemId, String title, String content, HttpServletRequest request);

    public String getCardList(int itemId, int curPage, int pageSize);

    public Map<String,Object> getCardById(String cardId);
}
