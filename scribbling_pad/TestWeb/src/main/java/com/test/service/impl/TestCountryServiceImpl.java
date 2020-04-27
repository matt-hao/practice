package com.test.service.impl;

import com.simpletour.commons.data.exception.BaseSystemException;
import com.test.SessionThread;
import com.test.dao.TestCountryDao;
import com.test.domain.Country;
import com.test.service.TestCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

/**
 * Created by Mario on 2016/5/24.
 */
@Service
public class TestCountryServiceImpl implements TestCountryService {

    @Autowired
    private TestCountryDao testCountryDao;

    @Override
    public Optional<Country> add(Country country) throws Exception {
        try {
            return Optional.of(this.add1(country));
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Country addCountry(Country country) {
        Objects.requireNonNull(country);
        return testCountryDao.save(country);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public Country add1(Country country) throws Exception {
        Country country1 = testCountryDao.save(country);
        throw new Exception();
    }


    @Override
    @Transactional
    public Optional<Country> edit(Long id) throws IllegalAccessException, InstantiationException {
        if (id == null) throw new BaseSystemException();
        Country country = testCountryDao.getEntityById(Country.class, id);
        country.setName("Mario" + Random.class.newInstance().nextInt());
        return Optional.ofNullable(testCountryDao.save(country));
    }

    @Override
    public Country findCountryById(Long id) {
        Objects.requireNonNull(id);
        Country country = testCountryDao.getEntityById(Country.class, id);
        Thread thread = new Thread(new SessionThread(country, testCountryDao));
        thread.start();
        return country;
    }
}
