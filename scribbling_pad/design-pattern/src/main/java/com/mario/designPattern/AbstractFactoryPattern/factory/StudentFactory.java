package com.mario.designPattern.AbstractFactoryPattern.factory;

import com.mario.designPattern.AbstractFactoryPattern.student.Student;

/**
 * Created by Mario on 2016/5/23.
 */
public interface StudentFactory {

    Student createMathStudent();

    Student createArtStudent();

}
