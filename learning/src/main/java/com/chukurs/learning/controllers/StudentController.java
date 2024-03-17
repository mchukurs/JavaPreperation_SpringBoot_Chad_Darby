package com.chukurs.learning.controllers;

import com.chukurs.learning.dao.StudentDAO;
import com.chukurs.learning.entity.Student;
import com.chukurs.learning.services.CarService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    EntityManager entityManager;
    private StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        System.out.println("StudentController constructor");
        this.studentDAO = studentDAO;
    }

    @GetMapping(path = "/students")
    public List<Student> getStudents() {
        List<Student> students = studentDAO.findAll();
        return students;
    }

    @GetMapping(path = "/student")
    public String getStudentById(@RequestParam int id) {
        Optional<Student> student = Optional.ofNullable(studentDAO.findById(id));
        return student.toString();
    }
    @GetMapping(path = "/student/{lastName}")
    public List<Student> getStudentByLastName(@PathVariable String lastName) {
        List<Student> students = studentDAO.findByLastName(lastName);
        return students;
    }


}
