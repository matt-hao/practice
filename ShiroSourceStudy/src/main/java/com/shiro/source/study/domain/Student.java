package com.shiro.source.study.domain;

/**
 * Created by mth on 2016/8/24.
 */
public class Student extends User {
    /**
     * 老师id
     */
    private Long teacherId;

    private Teacher teacher;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
