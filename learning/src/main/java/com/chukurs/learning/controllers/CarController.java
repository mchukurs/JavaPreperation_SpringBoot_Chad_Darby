package com.chukurs.learning.controllers;

import com.chukurs.learning.services.CarService;
import com.chukurs.learning.services.NannyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CarController {

    private CarService carService;

    @Autowired
//    public void setCarService(@Qualifier("superCarServiceImpl")CarService carService) {
//        this.carService = carService;
//    }

    public void CarController( CarService carService) {
        this.carService = carService;
    }
    @GetMapping(path = "/car")
    public String getCar() {
        return carService.drive();
    }


}
