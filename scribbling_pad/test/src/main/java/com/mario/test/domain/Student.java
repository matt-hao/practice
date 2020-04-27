package com.mario.test.domain;

import com.simpletour.commons.data.domain.BaseDomain;

import javax.persistence.*;

/**
 * Created by Mario on 2016/4/26.
 */
@Entity
@Table(name = "STUDENT")
public class Student extends BaseDomain {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "tid",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT))
    private Teacher teacher;

    @Version
    private Integer version;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
