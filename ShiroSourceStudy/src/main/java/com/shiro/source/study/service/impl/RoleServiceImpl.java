package com.shiro.source.study.service.impl;

import com.shiro.source.study.dao.IRoleDao;
import com.shiro.source.study.domain.Role;
import com.shiro.source.study.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Mario on 2016/9/7.
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public Role findById(Long id) {
        Objects.requireNonNull(id);
        return roleDao.findById(id);
    }

    @Override
    public Role findByName(String name) {
        Objects.requireNonNull(name);
        return roleDao.findByName(name);
    }
}
