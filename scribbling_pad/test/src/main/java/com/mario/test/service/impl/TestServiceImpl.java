package com.mario.test.service.impl;

import com.mario.test.dao.TestDao;
import com.mario.test.domain.Teacher;
import com.mario.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * Created by Mario on 2016/4/26.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    @Transactional
    public Optional<Teacher> addTeacher(Teacher teacher) {
        Teacher teacher1 = testDao.save(teacher);
        teacher.getStudents().stream().forEach(student -> {
            student.setTeacher(teacher1);
            testDao.save(student);
        });
        return Optional.ofNullable(teacher);
    }
}
