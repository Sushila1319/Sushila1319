package com.javacrud.wap;

import java.sql.SQLException;

public class MainAskUser {
    public static void main(String[] args) {
        try{
            AskUser.CreateData();

        }catch (SQLException e){
            System.err.println("Database operation failed:" + e.getMessage());
        }
    }
}
