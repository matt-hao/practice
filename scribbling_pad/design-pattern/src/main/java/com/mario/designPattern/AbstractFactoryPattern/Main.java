package com.mario.designPattern.AbstractFactoryPattern;

import com.mario.designPattern.AbstractFactoryPattern.factory.FemaleStudentFactory;
import com.mario.designPattern.AbstractFactoryPattern.factory.MaleStudentFactory;
import com.mario.designPattern.AbstractFactoryPattern.factory.StudentFactory;
import com.mario.designPattern.AbstractFactoryPattern.student.Student;

/**
 * Created by Mario on 2016/5/23.
 *
 * @Remark 抽象工厂模式, 高内聚, 低耦合
 */
public class Main {
    public static void main(String[] args) {
        //**male**
        StudentFactory maleStudentFactory = new MaleStudentFactory();
        //math
        Student mathMaleStudent = maleStudentFactory.createMathStudent();
        mathMaleStudent.goodAt();
        mathMaleStudent.sex();
        //art
        Student artMaleStudent = maleStudentFactory.createArtStudent();
        artMaleStudent.goodAt();
        artMaleStudent.sex();

        //**female**
        StudentFactory femaleStudentFactory = new FemaleStudentFactory();
        //math
        Student mathFemaleStudent = femaleStudentFactory.createMathStudent();
        mathFemaleStudent.goodAt();
        mathFemaleStudent.sex();
        //art
        Student artFemaleStudent = femaleStudentFactory.createArtStudent();
        artFemaleStudent.goodAt();
        artFemaleStudent.sex();
    }
}
