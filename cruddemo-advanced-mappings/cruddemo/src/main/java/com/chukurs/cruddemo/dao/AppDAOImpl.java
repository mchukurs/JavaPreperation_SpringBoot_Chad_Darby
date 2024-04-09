package com.chukurs.cruddemo.dao;

import com.chukurs.cruddemo.entity.Instructor;
import com.chukurs.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(Long theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    public InstructorDetail findInstructorDetailById(Long theId) {
        return entityManager.find(InstructorDetail.class, theId);//instructor also returned
    }

    @Override
    @Transactional
    public void deleteInstructorById(Long theId) {
        entityManager.remove(findInstructorById(theId));
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(Long theId) {
        entityManager.remove(findInstructorDetailById(theId));
    }
}
