package com.appskimo.app.controller;

import com.appskimo.app.service.ApiService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by dominic.lee on 2016. 10. 18..
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApiController {

    @Inject
    private ApiService apiService;

    @RequestMapping(value = "sample1")
    public Object api1() {
        return apiService.findData();
    }

    @RequestMapping(value = "sample2")
    public Object api2() {
        return apiService.getSampleData1();
    }

    @RequestMapping(value = "sample3")
    public Object api3() {
        return apiService.getSampleData2();
    }

}
