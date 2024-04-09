package com.chukurs.cruddemo;

import com.chukurs.cruddemo.dao.AppDAO;
import com.chukurs.cruddemo.entity.Instructor;
import com.chukurs.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            //createInstructor(appDAO);
            //  findInstructor(appDAO);
            //deleteInstructor(appDAO);
            //findInstructorDetail(appDAO);
            deleteInstructorDetail(appDAO);
        };
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(2L);
        System.out.println("detail " + instructorDetail);
        System.out.println("instructor " + instructorDetail.getInstructor());
        System.out.println("deleting both");
        appDAO.deleteInstructorDetailById(2L);

    }

    private void findInstructorDetail(AppDAO appDAO) {
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(2L);
        System.out.println("detail " + instructorDetail);
        System.out.printf("instructor " + instructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        System.out.println("deleting instructor ");
        appDAO.deleteInstructorById(1L);

    }

    private void createInstructor(AppDAO appDAO) {


        Instructor instructor = new Instructor("Matiss", "Cukurs", "matiss@mail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.yt.com/ya", "kite");
        instructor.setInstructorDetail(instructorDetail);
/*
        Instructor instructor = new Instructor("Ssitam", "Srukuc", "siitam@mail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.yt.com/no", "bowl");
        instructor.setInstructorDetail(instructorDetail);
*/

        System.out.println(instructor);
        appDAO.save(instructor);


    }

    private void findInstructor(AppDAO appDAO) {

        System.out.println(appDAO.findInstructorById(1L));
    }

}
