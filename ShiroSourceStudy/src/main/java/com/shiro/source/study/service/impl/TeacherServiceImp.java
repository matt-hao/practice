package com.shiro.source.study.service.impl;

import com.shiro.source.study.dao.IRoleDao;
import com.shiro.source.study.dao.IStudentDao;
import com.shiro.source.study.dao.ITeacherDao;
import com.shiro.source.study.domain.Teacher;
import com.shiro.source.study.service.ITeacherService;
import com.shiro.source.study.shiro.EncryptUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Mario on 2016/7/6.
 */
@Service
public class TeacherServiceImp implements ITeacherService {

    @Autowired
    private EncryptUser<Teacher> encryptUser;

    @Autowired
    private ITeacherDao teacherDao;

    @Autowired
    private IStudentDao studentDao;

    @Autowired
    private IRoleDao roleDao;

    @Override
    @Transactional
    public Teacher add(Teacher teacher) {
        Objects.requireNonNull(teacher);
        if (teacherDao.findByAccount(teacher.getAccount()) != null)
            throw new IllegalArgumentException("账号为" + teacher.getAccount() + "的教师已存在");
        encryptUser.encrypt(teacher);
        if (!(teacherDao.add(teacher) > 0))
            throw new IllegalArgumentException("添加教师失败");
        if (!(teacher.getStudents() == null || teacher.getStudents().isEmpty()))
            teacher.getStudents().stream().filter(student -> student != null).forEach(student -> {
                if (studentDao.findById(student.getId()) == null)
                    throw new IllegalArgumentException("id为" + student.getId() + "的学生不存在");
                student.setTeacherId(teacher.getId());
                studentDao.update(student);
            });
        return teacher;
    }

    @Override
    public Teacher findByAccount(String account) {
        Objects.requireNonNull(account);
        return teacherDao.findByAccount(account);
    }

    @Override
    public Teacher findWithPermission(Long id) {
        Objects.requireNonNull(id);
        return teacherDao.findWithPermission(id);
    }
}
