package com.chukurs.cruddemo.dao;

import com.chukurs.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
