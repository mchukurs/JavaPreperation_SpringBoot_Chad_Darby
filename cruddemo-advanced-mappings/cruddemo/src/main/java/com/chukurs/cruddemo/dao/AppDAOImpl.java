package com.chukurs.cruddemo.dao;

import com.chukurs.cruddemo.entity.Course;
import com.chukurs.cruddemo.entity.Instructor;
import com.chukurs.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "SELECT i FROM Instructor i " +
                        "JOIN FETCH i.courses " +
                        "JOIN FETCH i.instructorDetail " +
                        "where i.id = :data", Instructor.class);

        query.setParameter("data", theId);

        Instructor tempInstructor = query.getSingleResult();
        return tempInstructor;
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);//instructor also returned
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor = findInstructorById(theId);
        List<Course> courses = tempInstructor.getCourses();
        for (Course course : courses) {
            course.setInstructor(null);
        }
        entityManager.remove(tempInstructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course tempCourse = entityManager.find(Course.class, theId);
        entityManager.remove(tempCourse);

    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.merge(theCourse);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        findInstructorDetailById(theId).getInstructor().setInstructorDetail(null);
        entityManager.remove(findInstructorDetailById(theId));
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor theInstructor) {
        entityManager.merge(theInstructor);//update existing entity
    }

    @Override
    @Transactional
    public void updateCourse(Course theCourse) {
        entityManager.merge(theCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        Course tempCourse = entityManager.find(Course.class, theId);
        return tempCourse;
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("FROM Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        return query.getResultList();
    }
}
