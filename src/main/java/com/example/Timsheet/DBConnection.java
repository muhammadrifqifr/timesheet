package com.example.Timsheet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_timesheet", "root", "amartekrifqi");
    } catch (Exception e) {
            System.out.println("Error + " + e.getMessage());
        }
        return con;
    }
}
