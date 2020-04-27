package com.blog.category.controller;

import com.blog.category.service.interf.CategoryService;
import com.blog.category.util.JsonUtil;
import com.blog.category.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by Mario on 2015/10/1.
 */
@Controller("categoryAction")
public class CategoryAction {

    @Autowired
    private CategoryService categoryService;

    public String saveCateGory(Map<String, Object> header, Map<String, Object> params) {
        String name = MapUtil.getParameter(params, "name", "");
        return JsonUtil.toJson(categoryService.saveCategory(name));
    }

    public String queryCategory(Map<String, Object> header, Map<String, Object> params) {
        return JsonUtil.toJson(categoryService.queryCategory());
    }

    public String queryCategoryById(Map<String, Object> header, Map<String, Object> params) {
        String categoryId = MapUtil.getParameter(params, "categoryId", "");
        return JsonUtil.toJson(categoryService.queryCategoryById(categoryId));
    }
}
