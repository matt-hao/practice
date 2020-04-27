package com.shiro.source.study.service.impl;

import com.shiro.source.study.dao.IAdminDao;
import com.shiro.source.study.domain.Admin;
import com.shiro.source.study.service.IAdminService;
import com.shiro.source.study.shiro.EncryptUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * Created by Mario on 2016/9/7.
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private EncryptUser<Admin> encryptUser;

    @Autowired
    private IAdminDao adminDao;

    @Override
    @Transactional
    public Admin add(Admin admin) {
        Objects.requireNonNull(admin);
        if (adminDao.findByAccount(admin.getAccount()) != null)
            throw new IllegalArgumentException("账号为" + admin.getAccount() + "的admin已经存在");
        encryptUser.encrypt(admin);
        if (!(adminDao.add(admin) > 0))
            throw new IllegalArgumentException("添加admin失败");
        return admin;
    }

    @Override
    public Admin findByAccount(String account) {
        Objects.requireNonNull(account);
        return adminDao.findByAccount(account);
    }

    @Override
    public Admin findWithPermission(Long id) {
        Objects.requireNonNull(id);
        return adminDao.findWithPermission(id);
    }
}
