package com.chukurs.learning.controllers;

import com.chukurs.learning.services.NannyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class NannyController {
    @Value("${matiss}")
    private String matiss;
    //injection happens here
    // public NannyController(NannyService nannyService) {
    //   this.nannyService = nannyService;
    // }
    private NannyService nannyService;

    @Autowired
    public void setNannyService(NannyService nannyService) {
        this.nannyService = nannyService;
    }


    //@RequestMapping("/nannies")
    @GetMapping(path = "/nannies")
    public List<String> getNannies() {
        return nannyService.findMany("Anna");
    }

    @GetMapping(path = "/nanny")
    public String getNanny() {
        return nannyService.findOne(1);
    }


    @GetMapping(path = "/testingAuto")
    public String getTestingAuto() {
        return matiss;
    }


    @GetMapping(path = "/workout")
    public String getWorkout(@RequestParam("type") String type) {
        return type + " is the workout to be done";
    }

    @GetMapping(path = "/workout2")
    public String getWorkout2(@RequestParam("type") String type) {
        return type + " is the workout to be done2";
    }

}
