package com.mario.designPattern.FactoryMethodPattern;

/**
 * Created by Mario on 2016/5/23.
 *
 * @Remark 工厂模式
 */
public class Main {
    public static void main(String[] args) {
        StudentFactory studentFactory = new StudentFactory();
        Student mathStudent = studentFactory.createStudent(MathStudent.class);
        mathStudent.goodAt();

        Student artStudent = studentFactory.createStudent(ArtStudent.class);
        artStudent.goodAt();
    }
}
