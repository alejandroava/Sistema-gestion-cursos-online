package org.example.service;

import org.example.model.Course;
import org.example.repository.ConnectionBD;
import org.example.repository.imodel.IModelCourse;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    }

    @Override
    public List<Course> readAllCourse() {
        return List.of();
    }
}
