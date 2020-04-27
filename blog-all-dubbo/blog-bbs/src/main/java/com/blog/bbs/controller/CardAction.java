package com.blog.bbs.controller;


import com.blog.bbs.service.interf.CardService;
import com.blog.bbs.util.JsonUtil;
import com.blog.bbs.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by Mario on 2015/9/11.
 */
@Controller("cardAction")
public class CardAction {

    @Autowired
    private CardService cardService;

    public String saveCard(Map<String, Object> header, Map<String, Object> params) {
        String userId = MapUtil.getParameter(header, "userId", "");
        String userName = MapUtil.getParameter(header, "userName", "");
        int itemId = MapUtil.getIntParameter(params, "itemId", 0);
        String title = MapUtil.getParameter(params, "title", "");
        String content = MapUtil.getParameter(params, "content", "");
        return JsonUtil.toJson(cardService.saveCard(userId, userName, itemId, title, content));
    }


    public String queryCardList(Map<String, Object> header, Map<String, Object> params) {
        int itemId = MapUtil.getIntParameter(params, "itemId", 0);
        int curPage = MapUtil.getIntParameter(params, "curPage", 1);
        int pageSize = MapUtil.getIntParameter(params, "pageSize", 10);
        return cardService.queryCardList(itemId, curPage, pageSize);
    }

    public String queryCardById(Map<String, Object> header, Map<String, Object> params) {
        String cardId = MapUtil.getParameter(params, "cardId", "");
        return JsonUtil.toJson(cardService.queryCardById(cardId));
    }
}
