package com.chukurs.cruddemo;

import com.chukurs.cruddemo.dao.AppDAO;
import com.chukurs.cruddemo.entity.Course;
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
            //deleteInstructorDetail(appDAO);
            // createInstructorWithCourses(appDAO);
            findInstructorWithCourses(appDAO);
        };
    }

    private void findInstructorWithCourses(AppDAO appDAO) {

        Instructor instructor = appDAO.findInstructorById(1);
        System.out.println(instructor);

       System.out.println(instructor.getCourses());

    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor = new Instructor("John", "Bravo", "johny@mail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.yt.com/he", "hair");
        instructor.setInstructorDetail(instructorDetail);

        Course tempCourse1 = new Course("Air guitar");
        Course tempCourse2 = new Course("Pinball expert");
        instructor.add(tempCourse1);
        instructor.add(tempCourse2);

        appDAO.save(instructor);

    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(4);
        System.out.println("detail " + instructorDetail);
        System.out.println("instructor " + instructorDetail.getInstructor());
        System.out.println("deleting just detail");
        appDAO.deleteInstructorDetailById(4);

    }

    private void findInstructorDetail(AppDAO appDAO) {
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(2);
        System.out.println("detail " + instructorDetail);
        System.out.printf("instructor " + instructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        System.out.println("deleting instructor ");
        appDAO.deleteInstructorById(1);

    }

    private void createInstructor(AppDAO appDAO) {

/*
        Instructor instructor = new Instructor("Matiss", "Cukurs", "matiss@mail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.yt.com/ya", "kite");
        instructor.setInstructorDetail(instructorDetail);
*/
        Instructor instructor = new Instructor("Ssitam", "Srukuc", "siitam@mail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.yt.com/no", "bowl");
        instructor.setInstructorDetail(instructorDetail);


        System.out.println(instructor);
        appDAO.save(instructor);


    }

    private void findInstructor(AppDAO appDAO) {

        System.out.println(appDAO.findInstructorById(1));
    }

}
