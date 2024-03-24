package com.chukurs.mvcthymeleaf.controller;

import com.chukurs.mvcthymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${programmingLanguages}")
    private List<String> programmingLanguages;
    @Value("${operatingSystems}")
    private List<String> operatingSystems;

    @GetMapping(path = "/showStudentForm")

    public String showForm(Model theModel) {

        Student newStudent = new Student();
        theModel.addAttribute("student", newStudent);
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("programmingLanguages", programmingLanguages);
        theModel.addAttribute("operatingSystems", operatingSystems);
        return "student-form";
    }

    @PostMapping(path = "/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {

        System.out.println(theStudent.getFirstName() + " is firstname");
        System.out.println(theStudent.getLastName() + " is lastname");
        return "student-confirmation";
    }

}
