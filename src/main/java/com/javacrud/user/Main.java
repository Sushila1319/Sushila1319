package com.javacrud.user;

import com.javacrud.DatabaseConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            UserDao.createUser("John1", "john1@gmail.com");
            UserDao.readUsers();
            UserDao.updateUser(22, "newemail@gmail.com");
            UserDao.deleteUser(22);
        } catch (SQLException e) {
            System.out.println("Exception at SQL");

        } finally {
            try {
                DatabaseConnection.closeConnection();
            } catch (SQLException e) {
                System.out.println("Exception during closing connection");
            }
        }
    }
}
