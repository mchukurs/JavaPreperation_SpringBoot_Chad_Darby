package com.chukurs.cruddemo.dao;

import com.chukurs.cruddemo.entity.Instructor;
import org.springframework.stereotype.Repository;


public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(Long theId);

    void deleteInstructorById(Long theId);
}
