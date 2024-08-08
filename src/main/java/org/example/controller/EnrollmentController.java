package org.example.controller;

import org.example.model.Enrollment;
import org.example.service.EnrollmentService;

import javax.swing.*;

public class EnrollmentController {
    EnrollmentService enrollmentService;
    public EnrollmentController (){
        this.enrollmentService=new EnrollmentService();
    }
    public boolean createVerifyEnrollment(int studenID,int courseID){
        if(enrollmentService.studentExist(studenID)){
            if(enrollmentService.courseExist(courseID)){
                if (enrollmentService.isStudentEnrollment(studenID,courseID)){
                    JOptionPane.showMessageDialog(null,"El estudiante ya esta inscrito");
                    return false;
                }
            }
        }
        return true;
    }
    public void createEnrollment(){
        int studentID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del estudiante"));
        int courseID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del course"));
        Enrollment enrollment;
        if(createVerifyEnrollment(studentID,courseID)){
            enrollment = new Enrollment(0,studentID,courseID);
            this.enrollmentService.createdEnrollment(enrollment);
            JOptionPane.showMessageDialog(null, "Inscripcion exitosa");
        }else{
            JOptionPane.showMessageDialog(null,"Estudiante o curso no existen");
        }

    }
    public void deleteEnrollment(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la inscripcion"));
        this.enrollmentService.deleteEnrollment(id);
    }

}
