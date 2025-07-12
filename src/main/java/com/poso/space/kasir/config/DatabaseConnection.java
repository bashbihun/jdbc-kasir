package com.poso.space.kasir.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/kasir_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "dicoding";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("gagal koneksi ke database " + e.getMessage());
        }
    }
}
