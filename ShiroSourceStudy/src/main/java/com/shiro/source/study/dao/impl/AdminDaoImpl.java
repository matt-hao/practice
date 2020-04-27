package com.shiro.source.study.dao.impl;

import com.shiro.source.study.dao.IAdminDao;
import com.shiro.source.study.domain.Admin;
import org.springframework.stereotype.Repository;

/**
 * Created by Mario on 2016/9/7.
 */
@Repository
public class AdminDaoImpl extends BaseDao implements IAdminDao {
    @Override
    public Integer add(Admin admin) {
        return this.sqlSessionTemplate.insert("com.shiro.source.study.dao.impl.AdminDaoImpl.insert", admin);
    }

    @Override
    public Admin findByAccount(String account) {
        return this.sqlSessionTemplate.selectOne("com.shiro.source.study.dao.impl.AdminDaoImpl.findByAccount", account);
    }

    @Override
    public Admin findWithPermission(Long id) {
        return this.sqlSessionTemplate.selectOne("com.shiro.source.study.dao.impl.AdminDaoImpl.find", id);
    }
}
