package com.javacrud.wap;

import com.javacrud.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AskUser {
    public static void CreateData() throws SQLException{
        String createSqlString  = "INSERT INTO users (name,email) VALUES (?,?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(createSqlString)
        ) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the name" );
            String name = scanner.nextLine();

            System.out.println("Enter the email");
            String email = scanner.nextLine();

            statement.setString(1,name);
            statement.setString(2,email);


            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rows affected: " + rowsAffected);
            }

        }
    }
    public static void readUsers() throws SQLException {
        String readSql = "select * from users";
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(readSql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("id=" + id + "name=" + name + "email=" + email);
            }
        }
    }
}
