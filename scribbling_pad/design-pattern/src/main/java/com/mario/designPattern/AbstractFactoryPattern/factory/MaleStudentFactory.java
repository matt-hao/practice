package com.mario.designPattern.AbstractFactoryPattern.factory;

import com.mario.designPattern.AbstractFactoryPattern.student.ArtMaleStudent;
import com.mario.designPattern.AbstractFactoryPattern.student.MathMaleStudent;
import com.mario.designPattern.AbstractFactoryPattern.student.Student;

/**
 * Created by Mario on 2016/5/23.
 */
public class MaleStudentFactory extends AbstractStudentFactory {

    @Override
    public Student createMathStudent() {
        return super.createStudent(MathMaleStudent.class);
    }

    @Override
    public Student createArtStudent() {
        return super.createStudent(ArtMaleStudent.class);
    }
}
