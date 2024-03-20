package com.chukurs.cruddemo.rest.controllers;

import com.chukurs.cruddemo.dao.EmployeeDAO;
import com.chukurs.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    EmployeeDAO employeeDAO; //will refactor later, this should not be injected directly, there should be a service layer

    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping(path = "/employees")
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
