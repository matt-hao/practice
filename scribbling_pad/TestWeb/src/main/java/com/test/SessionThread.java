package com.test;

import com.test.dao.TestCountryDao;
import com.test.domain.Country;
import com.test.domain.Person;

import java.util.List;

/**
 * Created by Mario on 2016/7/29.
 */
public class SessionThread implements Runnable {

    private Country country;

    private TestCountryDao testCountryDao;

    public SessionThread(Country country, TestCountryDao testCountryDao) {
        this.country = country;
        this.testCountryDao = testCountryDao;
    }

    @Override
    public void run() {
//        this.country = testCountryDao.getEntityById(Country.class, country.getId());
        List<Person> persons = country.getPersons();
        System.out.println(persons.size());
    }
}
