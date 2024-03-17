package com.chukurs.learning.controllers;

import com.chukurs.learning.dao.StudentDAO;
import com.chukurs.learning.entity.Student;
import com.chukurs.learning.services.CarService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @GetMapping(path = "/createStudents")
    public void createStudents() {
        List<Integer> studentCount = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        studentCount.forEach(
                (a) -> {
                    studentDAO.save(new Student("Christopher", String.valueOf((char) (a.intValue()+64)), "smth@mail.com"));
                }

        );
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

    @GetMapping(path = "/students/{id}")
    public void updateStudent(@PathVariable int id, @RequestParam String newName) {
        Student student = studentDAO.findById(id);
        student.setFirstName(newName);
        studentDAO.update(student);
        System.out.println("The name of " + student.getLastName() + " was changed to " + newName);
    }

    @GetMapping(path = "/studentDelete/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentDAO.delete(id);
    }


}
