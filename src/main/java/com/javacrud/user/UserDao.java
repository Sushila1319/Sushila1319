package com.javacrud.user;

import com.javacrud.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static void createUser(String name, String email) throws SQLException {
        String createSql = "INSERT INTO users (name,email) VALUES (?,?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(createSql)
        ) {
            statement.setString(1, name);
            statement.setString(2, email);

            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("Rows affected: " + rowsAffected);
            }

        }
    }

    c

    public static void updateUser(long id, String newEmail) throws SQLException {
        String updateSql = "update users ser email = ? where id =?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateSql)) {
            statement.setString(1, newEmail);
            statement.setLong(2, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Users PreparedStatement statement = connection.prepareStatement(updatesql)\nupdated");


            }
        }
    }
    public static void deleteUser(long id) throws SQLException {
        String deleteSql ="Delete from users where id=?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(deleteSql)) {
                statement.setLong(1, id);
                int rowsAffected = statement.executeUpdate();
                if(rowsAffected > 0) {
                    System.out.println("User deleted");
                }
        }
    }
}
