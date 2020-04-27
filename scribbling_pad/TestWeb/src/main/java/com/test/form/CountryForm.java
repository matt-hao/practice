package com.test.form;

import com.test.domain.Country;
import com.test.domain.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario on 2016/5/24.
 */
public class CountryForm {

    private String name;

    private String personName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Country as() {
        Country country = new Country();
        country.setName(this.getName());
        List<Person> persons = new ArrayList<Person>() {{
            add(new Person(personName, country));
        }};
        country.setPersons(persons);
        return country;
    }

}
