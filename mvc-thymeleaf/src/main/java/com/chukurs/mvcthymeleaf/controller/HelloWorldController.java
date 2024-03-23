package com.chukurs.mvcthymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.unbescape.xml.XmlEscape;

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

    @RequestMapping(path = "/processFormVersionTwo")
    public String processFormVersionTwo(@RequestParam("studentName") String theName,HttpServletRequest request, Model model) {

        theName = theName.toUpperCase();
        String result = "YO " + theName;
        model.addAttribute("message", result);
        return "helloworld";
    }


}
