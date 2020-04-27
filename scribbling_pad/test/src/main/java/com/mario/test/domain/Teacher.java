package com.mario.test.domain;

import com.mario.test.bo.TeacherBo;
import com.simpletour.commons.data.domain.BaseDomain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mario on 2016/4/26.
 */
@Entity
@Table(name = "TEACHER")
public class Teacher extends BaseDomain {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "teacher")
//    @org.hibernate.annotations.ForeignKey(name = "none")
    @Transient
    private List<Student> students;

    @Version
    private Integer verison;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getVerison() {
        return verison;
    }

    public void setVerison(Integer verison) {
        this.verison = verison;
    }

    public TeacherBo asTeacherBo() {
        TeacherBo teacherBo = new TeacherBo(this);
        return teacherBo;
    }
}
