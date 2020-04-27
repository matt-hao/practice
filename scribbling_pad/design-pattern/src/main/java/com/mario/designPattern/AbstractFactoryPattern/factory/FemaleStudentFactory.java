package com.mario.designPattern.AbstractFactoryPattern.factory;

import com.mario.designPattern.AbstractFactoryPattern.student.ArtFemaleStudent;
import com.mario.designPattern.AbstractFactoryPattern.student.MathFemaleStudent;
import com.mario.designPattern.AbstractFactoryPattern.student.Student;

/**
 * Created by Mario on 2016/5/23.
 */
public class FemaleStudentFactory extends AbstractStudentFactory {
    @Override
    public Student createMathStudent() {
        return super.createStudent(MathFemaleStudent.class);
    }

    @Override
    public Student createArtStudent() {
        return super.createStudent(ArtFemaleStudent.class);
    }
}
