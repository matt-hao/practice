package com.blog.user.dao.impl;


import com.blog.user.dao.interf.UserDao;
import com.blog.user.vo.UserVO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mario on 2015/9/30.
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    public void saveUser(UserVO userVO) {
        try {
            this.getSqlSession().insert("com.mario.blog.mapper.UserMapper.saveUser", userVO);
        } catch (Exception e) {
            logger.error("存入用户数据异常[dao]", e);
        }
    }

    public UserVO validatelogin(UserVO userVO) {
        UserVO vo;
        try{
            vo = this.getSqlSession().selectOne("com.mario.blog.mapper.UserMapper.validateLogin", userVO);
        }catch (Exception e){
            logger.error("用户登录校验异常[dao]",e);
            return null;
        }
        return vo;
    }

    public List<UserVO> validateUserEmail(String email) {
        List<UserVO> list = new ArrayList<UserVO>();
        try{
            list = this.getSqlSession().selectList("com.mario.blog.mapper.UserMapper.validateUserEmail",email);
        }catch (Exception e){
            logger.error("验证邮箱是否重复异常[dao]",e);
        }
        return list;
    }

    public List<UserVO> validateUserName(String name) {
        List<UserVO> list = new ArrayList<UserVO>();
        try{
            list = this.getSqlSession().selectList("com.mario.blog.mapper.UserMapper.validateUserName",name);
        }catch (Exception e){
            logger.error("验证用户名是否重复异常[dao]",e);
        }
        return list;
    }
}
