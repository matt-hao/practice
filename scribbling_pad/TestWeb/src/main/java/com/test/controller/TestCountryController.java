package com.test.controller;

import com.simpletour.commons.data.exception.BaseSystemException;
import com.test.domain.Country;
import com.test.form.CountryForm;
import com.test.service.TestCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by Mario on 2016/5/24.
 */
@Controller
@RequestMapping("/test")
public class TestCountryController {

    @Autowired
    private TestCountryService testCountryService;


    @ResponseBody
    @RequestMapping(value = "/cute", method = RequestMethod.POST)
    public String cute(@RequestBody CountryForm countryForm) {
        try {
            Optional<Country> country = testCountryService.add(countryForm.as());
            if (country.isPresent())
                return "success";
        } catch (BaseSystemException e) {
            return "program-fail";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping(value = "/edit/{id:\\d+}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id) throws InstantiationException, IllegalAccessException {
        try {
            testCountryService.edit(id);
            return "success";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return "fail";
    }

}
