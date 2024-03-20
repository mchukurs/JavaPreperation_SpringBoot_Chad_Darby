package com.chukurs.cruddemo.rest.controllers;

import com.chukurs.cruddemo.dao.EmployeeDAO;
import com.chukurs.cruddemo.entity.Employee;
import com.chukurs.cruddemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/employees/{id}")
    public Employee findById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee id not found " + id);
        }
        return employee;
    }

    @PostMapping(path = "/employees")
    public Employee add(@RequestBody Employee employee) {
        employee.setId(0);
        System.out.println(employee.getEmail());
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping(path = "/employees")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping(path = "/employees/{id}")
    public String deleteById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee id not found " + id);
        }
        employeeService.deleteById(id);
        return "Employee ID: "+id+" is deleted.";
    }
}
