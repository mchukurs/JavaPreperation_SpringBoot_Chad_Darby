package com.chukurs.learning.controllers;

import com.chukurs.learning.services.CarService;
import com.chukurs.learning.services.NannyService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CarController {

    private CarService carService;
    private CarService carService2;
    @Autowired
//    public void setCarService(@Qualifier("superCarServiceImpl")CarService carService) {
//        this.carService = carService;
//    }

//    public void CarController(@Qualifier("superCarServiceImpl")CarService carService,@Qualifier("classicCarServiceImpl")CarService carService2) {
//        System.out.println("carController constructor");
//        this.carService = carService;
//        this.carService2 = carService2;
//    }

    public CarController(@Qualifier("anyNameUWish")CarService carService){
        System.out.println("carController constructor");
        this.carService = carService;
    }
    @PostConstruct
    public void beforeBean(){
        System.out.println("after constructing carController");
    }
    @PreDestroy
    public void afterBean(){
        System.out.println("before killing carController");
    }
    @GetMapping(path = "/car")
    public String getCar() {
        return (carService.drive()) + "\n"+" carService==carService2: "+ (carService==carService2);
    }
    @GetMapping(path = "/car2")
    public String getCar2() {
        return (carService.drive());
    }


}
