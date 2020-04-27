package com.shiro.source.study.controller;

import com.shiro.source.study.pojo.form.SignInForm;
import com.shiro.source.study.shiro.ShiroRelam;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Mario on 2016/7/13.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    /**
     * 登陆接口
     *
     * @param signInForm
     */
    @ResponseBody
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(SignInForm signInForm) {
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(signInForm.getUserName(), signInForm.getPassword(), signInForm.getHost());
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            logger.error("signIn the wrong credential");
            e.printStackTrace();
            return "fail";
        } catch (Exception e) {
            logger.error("server internal error");
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "t_p_1")
    @RequiresPermissions(value = "teacher_permission1")
    public String teacher_per() {
        Subject subject = SecurityUtils.getSubject();
        ShiroRelam.ShiroUser shiroUser = (ShiroRelam.ShiroUser) subject.getPrincipals().getPrimaryPrincipal();
        logger.debug("current user is " + shiroUser.toString());
        return shiroUser.toString();
    }

    @ResponseBody
    @RequestMapping(value = "s_p_1")
    @RequiresPermissions(value = "student_permission1")
    public String student_per() {
        Subject subject = SecurityUtils.getSubject();
        ShiroRelam.ShiroUser shiroUser = (ShiroRelam.ShiroUser) subject.getPrincipals().getPrimaryPrincipal();
        logger.debug("current user is " + shiroUser.toString());
        return shiroUser.toString();
    }
}

