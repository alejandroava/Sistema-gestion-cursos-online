package org.example;

import org.example.controller.CourseController;
import org.example.controller.EnrollmentController;
import org.example.controller.StudentController;

import javax.swing.*;

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
        //courseController.deleteCourse();

        boolean runMenu = true;

        while(runMenu){
            String optionMenu = JOptionPane.showInputDialog("Bienvenido al sistema de gestion de cursos\n"+
                    "1.Estudiante\n"+
                    "2.Cursos\n"+
                    "3.Inscripciones\n"+
                    "4.Calificaciones\n"+
                    "5.Salir");
            if(optionMenu == null ){
                JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
                continue;
            }
            switch (optionMenu){
                case "1":
                    String optionStudent = JOptionPane.showInputDialog("1.Crear estudiante\n"+
                            "2.Borrar estudiante\n"+
                            "3.Mostrar estudiantes Activos\n"+
                            "4.Mostrar estudiantes por email\n"+
                            "5.Mostrar estudiantes por ID\n"+
                            "6.Salir");
                    if(optionStudent.equals("1")){
                        studentController.createStudent();
                    } else if (optionStudent.equals("2")) {
                        studentController.readAllStudentActive();
                    } else if (optionStudent.equals("3")) {
                        studentController.readStudentByEmail();
                    } else if (optionStudent.equals("4")) {
                        studentController.readStudenByID();
                    } else if (optionStudent.equals("6")) {
                        break;
                    }else {
                        JOptionPane.showMessageDialog(null,"Ingrese una opcion valida");
                    }
                    break;
                case "2":
                    String optionCourse = JOptionPane.showInputDialog("1. Crear curso\n"+
                            "2.Borrar curso\n"+
                            "3.Mostrar cursos\n"+
                            "4.Salir");
                    if(optionCourse.equals("1")){
                        courseController.createCourse();
                    } else if (optionCourse.equals("2")) {
                        courseController.deleteCourse();
                    } else if (optionCourse.equals("3")) {
                        courseController.readAllCourse();
                    } else if (optionCourse.equals("4")) {
                        break;
                    }else {
                        JOptionPane.showMessageDialog(null,"Ingrese una opcion valida");
                    }
                    break;
                case "3":
                    String optionEnrollment = JOptionPane.showInputDialog("1.Crear inscripcion\n"+
                            "2.Eliminar inscripcion\n"+
                            "3.Salir");
                    if(optionEnrollment.equals("1")){
                        enrollmentController.createEnrollment();
                    } else if (optionEnrollment.equals("2")) {
                        enrollmentController.deleteEnrollment();
                    } else if (optionEnrollment.equals("3")) {
                        break;
                    }else {
                        JOptionPane.showMessageDialog(null,"Ingrese un valor valido");
                    }
                    break;
                case "4":
                    break;
                case"5":
                    runMenu = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Ingrese un valor valido");
            }
        }

    }
}