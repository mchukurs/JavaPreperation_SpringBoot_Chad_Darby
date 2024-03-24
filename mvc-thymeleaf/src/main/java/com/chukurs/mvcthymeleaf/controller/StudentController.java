package com.chukurs.mvcthymeleaf.controller;

import com.chukurs.mvcthymeleaf.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping(path = "/showStudentForm")
    public String showForm(Model theModel) {

        Student newStudent = new Student();
        theModel.addAttribute("student", newStudent);
        return "student-form";
    }

    @PostMapping(path = "/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {

        System.out.println(theStudent.getFirstName() + " is firstname");
        System.out.println(theStudent.getLastName() + " is lastname");
        return "student-confirmation";
    }

}
