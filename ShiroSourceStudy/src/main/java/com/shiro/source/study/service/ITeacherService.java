package com.shiro.source.study.service;


import com.shiro.source.study.domain.Teacher;

/**
 * Created by Mario on 2016/7/6.
 */
public interface ITeacherService {
    /**
     * 添加teacher
     *
     * @param teacher
     * @return
     */
    Teacher add(Teacher teacher);

    /**
     * 根据account查询teacher
     *
     * @param account
     * @return
     */
    Teacher findByAccount(String account);

    /**
     * 根据id查询老师信息,带权限
     *
     * @param id
     * @return
     */
    Teacher findWithPermission(Long id);
}
