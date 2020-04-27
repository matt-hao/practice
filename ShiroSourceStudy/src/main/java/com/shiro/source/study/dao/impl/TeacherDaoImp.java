package com.shiro.source.study.dao.impl;

import com.shiro.source.study.dao.ITeacherDao;
import com.shiro.source.study.domain.Teacher;
import org.springframework.stereotype.Repository;

/**
 * Created by mth on 2016/8/26.
 */
@Repository
public class TeacherDaoImp extends BaseDao implements ITeacherDao {

    @Override
    public Integer add(Teacher teacher) {
        return this.sqlSessionTemplate.insert("com.shiro.source.study.dao.impl.TeacherDaoImp.insert", teacher);
    }

    @Override
    public Teacher findByAccount(String account) {
        return this.sqlSessionTemplate.selectOne("com.shiro.source.study.dao.impl.TeacherDaoImp.findByAccount", account);
    }

    @Override
    public Teacher findWithPermission(Long id) {
        return this.sqlSessionTemplate.selectOne("com.shiro.source.study.dao.impl.TeacherDaoImp.find", id);
    }
}
