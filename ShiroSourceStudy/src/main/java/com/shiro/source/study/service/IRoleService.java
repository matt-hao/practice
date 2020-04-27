package com.shiro.source.study.service;

import com.shiro.source.study.domain.Role;

/**
 * Created by Mario on 2016/9/7.
 */
public interface IRoleService {
    /**
     * 根据id查询role
     *
     * @param id
     * @return
     */
    Role findById(Long id);

    /**
     * 根据角色名称查询role
     *
     * @param name
     * @return
     */
    Role findByName(String name);
}
