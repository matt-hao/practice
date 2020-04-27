package com.mario.blog.controller;

import com.mario.blog.itemGroup.ValidateCategoryId;
import com.mario.blog.itemGroup.ValidateItemId;
import com.mario.blog.service.interf.ItemService;
import com.mario.blog.viewModel.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 2015/9/10.
 */
@Controller
@RequestMapping(value = "/item")
public class ItemAction {

    @Autowired
    private ItemService itemService;

    /**
     * @return
     */
    @RequestMapping(value = "/listItemByCategoryId")
    public String listItemByCategoryId( @Validated(value = ValidateCategoryId.class) ItemModel itemModel, BindingResult bindingResult,
                                       Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = itemService.listItemByCategoryId(itemModel.getCategoryId());
        if ("-1".equals(map.get("code"))) {
            return "other/error";
        }
        model.addAttribute("categoryName", map.get("categoryName"));
        model.addAttribute("itemList", map.get("data"));
        return "category/item";
    }

    /**
     * 根据itemId查询版块的详情信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/getItemInfoById")
    public String getItemInfoById(@Validated(value = ValidateItemId.class) ItemModel itemModel,BindingResult bindingResult,
            Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = itemService.getItemInfoById(itemModel.getItemId());
        if ("-1".equals(map.get("code"))) {
            return "other/error";
        }
        model.addAttribute("categoryName", map.get("categoryName"));
        model.addAttribute("item", map.get("data"));
        return "category/itemDetails";
    }
}
