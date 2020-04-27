package com.mario.test.domain;

import com.simpletour.commons.data.domain.BaseDomain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mario on 2016/5/31.
 */
@Entity
@Table(name = "TESTDATE")
public class TestDate extends BaseDomain {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column
    @Temporal(value = TemporalType.DATE)
    private Date day;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
