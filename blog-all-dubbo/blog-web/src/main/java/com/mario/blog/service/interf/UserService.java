package com.mario.blog.service.interf;

import com.mario.blog.viewModel.RegisterModel;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Mario on 2015/9/9.
 */
public interface UserService {
    public Map<String, Object> saveUser(RegisterModel registerModel);

    public Map<String, Object> validateUserEmail(String email);

    public Map<String, Object> validateUserName(String name);

    public Map<String, Object> loginUser(RegisterModel registerModel, HttpServletRequest request);
}
