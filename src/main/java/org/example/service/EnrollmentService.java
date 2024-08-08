package org.example.service;

import org.example.model.Enrollment;
import org.example.repository.ConnectionBD;
import org.example.repository.imodel.IModelEnrollment;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentService implements IModelEnrollment {
    @Override
    public Enrollment createdEnrollment(Enrollment enrollmentEntity) {
        if(countEnrollment(enrollmentEntity.getStudentID()) >= 3){
            JOptionPane.showMessageDialog(null,"El estudiante tiene mas de 3 inscripciones");
            return null;
        }
        String sqlQuery = "INSERT INTO Enrollments(student_id,course_id) VALUES(?,?);";
        try(Connection connection = ConnectionBD.getconnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1,enrollmentEntity.getStudentID());
            preparedStatement.setInt(2,enrollmentEntity.getCourseID());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                JOptionPane.showMessageDialog(null,"Registro exitoso");
            }else {
                JOptionPane.showMessageDialog(null,"Registro sin exito");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteEnrollment(int id) {
        String responseDelete = JOptionPane.showInputDialog("Estas a punto de eliminar una inscripcion por ende se perdera el historial de calificaciones, ¿esta seguro de continuat? s/n");
        if (responseDelete.equals("s")) {
            String sqlQuery = "DELETE FROM Enrollments WHERE id=?;";
            try (Connection connection = ConnectionBD.getconnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, id);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected == 1) {
                    JOptionPane.showMessageDialog(null, "Inscripcion eliminada");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Proceso cancelado");
        }

    }

    @Override
    public boolean courseExist(int courseID) {
        String sqlQuery = "SELECT COUNT(*) FROM Courses WHERE id=?;";
        try(Connection connection = ConnectionBD.getconnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1,courseID);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                if(rs.getInt(1)>0){
                    JOptionPane.showMessageDialog(null,"El curso existe");
                    return true;
                }
            }else {
                JOptionPane.showMessageDialog(null,"El curso no existe");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean studentExist(int studentID) {
        String sqlQuery = "SELECT COUNT(*) FROM Students WHERE id=?;";
        try(Connection connection = ConnectionBD.getconnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1,studentID);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                if(rs.getInt(1)>0){
                    JOptionPane.showMessageDialog(null,"El estudiante existe");
                    return true;
                }else {
                    JOptionPane.showMessageDialog(null,"El estudiante no existe");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean isStudentEnrollment(int studentID, int courseID) {
        String sql = "SELECT COUNT(*) FROM Enrollments WHERE student_id = ? AND course_id = ?";
        try (Connection connection = ConnectionBD.getconnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, studentID);
            stmt.setInt(2, courseID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int countEnrollment(int StudentID) {
        String sqlQuery = "SELECT COUNT(*) FROM Enrollments WHERE student_id=?;";
        try(Connection connection = ConnectionBD.getconnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1,StudentID);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                return rowsAffected;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
