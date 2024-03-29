package com.chukurs.simpleCrud.rest.controllers;

import com.chukurs.simpleCrud.entity.Student;
import com.chukurs.simpleCrud.rest.exceptionHandlers.student.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> studentList;

    @PostConstruct
    public void loadData() {
        System.out.println("Loading data...");
        studentList = List.of(new Student("Matiss", "Cukurs"), new Student("Persona", "Duo"), new Student("Test3", "Rest3"));
    }

    @GetMapping(path = "/students")
    public List<Student> getStudents() {

        return studentList;

    }

    @GetMapping(path = "/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        //checkign if student exsists
        if (studentId >= studentList.size() || studentId < 0) {
            //throw
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return studentList.get(studentId);

    }


}
