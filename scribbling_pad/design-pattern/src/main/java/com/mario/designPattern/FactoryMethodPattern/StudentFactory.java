package com.mario.designPattern.FactoryMethodPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 2016/5/23.
 */
public class StudentFactory {

    private static Map<Class, Student> studentMap = new HashMap<>();

    public Student createStudent(Class clazz) {
        Student student = null;
        if (studentMap.containsKey(clazz)) {
            return studentMap.get(clazz);
        } else {
            try {
                student = (Student) Class.forName(clazz.getName()).newInstance();
                studentMap.put(clazz, student);
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
