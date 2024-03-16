package com.chukurs.learning.dao;

import com.chukurs.learning.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        entityManager.persist(theStudent);
    }
}
