package com.blog.user.controller;


import com.blog.user.service.interf.UserService;
import com.blog.user.util.JsonUtil;
import com.blog.user.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by Mario on 2015/9/30.
 */
@Controller("userAction")
public class UserAction {

    @Autowired
    private UserService userService;

    public String saveUser(Map<String, Object> header, Map<String, Object> params) {
        //获取参数
        String email = MapUtil.getParameter(params, "email", "");
        String name = MapUtil.getParameter(params, "name", "");
        String password = MapUtil.getParameter(params, "password", "");
        String comfirmPassword = MapUtil.getParameter(params, "confirmPassword", "");
        return JsonUtil.toJson(userService.saveUser(email, name, password, comfirmPassword));
    }


    public String loginUser(Map<String, Object> header, Map<String, Object> params) {
        String email = MapUtil.getParameter(params, "email", "");
        String password = MapUtil.getParameter(params, "password", "");
        return JsonUtil.toJson(userService.loginUser(email, password));
    }


    public String validateUserEmail(Map<String, Object> header, Map<String, Object> params) {
        String email = MapUtil.getParameter(params, "email", "");
        return JsonUtil.toJson(userService.validateUserEmail(email));
    }


    public String validateUserName(Map<String, Object> header, Map<String, Object> params) {
        String name = MapUtil.getParameter(params, "name", "");
        return JsonUtil.toJson(userService.validateUserName(name));
    }
}
