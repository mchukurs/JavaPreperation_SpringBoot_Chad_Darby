package com.chukurs.learning.controllers;

import com.chukurs.learning.dao.StudentDAO;
import com.chukurs.learning.entity.Student;
import com.chukurs.learning.services.CarService;
import com.chukurs.learning.services.NannyService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CarController {
EntityManager entityManager;
    private CarService carService;
    private CarService carService2;
    private StudentDAO studentDAO;
    @Autowired
//    public void setCarService(@Qualifier("superCarServiceImpl")CarService carService) {
//        this.carService = carService;
//    }

//    public void CarController(@Qualifier("superCarServiceImpl")CarService carService,@Qualifier("classicCarServiceImpl")CarService carService2) {
//        System.out.println("carController constructor");
//        this.carService = carService;
//        this.carService2 = carService2;
//    }

    public CarController(@Qualifier("customBeanId")CarService carService,StudentDAO studentDAO){
        System.out.println("carController constructor");
        this.carService = carService;
        this.studentDAO = studentDAO;
    }
    @GetMapping(path = "/car")
    public String getCar() {
        return (carService.drive()) + "\n"+" carService==carService2: "+ (carService==carService2);
    }
    @GetMapping(path = "/saveStudent")
    public String getCar2() {
        studentDAO.save(new Student("janis","test","smth@mail.com"));
        return (carService.drive());
    }


}
