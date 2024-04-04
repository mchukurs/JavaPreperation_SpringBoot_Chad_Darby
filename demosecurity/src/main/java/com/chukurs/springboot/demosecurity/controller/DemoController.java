package com.chukurs.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class DemoController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }
    @GetMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }

}
