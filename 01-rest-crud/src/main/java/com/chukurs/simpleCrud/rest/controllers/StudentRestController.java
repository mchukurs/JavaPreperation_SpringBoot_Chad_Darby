package com.chukurs.simpleCrud.rest.controllers;

import com.chukurs.simpleCrud.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public record StudentRestController() {


    @GetMapping(path= "/students")
    public List<Student> getStudents() {
        List<Student> studentList = List.of(new Student("Matiss", "Cukurs"), new Student("Persona", "Duo"));
        return studentList;

    }
}
