package com.mario.blog.service.impl;

import com.mario.blog.conf.SystemConstant;
import com.mario.blog.dao.interf.ProxyDao;
import com.mario.blog.service.interf.UserService;
import com.mario.blog.util.GlobalConfJson;
import com.mario.blog.util.JsonUtil;
import com.mario.blog.util.MD5Util;
import com.mario.blog.util.StringUtil;
import com.mario.blog.viewModel.RegisterModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 2015/9/9.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private ProxyDao proxyDao;

    public Map<String, Object> saveUser(RegisterModel registerModel) {
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            if (!registerModel.getPassword().equals(registerModel.getComfirmPassword())) {
                return GlobalConfJson.getErrMsgMap("-1", "两次密码输入不一致");
            }
            Map<String,Object> reMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("email",registerModel.getEmail());
            paramMap.put("name", registerModel.getName());
            paramMap.put("password", registerModel.getPassword());
            paramMap.put("confirmPassword", registerModel.getComfirmPassword());
            reMap.put("params",paramMap);
            reMap.put("method", "userAction.dubbo.saveUser");

            String rs = proxyDao.userDaoProxy(reMap);
            resultMap = JsonUtil.toBean(rs,HashMap.class);
        } catch (Exception e) {
            logger.error("存入用户注册信息异常[SERVICE]:", e);
            return GlobalConfJson.getErrMsgMap("-1", "存入用户信息异常");
        }
        return resultMap;
    }

    public Map<String, Object> loginUser(RegisterModel registerModel, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {

            //对数据进行手动校验
            if (StringUtil.isNullOrBlank(registerModel.getEmail())) {
                return GlobalConfJson.getErrMsgMap("-1", "输入邮箱不能为空");
            }
            if (StringUtil.isNullOrBlank(registerModel.getPassword())) {
                return GlobalConfJson.getErrMsgMap("-1", "输入密码不能为空");
            }
            Map<String,Object> reMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("email", registerModel.getEmail());
            paramMap.put("password", MD5Util.GetMD5Code(registerModel.getPassword()));
            reMap.put("method", "userAction.dubbo.loginUser");
            reMap.put("params",paramMap);

            String rs = proxyDao.userDaoProxy(reMap);
            resultMap = JsonUtil.toBean(rs,HashMap.class);

            //将登录成功的当前用户数据写入会话session,设置session超时时间为30分钟。
            request.getSession().setMaxInactiveInterval(1800);
            request.getSession().setAttribute(SystemConstant.CURRENT_USER, resultMap.get("data"));
        } catch (Exception e) {
            logger.error("用户登录验证异常", e);
            return GlobalConfJson.getErrMsgMap("-1", "用户登录校验异常");
        }
        return resultMap;
    }

    public Map<String, Object> validateUserEmail(String email) {
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            Map<String,Object> reMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("email",email);
            reMap.put("method","userAction.dubbo.validateUserEmail");
            reMap.put("params",paramMap);

            String rs = proxyDao.userDaoProxy(reMap);
            resultMap = JsonUtil.toBean(rs,HashMap.class);

        } catch (Exception e) {
            logger.error("验证邮箱是否重复异常", e);
            return GlobalConfJson.getErrMsgMap("-1", "验证用户名是否重复异常");
        }
        return resultMap;
    }

    public Map<String, Object> validateUserName(String name) {
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            Map<String,Object> reMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("name",name);
            reMap.put("method","userAction.dubbo.validateUserName");
            reMap.put("params",paramMap);

            String rs = proxyDao.userDaoProxy(reMap);
            resultMap = JsonUtil.toBean(rs,HashMap.class);
        } catch (Exception e) {
            logger.error("验证用户名是否重复异常", e);
            return GlobalConfJson.getErrMsgMap("-1", "验证名字是否重复异常");
        }
        return resultMap;
    }
}
