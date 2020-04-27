package com.mario.test.bo;

import com.mario.test.domain.Teacher;

/**
 * Created by Mario on 2016/5/6.
 */
public class TeacherBo {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeacherBo(){

    }

    public TeacherBo(Teacher teacher){
        id = teacher.getId();
        name = teacher.getName();
    }

    public Teacher asTeacher(){
        Teacher teacher = new Teacher();
        teacher.setName(name);
        return teacher;
    }
}
