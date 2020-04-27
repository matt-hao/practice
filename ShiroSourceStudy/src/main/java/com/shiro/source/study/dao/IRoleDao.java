package com.shiro.source.study.dao;

import com.shiro.source.study.domain.Role;

/**
 * Created by Mario on 2016/9/7.
 */
public interface IRoleDao {
    /**
     * 根据id查询角色
     *
     * @param id
     * @return
     */
    Role findById(Long id);

    /**
     * 根据角色名称查询角色信息
     *
     * @param name
     * @return
     */
    Role findByName(String name);
}
