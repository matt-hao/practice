package com.shiro.source.study.dao;

import com.shiro.source.study.domain.Admin;

/**
 * Created by Mario on 2016/9/7.
 */
public interface IAdminDao {
    /**
     * 添加admin
     *
     * @param admin
     * @return
     */
    Integer add(Admin admin);

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

