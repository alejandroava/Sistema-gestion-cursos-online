package org.example.service;

import org.example.model.Course;
import org.example.repository.ConnectionBD;
import org.example.repository.imodel.IModelCourse;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CourseService implements IModelCourse {
    @Override
    public Course createCourse(Course courseEntity) {
        String sqlQuery = "INSERT INTO Courses(name) VALUES(?);";
        try(
            Connection connection = ConnectionBD.getconnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1,courseEntity.getName());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                JOptionPane.showMessageDialog(null,"Curso creado con exito");
            }else {
                JOptionPane.showMessageDialog(null,"Curso no creado");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteCourseWithoutStudent(int id) {
        if(verifyHasEnrollment(id)) {
            JOptionPane.showMessageDialog(null, "No se puede borrar el curso, tiene inscripciones");
            return;
        }
            String sqlQuery = "DELETE FROM Courses WHERE id=?;";
            try(Connection connection = ConnectionBD.getconnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
                preparedStatement.setInt(1,id);
                int rowsAffected = preparedStatement.executeUpdate();
                if(rowsAffected == 1){
                    JOptionPane.showMessageDialog(null,"Curso borrado con exito");
                }else{
                    JOptionPane.showMessageDialog(null,"No hay registros para borrar");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    @Override
    public boolean verifyHasEnrollment(int id) {
        String sqlQuery = "SELECT COUNT(*) FROM Enrollments WHERE course_id=?;";
        try(Connection connection = ConnectionBD.getconnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return rs.getInt(1)>0;
            }else{
                JOptionPane.showMessageDialog(null,"El curso no existe");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Course> readAllCourse() {
        return List.of();
    }
}
