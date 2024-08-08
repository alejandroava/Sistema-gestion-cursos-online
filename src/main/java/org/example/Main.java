package org.example;

import org.example.controller.CourseController;
import org.example.controller.EnrollmentController;
import org.example.controller.StudentController;

public class Main {
    public static void main(String[] args) {

        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();
        EnrollmentController enrollmentController = new EnrollmentController();
        //studentController.createStudent();
        //courseController.createCourse();
        //studentController.readStudentByEmail();
        //studentController.readStudenByID();
        //enrollmentController.createEnrollment();
        courseController.deleteCourse();

    }
}