package com.chukurs.mvcthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {


    @RequestMapping(path = "/showForm")
    public String showForm() {

        return "helloworld-form";
    }

    @RequestMapping(path = "/processForm")
    public String processForm() {

        return "helloworld";
    }


}
