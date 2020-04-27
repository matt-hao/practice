package com.shiro.source.study.dao.impl;

import com.shiro.source.study.dao.IRoleDao;
import com.shiro.source.study.domain.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by Mario on 2016/9/7.
 */
@Repository
public class RoleDaoImpl extends BaseDao implements IRoleDao {
    @Override
    public Role findById(Long id) {
        return this.sqlSessionTemplate.selectOne("com.shiro.source.study.dao.impl.RoleDaoImpl.findById", id);
    }

    @Override
    public Role findByName(String name) {
        return this.sqlSessionTemplate.selectOne("com.shiro.source.study.dao.impl.RoleDaoImpl.findByName", name);
    }
}
