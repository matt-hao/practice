package com.shiro.source.study.dao;

import com.shiro.source.study.domain.Student;

/**
 * Created by mth on 2016/8/26.
 */
public interface IStudentDao {
    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    Integer add(Student student);

    /**
     * 更新学生
     *
     * @param student
     * @return
     */
    Integer update(Student student);

    /**
     * 根据id查询student
     *
     * @param id
     * @return
     */
    Student findById(Long id);

    /**
     * 根据account查询student
     *
     * @param account
     * @return
     */
    Student findByAccount(String account);

    /**
     * 根据id查询学生实体，带权限
     *
     * @param id
     * @return
     */
    Student findWithPermission(Long id);
}
