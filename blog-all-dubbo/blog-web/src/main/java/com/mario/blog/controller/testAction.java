package com.mario.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mario on 2015/9/10.
 */
@Controller
public class testAction {

    @RequestMapping(value = "/topbar")
    public String topbar(){
        return "common/topBar";
    }

    @RequestMapping(value = "/item")
    public String item(){
        return "category/item";
    }

    @RequestMapping(value = "/itemDetails")
    public String itemDetails(){
        return "category/itemDetails";
    }

    @RequestMapping(value = "/cardDetails")
    public String cardDetails(){
        return "card/cardDetails";
    }

    @RequestMapping(value = "/postCard")
    public String postCard(){
        return "card/postCard";
    }
}
