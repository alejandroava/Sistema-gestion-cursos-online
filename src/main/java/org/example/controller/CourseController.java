package org.example.controller;

import org.example.model.Course;
import org.example.service.CourseService;

import javax.swing.*;
import java.util.Locale;

public class CourseController {
    CourseService courseService;
    public CourseController(){
        this.courseService = new CourseService();
    }
    public void createCourse(){
        String name = JOptionPane.showInputDialog("Ingrese el nombre del curso").toLowerCase(Locale.ROOT);
        Course course = new Course(0,name);
        this.courseService.createCourse(course);
    }
    public void deleteCourse(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del curso"));

        this.courseService.deleteCourseWithoutStudent(id);
    }
    public void readAllCourse(){
        this.courseService.readAllCourse();
    }
}
