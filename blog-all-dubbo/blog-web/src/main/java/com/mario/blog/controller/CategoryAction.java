package com.mario.blog.controller;

import com.mario.blog.service.interf.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Mario on 2015/9/10.
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryAction {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/addCategory")
    @ResponseBody
    public String addCateGory(
            @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        return categoryService.addCategory(name);
    }

    @RequestMapping(value = "/listCategory")
    @ResponseBody
    public String listCategory() {
        return categoryService.listCategory();
    }


}
