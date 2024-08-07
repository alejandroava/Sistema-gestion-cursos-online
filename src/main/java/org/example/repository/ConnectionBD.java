package org.example.repository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    public static Connection connection = null;
    private static final String url ="jdbc:mysql://libreria-bdlibreria.i.aivencloud.com:27584/RiwiAcademyDB";
    private static final String  user="avnadmin";
    private static final String password="AVNS_qYyQ9hIG_3ugWaXiFJi";

    public static Connection getconnection(){
        try {
            connection= DriverManager.getConnection(url,user,password);
            JOptionPane.showMessageDialog(null,"Conexion establecida");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            if(connection != null){
                connection.close();
                JOptionPane.showMessageDialog(null,"Conexion cerrada");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
