package com.blog.bbs.controller;


import com.blog.bbs.service.interf.ItemService;
import com.blog.bbs.util.JsonUtil;
import com.blog.bbs.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by Mario on 2015/9/10.
 */
@Controller("itemAction")
public class ItemAction {

    @Autowired
    private ItemService itemService;

    public String queryItemByCategoryId(Map<String, Object> header, Map<String, Object> params) {
        String categoryId = MapUtil.getParameter(params, "categoryId", "");
        return JsonUtil.toJson(itemService.queryItemByCategoryId(categoryId));
    }

    public String queryItemInfoById(Map<String, Object> header, Map<String, Object> params) {
        int itemId = MapUtil.getIntParameter(params, "itemId", 0);
        return JsonUtil.toJson(itemService.queryItemInfoById(itemId));
    }
}
