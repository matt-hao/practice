package com.blog.user.service.impl;


import com.blog.user.dao.interf.UserDao;
import com.blog.user.service.interf.UserService;
import com.blog.user.util.GlobalConfJson;
import com.blog.user.util.MD5Util;
import com.blog.user.util.StringUtil;
import com.blog.user.vo.UserVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Mario on 2015/9/30.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    public Map<String, Object> saveUser(String email, String name, String password, String confirmPassword) {
        try {
            //数据校验
            if (StringUtil.isNullOrBlank(email)) {
                return GlobalConfJson.getErrMsgMap("-1", "输入email不能为空");
            }

            if (StringUtil.isNullOrBlank(name)) {
                return GlobalConfJson.getErrMsgMap("-1", "输入name不能为空");
            }

            if (StringUtil.isNullOrBlank(password)) {
                return GlobalConfJson.getErrMsgMap("-1", "输入password不能为空");
            }

            if (StringUtil.isNullOrBlank(confirmPassword)) {
                return GlobalConfJson.getErrMsgMap("-1", "输入confirmPassowrd不能为空");
            }

            if (!password.equals(confirmPassword)) {
                return GlobalConfJson.getErrMsgMap("-1", "两次输入密码不一致");
            }

            //对密码进行加密
            String md5Pwd = MD5Util.GetMD5Code(password);

            //存入数据
            UserVO vo = new UserVO();
            vo.setUuid(UUID.randomUUID().toString().replace("-", ""));
            vo.setEmail(email);
            vo.setName(name);
            vo.setPassword(md5Pwd);
            Timestamp curTime = new Timestamp(System.currentTimeMillis());
            vo.setCreateTime(curTime);
            vo.setUpdateTime(curTime);
            userDao.saveUser(vo);
        } catch (Exception e) {
            logger.error("存入用户信息异常[service]", e);
            return GlobalConfJson.getErrMsgMap("-1", "存入用户信息失败");
        }
        return GlobalConfJson.getSuccessMsgMap("1", "存入用户注册信息成功");
    }

    public Map<String, Object> loginUser(String email, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //数据校验
            if (StringUtil.isNullOrBlank(email)) {
                return GlobalConfJson.getErrMsgMap("-1", "输入email不能为空");
            }
            if (StringUtil.isNullOrBlank(password)) {
                return GlobalConfJson.getErrMsgMap("-1", "输入password不能为空");
            }

            UserVO userVO = new UserVO();
            userVO.setEmail(email);
            userVO.setPassword(password);

            UserVO vo = userDao.validatelogin(userVO);
            if (vo == null) {
                return GlobalConfJson.getErrMsgMap("-1", "用户名或密码错误");
            }

            map = GlobalConfJson.getSuccessMsgMap("1", "登录成功");
            map.put("data", vo);
        } catch (Exception e) {
            logger.error("用户登录校验异常[service]", e);
            return GlobalConfJson.getErrMsgMap("-1", "用户登录校验失败");
        }
        return map;
    }

    public Map<String, Object> validateUserEmail(String email) {
        try {
            List<UserVO> list = userDao.validateUserEmail(email);
            if (!list.isEmpty()) {
                return GlobalConfJson.getErrMsgMap("-1", "该账号已经被注册");
            }
        } catch (Exception e) {
            logger.error("验证邮箱是否重复异常[service]", e);
            return GlobalConfJson.getErrMsgMap("-1", "验证邮箱是否重复失败");
        }
        return GlobalConfJson.getSuccessMsgMap("1", "该账号可以被注册");
    }

    public Map<String, Object> validateUserName(String name) {
        try {
            List<UserVO> list = userDao.validateUserName(name);
            if (!list.isEmpty()) {
                return GlobalConfJson.getErrMsgMap("-1", "该名字已被注册");
            }
        } catch (Exception e) {
            logger.error("验证用户名是否重复异常[service]", e);
            return GlobalConfJson.getErrMsgMap("-1", "验证用户名是否重复失败");
        }
        return GlobalConfJson.getSuccessMsgMap("1", "该名字可以被注册");
    }

}
