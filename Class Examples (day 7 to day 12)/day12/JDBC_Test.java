//package day13;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class JDBC_Test {
//
//    public static void main(String[] args) throws ClassNotFoundException {
//
//        // register the driver
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        // connection
//        Connection conn = null;
//        String db_url = "jdbc:mysql://localhost:3306/studentnew";
//        String username = "root";
//        String password = "zyw001123";
//        String createTableSQL = "CREATE TABLE IF NOT EXISTS students ("
//                + "student_id INT AUTO_INCREMENT PRIMARY KEY, "
//                + "first_name VARCHAR(50) NOT NULL, "
//                + "last_name VARCHAR(50) NOT NULL, "
//                + "gender CHAR(1) NOT NULL, "
//                + "GPA DECIMAL(3,2) CHECK (GPA >= 0.00 AND GPA <= 4.00)"
//                + ")";
//
//        try {
//            conn = DriverManager.getConnection(db_url, username, password);
//            System.out.println("Connected successfully!");
//
//            try (Statement statement = conn.createStatement()) {
//                statement.executeUpdate(createTableSQL);
//                System.out.println("Table 'users' created successfully!");
//            } catch (SQLException e) {
//                System.out.println("Error creating table: " + e.getMessage());
//            }
//
//            conn.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        
//       
//        
//    }
//}

package day13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String db_url = "jdbc:mysql://localhost:3306/studentnew";
        String username = "root";
        String password = "zyw001123";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS students ("
                + "student_id INT AUTO_INCREMENT PRIMARY KEY, "
                + "first_name VARCHAR(50) NOT NULL, "
                + "last_name VARCHAR(50) NOT NULL, "
                + "gender CHAR(1) NOT NULL, "
                + "GPA DECIMAL(3,2) CHECK (GPA >= 0.00 AND GPA <= 4.00)"
                + ")";

        try (Connection conn = DriverManager.getConnection(db_url, username, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("Connected successfully!");

            // 1) 建表
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'students' created/exists.");

            // 2) 插入四条记录（注意：表名是 students）
            String sql1 = "INSERT INTO students (first_name, last_name, gender, GPA) VALUES ('Alice', 'Smith', 'F', 3.75)";
            String sql2 = "INSERT INTO students (first_name, last_name, gender, GPA) VALUES ('Bob', 'Johnson', 'M', 3.50)";
            String sql3 = "INSERT INTO students (first_name, last_name, gender, GPA) VALUES ('Charlie', 'Brown', 'M', 3.20)";
            String sql4 = "INSERT INTO students (first_name, last_name, gender, GPA) VALUES ('Diana', 'White', 'F', 3.95)";

            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);

            System.out.println("4 students inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

