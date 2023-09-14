package com.mycompany.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    public static Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "root";
        String password = "password";

        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
