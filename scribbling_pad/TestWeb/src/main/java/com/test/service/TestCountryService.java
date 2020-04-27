package com.test.service;


import com.test.domain.Country;

import java.util.Optional;

/**
 * Created by Mario on 2016/5/24.
 */
public interface TestCountryService {

    Optional<Country> add(Country country) throws Exception;

    Country addCountry(Country country);

    Optional<Country> edit(Long id) throws IllegalAccessException, InstantiationException;

    Country findCountryById(Long id);
}
