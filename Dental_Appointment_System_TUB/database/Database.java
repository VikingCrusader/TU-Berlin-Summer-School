package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String DB_URL = "jdbc:mysql://localhost:8889/dental_app";
    private static final String DB_USER = "root";  
    private static final String DB_PASS = "root";   

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Connected to dental_app database!");
            return conn;
        } catch (SQLException e) {
            System.err.println("Connection to dental_app failed!");
            e.printStackTrace();
            return null;
        }
    }
}
