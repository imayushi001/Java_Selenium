package Assignment4;

import java.sql.*;

public class StudentsJDBC {
    public static void main(String[] args) {

        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root"; 
        String password = "root123";

        Connection con = null;
        Statement stmt = null;

        try {
            // 1. Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // 3. Create a statement object
            stmt = con.createStatement();

            // 4. Create Students table
            String createTable = "CREATE TABLE IF NOT EXISTS Students (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50) NOT NULL," +
                    "age INT," +
                    "course VARCHAR(50)" +
                    ")";
            stmt.executeUpdate(createTable);
            System.out.println("Table 'Students' created successfully!");

            // 5. Insert records into Students table
            String insert1 = "INSERT INTO Students (name, age, course) VALUES ('Ayushi', 20, 'CSE')";
            String insert2 = "INSERT INTO Students (name, age, course) VALUES ('Anamika', 22, 'ECE')";
            String insert3 = "INSERT INTO Students (name, age, course) VALUES ('pragati', 21, 'ME')";

            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);
            stmt.executeUpdate(insert3);

            System.out.println("Records inserted successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception:");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
