package com.chukurs.learning.dao;

import com.chukurs.learning.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//repository annotation enables component scanning AND translates jdbc exceptions
@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //handles transactions for us
    public void save(Student theStudent) {

        System.out.println(theStudent.getId());
        entityManager.persist(theStudent);
        System.out.println(theStudent.getId());
    }

    @Override
    public Student findById(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public List<Student> find() {
        Query query = entityManager.createNativeQuery("SELECT * FROM student");

        return query.getResultList();
    }
}
