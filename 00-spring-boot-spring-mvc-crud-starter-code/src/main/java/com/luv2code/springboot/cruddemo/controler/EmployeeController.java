package com.luv2code.springboot.cruddemo.controler;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")


public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        //get employees from DB
        List<Employee> theEmployees = employeeService.findAll();
        //add to the spring model
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}

