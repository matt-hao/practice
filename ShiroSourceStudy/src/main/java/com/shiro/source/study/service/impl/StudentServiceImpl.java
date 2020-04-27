package com.shiro.source.study.service.impl;

import com.shiro.source.study.dao.IStudentDao;
import com.shiro.source.study.domain.Student;
import com.shiro.source.study.service.IStudentService;
import com.shiro.source.study.shiro.EncryptUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * Created by Mario on 2016/9/6.
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private EncryptUser<Student> encryptUser;

    @Autowired
    private IStudentDao studentDao;

    @Override
    @Transactional
    public Student add(Student student) {
        Objects.requireNonNull(student);
        if (studentDao.findByAccount(student.getAccount()) != null)
            throw new IllegalArgumentException("账号为:" + student.getAccount() + "的学生已经存在");
        encryptUser.encrypt(student);
        if (!(studentDao.add(student) > 0))
            throw new IllegalArgumentException("添加学生失败");
        return student;
    }

    @Override
    public Student findByAccount(String account) {
        Objects.requireNonNull(account);
        return studentDao.findByAccount(account);
    }

    @Override
    public Student findWithPermission(Long id) {
        Objects.requireNonNull(id);
        return studentDao.findWithPermission(id);
    }
}
