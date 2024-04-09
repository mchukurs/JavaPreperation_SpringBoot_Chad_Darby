package com.chukurs.cruddemo.dao;

import com.chukurs.cruddemo.entity.Instructor;
import com.chukurs.cruddemo.entity.InstructorDetail;
import org.springframework.stereotype.Repository;


public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorById(int theId);
    void deleteInstructorDetailById(int theId);

}
