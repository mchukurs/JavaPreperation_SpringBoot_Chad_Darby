package com.chukurs.cruddemo.services;

import com.chukurs.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);

}
