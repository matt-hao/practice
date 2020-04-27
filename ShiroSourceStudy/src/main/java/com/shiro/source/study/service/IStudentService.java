package com.shiro.source.study.service;

import com.shiro.source.study.domain.Student;

/**
 * Created by Mario on 2016/9/6.
 */
public interface IStudentService {
    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    Student add(Student student);

    /**
     * 根据学生姓名查询学生
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
