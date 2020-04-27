package com.test.domain;

import com.simpletour.commons.data.domain.BaseDomain;

import javax.persistence.*;

/**
 * Created by Mario on 2016/5/24.
 */
@Entity
@Table(name = "PERSON")
public class Person extends BaseDomain {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name")
    private String name;

    public Person(){}

    public Person(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Version
    private Integer version;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long aLong) {
        this.id = aLong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}

