package com.company.datasource;

import java.sql.*;
public class ConnectionToDB {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tinderapp";
    private static final String USERNAME = "postgres";
    private static final String USER_PASS = "12345";

    private static Connection connection;

    private ConnectionToDB() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USERNAME, USER_PASS);
            } catch (SQLException e) {
                throw new RuntimeException("Something went wrong during connection", e);
            }
        }
        return connection;
    }
}
