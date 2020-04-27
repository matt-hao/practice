package com.mario.designPattern.AbstractFactoryPattern.factory;

import com.mario.designPattern.AbstractFactoryPattern.student.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 2016/5/23.
 */
public abstract class AbstractStudentFactory implements StudentFactory {

    private static final Map<Class, Student> studentMap = new HashMap<>();

    protected Student createStudent(Class clazz) {
        Student student = null;
        if (studentMap.containsKey(clazz)) {
            return studentMap.get(clazz);
        } else {
            try {
                student = (Student) Class.forName(clazz.getName()).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return student;
    }
}
