package com.chukurs.cruddemo.dao;

import com.chukurs.cruddemo.entity.Course;
import com.chukurs.cruddemo.entity.Instructor;
import com.chukurs.cruddemo.entity.InstructorDetail;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorById(int theId);
    void deleteCourseById(int theId);
    void save(Course theCourse);
    void deleteInstructorDetailById(int theId);

    void updateInstructor(Instructor theInstructor);
    void updateCourse(Course theCourse);

    Course findCourseById(int theId);

    List<Course> findCoursesByInstructorId(int theId);
}
