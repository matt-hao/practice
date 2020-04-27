package com.shiro.source.study.service.impl;

import com.shiro.source.study.dao.IUserRoleDao;
import com.shiro.source.study.domain.UserRole;
import com.shiro.source.study.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Mario on 2016/9/7.
 */
@Service
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private IUserRoleDao userRoleDao;

    @Override
    public UserRole add(UserRole userRole) {
        Objects.requireNonNull(userRole);
        if (!(userRoleDao.add(userRole) > 0))
            throw new IllegalArgumentException("添加用户角色权限错误，the userRole is {" + userRole.toString() + "}");
        return userRole;
    }
}
