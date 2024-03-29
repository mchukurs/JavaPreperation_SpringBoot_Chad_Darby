package com.chukurs.learning.dao;

import com.chukurs.learning.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(int id);

    List<Student> findByLastName(String lastName);

    List<Student> findAll();

    void update(Student theStudent);
    void delete(int id);
}
