package com.chukurs.cruddemo.dao;

import com.chukurs.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
