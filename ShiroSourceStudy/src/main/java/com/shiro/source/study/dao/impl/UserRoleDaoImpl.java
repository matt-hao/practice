package com.shiro.source.study.dao.impl;

import com.shiro.source.study.dao.IUserRoleDao;
import com.shiro.source.study.domain.UserRole;
import org.springframework.stereotype.Repository;

/**
 * Created by Mario on 2016/9/7.
 */
@Repository
public class UserRoleDaoImpl extends BaseDao implements IUserRoleDao {
    @Override
    public Integer add(UserRole userRole) {
        return this.sqlSessionTemplate.insert("com.shiro.source.study.dao.impl.UserRoleDaoImpl.insert", userRole);
    }
}
