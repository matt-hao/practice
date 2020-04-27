package com.blog.user.dao.interf;


import com.blog.user.vo.UserVO;

import java.util.List;

/**
 * Created by Mario on 2015/9/30.
 */
public interface UserDao {
    void saveUser(UserVO userVO);

    UserVO validatelogin(UserVO userVO);

    List<UserVO> validateUserEmail(String email);

    List<UserVO> validateUserName(String name);
}
