package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentService;

import javax.swing.*;

public class StudentController {
    StudentService studentService;
    public StudentController(){
        this.studentService = new StudentService();
    }

    public void createStudent(){
        String name = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
        String lastname = JOptionPane.showInputDialog("Ingrese el apellido del estudiante");
        String email = JOptionPane.showInputDialog("Ingrese el email del estudiante");

        Student student = new Student(name,lastname,email);
        this.studentService.createStudenActive(student);
    }

    public void readStudentByEmail(){
        String email = JOptionPane.showInputDialog(null,"Ingrese el email");
        Student result =this.studentService.readStudentByEmail(email);
        //JOptionPane.showMessageDialog(null,result.toString() );
    }
    public void readStudenByID(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del estudiante"));
        this.studentService.readStudentByID(id);
    }
    public void readAllStudentActive(){
        this.studentService.readAllStudentActive();
    }

}
