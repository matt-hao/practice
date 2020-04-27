package com.blog.user.service.interf;

import java.util.Map;

/**
 * Created by Mario on 2015/9/30.
 */
public interface UserService {
    /**
     *
     * @param email
     * @param name
     * @param password
     * @param comfirmPassword
     * @return
     */
    Map<String, Object> saveUser(String email, String name, String password, String comfirmPassword);

    /**
     *
     * @param email
     * @param password
     * @return
     */
    Map<String, Object> loginUser(String email, String password);

    /**
     *
     * @param email
     * @return
     */
    Map<String, Object> validateUserEmail(String email);

    /**
     *
     * @param name
     * @return
     */
    Map<String, Object> validateUserName(String name);

}
