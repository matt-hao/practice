package com.shiro.source.study.dao;

import com.shiro.source.study.domain.UserRole;

/**
 * Created by Mario on 2016/9/7.
 */
public interface IUserRoleDao {

    /**
     * 添加用户角色
     *
     * @param userRole
     * @return
     */
    Integer add(UserRole userRole);
}
