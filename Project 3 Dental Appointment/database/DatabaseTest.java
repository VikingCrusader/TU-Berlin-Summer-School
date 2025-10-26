package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:8889/dental_app";
        String user = "root";
        String pass = "root";

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver loaded!");

            // Try connecting
            try (Connection conn = DriverManager.getConnection(url, user, pass)) {
                System.out.println("✅ Connected to database!");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Database connection failed!");
            e.printStackTrace();
        }
    }
}
