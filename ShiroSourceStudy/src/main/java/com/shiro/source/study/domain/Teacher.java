package com.shiro.source.study.domain;

import java.util.List;

/**
 * Created by mth on 2016/8/24.
 */
public class Teacher extends User {
    private List<Student> students;
    
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
