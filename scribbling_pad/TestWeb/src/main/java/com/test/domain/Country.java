package com.test.domain;

import com.simpletour.commons.data.domain.BaseDomain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mario on 2016/5/24.
 */
@Entity
@Table(name = "COUNTRY")
public class Country extends BaseDomain {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Person> persons;

    @Version
    private Integer version;

    public Country() {
    }

    ;

    public Country(String name, List<Person> persons) {
        this.name = name;
        this.persons = persons;
    }

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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
