package com.shiro.source.study.service;

import com.shiro.source.study.domain.Admin;

/**
 * Created by Mario on 2016/9/7.
 */
public interface IAdminService {
    /**
     * 添加admin
     *
     * @param admin
     * @return
     */
    Admin add(Admin admin);

    /**
     * 根据account查询admin
     *
     * @param account
     * @return
     */
    Admin findByAccount(String account);

    /**
     * 根据id查询admin信息,带权限
     *
     * @param id
     * @return
     */
    Admin findWithPermission(Long id);
}
