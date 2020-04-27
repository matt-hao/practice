package com.shiro.source.study.dao.impl;

import com.shiro.source.study.dao.IStudentDao;
import com.shiro.source.study.domain.Student;
import org.springframework.stereotype.Repository;

/**
 * Created by mth on 2016/8/26.
 */
@Repository
public class StudentDaoImp extends BaseDao implements IStudentDao {

    @Override
    public Integer add(Student student) {
        return this.sqlSessionTemplate.insert("com.shiro.source.study.dao.impl.StudentDaoImp.insert", student);
    }

    @Override
    public Integer update(Student student) {
        return this.sqlSessionTemplate.insert("com.shiro.source.study.dao.impl.StudentDaoImp.update", student);
    }

    @Override
    public Student findById(Long id) {
        return this.sqlSessionTemplate.selectOne("com.shiro.source.study.dao.impl.StudentDaoImp.findById", id);
    }

    @Override
    public Student findByAccount(String account) {
        return this.sqlSessionTemplate.selectOne("com.shiro.source.study.dao.impl.StudentDaoImp.findByAccount", account);
    }

    @Override
    public Student findWithPermission(Long id) {
        return this.sqlSessionTemplate.selectOne("com.shiro.source.study.dao.impl.StudentDaoImp.find", id);
    }
}
