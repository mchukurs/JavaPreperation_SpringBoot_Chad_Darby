package com.chukurs.cruddemo;

import com.chukurs.cruddemo.dao.AppDAO;
import com.chukurs.cruddemo.entity.Course;
import com.chukurs.cruddemo.entity.Instructor;
import com.chukurs.cruddemo.entity.InstructorDetail;
import com.chukurs.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
            //findInstructorWithCourses(appDAO);
            //findCoursesForInstructor(appDAO);
            //  findInstructorWithCoursesJoinFetch(appDAO);
            //updateInstructor(appDAO);
            //updateCourse(appDAO);
            //deleteCourse(appDAO);
            //createCourseAndReviews(appDAO);
            //retrieveCourseAndReviews(appDAO);
            deleteCourseAndReviews(appDAO);


        };
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {

        int theId = 10;
        appDAO.deleteCourseById(theId);//reviews deleted too due to cascade=all

    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int theId = 10;
        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        //create a course, add reviews, push to db
        Course newCourse = new Course("Tester Course");
        newCourse.addReview(new Review("great test course"));
        newCourse.addReview(new Review("average test course"));
        newCourse.addReview(new Review("interesting course"));

        appDAO.save(newCourse);
    }


    private void deleteCourse(AppDAO appDAO) {
        int theId = 10;
        appDAO.deleteCourseById(theId);
    }

    private void updateCourse(AppDAO appDAO) {
        int tempId = 10;
        Course course = appDAO.findCourseById(tempId);


        course.setTitle("Ya yee");
        appDAO.updateCourse(course);
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        var a = appDAO.findInstructorByIdJoinFetch(1);
        System.out.println(a);
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        tempInstructor.setLastName("UpdatedLastName");
        appDAO.updateInstructor(tempInstructor);
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        List<Course> courses = appDAO.findCoursesByInstructorId(theId);
        tempInstructor.setCourses(courses);
        System.out.println(tempInstructor.getCourses());
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
        appDAO.deleteInstructorById(2);

    }

    private void createInstructor(AppDAO appDAO) {

/*
        Instructor instructor = new Instructor("Matiss", "Cukurs", "matiss@mail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.yt.com/ya", "kite");
        instructor.setInstructorDetail(instructorDetail);
*/
        Instructor instructor = new Instructor("aaa", "bbb", "siitam@mail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://wwwxxxxxxx/no", "rrrrrr");
        instructor.setInstructorDetail(instructorDetail);


        System.out.println(instructor);
        appDAO.save(instructor);


    }

    private void findInstructor(AppDAO appDAO) {

        System.out.println(appDAO.findInstructorById(1));
    }

}
