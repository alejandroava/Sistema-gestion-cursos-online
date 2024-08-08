package org.example.service;

import org.example.model.Course;
import org.example.model.Student;
import org.example.repository.ConnectionBD;
import org.example.repository.imodel.IModelStudent;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IModelStudent {
    @Override
    public Student createStudenActive(Student studentEntity) {
        Connection connection = ConnectionBD.getconnection();
        PreparedStatement preparedStatement = null;
        String sqlQuery ="INSERT INTO Students(name,lastname,email,active) VALUES(?,?,?,?);";
        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,studentEntity.getName());
            preparedStatement.setString(2,studentEntity.getLastname());
            preparedStatement.setString(3,studentEntity.getEmail());
            preparedStatement.setBoolean(4,studentEntity.isActive());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                JOptionPane.showMessageDialog(null,"Estudiante creado con extio");
            }else {
                JOptionPane.showMessageDialog(null,"No se pudo crear el estudiante");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(connection != null) connection.close();
                if(preparedStatement != null) preparedStatement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Student readStudentByEmail(String email) {
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        String sqlQuery =  "SELECT s.*, c.id as course_id, c.name as course_name FROM Students s " +
                "LEFT JOIN Enrollments e ON s.id = e.student_id " +
                "LEFT JOIN Courses c ON e.course_id = c.id " +
                "WHERE s.email = ?;";
        try(Connection connection = ConnectionBD.getconnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = null;
            while (resultSet.next()){
                student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("active"));

                int courseId = resultSet.getInt("course_id");
                if(courseId > 0){
                    Course course = new Course();
                    course.setId(courseId);
                    course.setName(resultSet.getString("course_name"));
                    courses.add(course);
                }
                JOptionPane.showMessageDialog(null,"leyendo...");

            }
            if (student != null) {
                student.setCourses(courses);
                JOptionPane.showMessageDialog(null,student.toString());
                //System.out.println("ID: " + student.getId());
                //System.out.println("Nombre: " + student.getName() + " " + student.getLastname());
                //System.out.println("Email: " + student.getEmail());
                //System.out.println("Activo: " + student.isActive());
                //System.out.println("Cursos inscritos:");
                //for (Course course : student.getCourses()) {
                    //System.out.println(" - " + course.getName());
                }else {
                System.out.println("Estudiante no encontrado.");
                }
            }
            catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> readStudentByID(int id) {
        List<Student> students = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Students WHERE id=?;";
        try(Connection connection = ConnectionBD.getconnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("active"));
                students.add(student);
            }
            JOptionPane.showMessageDialog(null,students.toString());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student updateStudent(Student studentEntity, String email) {
        String sqlQuery = "UPDATE Students SET name=?,SET lastname=?,SET email=?,SET active=?;";
        try(Connection connection = ConnectionBD.getconnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setString(1,studentEntity.getName());
            preparedStatement.setString(2,studentEntity.getLastname());
            preparedStatement.setString(3,studentEntity.getEmail());
            preparedStatement.setBoolean(4,studentEntity.isActive());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                JOptionPane.showMessageDialog(null,"Estudiante actualizado con exito");
            }else {
                JOptionPane.showMessageDialog(null,"Estudiante no fue actualizado");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Student> readAllStudentActive() {
        List<Student> studentsActive = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Students WHERE active = 1;";
        try(Connection connection = ConnectionBD.getconnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet rs = preparedStatement.executeQuery()){
            while (rs.next()){
                Student student = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getBoolean("active"));
                studentsActive.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return studentsActive;
    }
}
