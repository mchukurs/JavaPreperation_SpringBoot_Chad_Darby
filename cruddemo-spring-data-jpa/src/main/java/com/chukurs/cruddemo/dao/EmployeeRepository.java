package com.chukurs.cruddemo.dao;

import com.chukurs.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="workers")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
