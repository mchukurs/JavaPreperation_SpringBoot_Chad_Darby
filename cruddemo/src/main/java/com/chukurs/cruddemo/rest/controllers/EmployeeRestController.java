package com.chukurs.cruddemo.rest.controllers;

import com.chukurs.cruddemo.dao.EmployeeDAO;
import com.chukurs.cruddemo.entity.Employee;
import com.chukurs.cruddemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
