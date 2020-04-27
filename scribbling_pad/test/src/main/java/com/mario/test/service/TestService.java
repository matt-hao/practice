package com.mario.test.service;

import com.mario.test.domain.Teacher;

import java.util.Optional;


/**
 * Created by Mario on 2016/4/26.
 */
public interface TestService {

    Optional<Teacher> addTeacher(Teacher teacher);
}
