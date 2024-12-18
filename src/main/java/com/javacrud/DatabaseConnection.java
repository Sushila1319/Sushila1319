package com.javacrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL="jdbc:postgresql://localhost:5432/connecttalent";
    private static final String USER="postgres";
    private static final String PASSWORD="5727";

    private static Connection connection;

    private DatabaseConnection(){

    }
    public static Connection getConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            synchronized (DatabaseConnection.class){
                if(connection==null || connection.isClosed()){
                    connection = DriverManager.getConnection(URL,USER,PASSWORD);
                    System.out.println("Database Connection Created");
                }
            }
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection!=null && !connection.isClosed()){
            connection.close();
            System.out.println("Database connection closed");
        }
    }
}
