package com.mario.blog.controller;

import com.mario.blog.conf.SystemConstant;
import com.mario.blog.service.interf.UserService;
import com.mario.blog.viewModel.RegisterModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 2015/9/9.
 */
@Controller
@RequestMapping(value = "/user")
public class UserAction {

    private static final Logger logger = Logger.getLogger(UserAction.class);

    @Autowired
    private UserService userService;

    /**
     * 进入注册界面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/register")
    public String register(HttpServletRequest request) {
        request.getSession().removeAttribute(SystemConstant.CURRENT_USER);
        return "logReg/register";
    }

    /**
     * 注册用户信息，跳转至登录界面
     *
     * @param registerModel
     * @param model
     * @return
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = userService.saveUser(registerModel);
        logger.error("map==" + map);
        if ("-1".equals(map.get("code"))) {
            return "logReg/register";
        }
        return "logReg/login";
    }

    /**
     * 直接跳转至登录界面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin(HttpServletRequest request) {
        request.getSession().removeAttribute(SystemConstant.CURRENT_USER);
        return "logReg/login";
    }

    /**
     * 登录验证，验证成功，跳转至首页
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(RegisterModel registerModel, BindingResult bindingResult, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map = userService.loginUser(registerModel, request);
        if ("-1".equals(map.get("code"))) {
            model.addAttribute("email", registerModel.getEmail());
//            model.addAttribute("validateMessage",new String(new String((String)map.get("message")).getBytes("gbk"),"UTF-8"));
            model.addAttribute("validateMessage", (String) map.get("message"));
            return "logReg/login";
        }
        model.addAttribute("userInfo", map.get("data"));
        return "index";
    }


    /**
     * 验证邮箱是否重复
     *
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/validateEmail", produces = "application/json;charset=UTF-8")
    public String validateUserEmail(
            @RequestParam(value = "email", required = false, defaultValue = "") String email) {
        Map<String, Object> map = userService.validateUserEmail(email);

        if ("-1".equals(map.get("code"))) {
            return "{ \"valid\":false}";
        } else {
            return "{ \"valid\":true}";
        }
    }

    /**
     * 验证用户名是否重复
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/validateName", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String validateUserName(
            @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        Map<String, Object> map = userService.validateUserName(name);

        if ("-1".equals(map.get("code"))) {
            return "{ \"valid\":false}";
        } else {
            return "{ \"valid\":true}";
        }
    }

    @RequestMapping(value = "/backToNoLogin")
    public String noLogin(HttpServletRequest request) {
        request.getSession().removeAttribute(SystemConstant.CURRENT_USER);
        return "index";
    }
}
