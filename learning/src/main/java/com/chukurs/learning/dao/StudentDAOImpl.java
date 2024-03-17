package com.chukurs.learning.dao;

import com.chukurs.learning.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName = :lastName", Student.class);
        theQuery.setParameter("lastName", lastName);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);

        return theQuery.getResultList();
    }

    @Override
    @Transactional //as update is done on DB
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional //as update is done on DB, not sure why BUT its throwing an error if this is not here
    public void delete(int id) {
        System.out.println("Number of entries deleted: ");
       int a = entityManager.createQuery("DELETE FROM Student").executeUpdate();


    }
}
