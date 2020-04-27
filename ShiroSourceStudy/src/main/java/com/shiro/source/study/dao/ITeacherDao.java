package com.shiro.source.study.dao;

import com.shiro.source.study.domain.Teacher;

/**
 * Created by mth on 2016/8/26.
 */
public interface ITeacherDao {
    /**
     * 添加老师
     *
     * @param teacher
     * @return
     */
    Integer add(Teacher teacher);

    /**
     * 根据account查询teacher
     *
     * @param account
     * @return
     */
    Teacher findByAccount(String account);

    /**
     * 根据id查询teacher，带权限
     *
     * @param id
     * @return
     */
    Teacher findWithPermission(Long id);
}
