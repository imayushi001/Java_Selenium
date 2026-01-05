package Assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static void main(String[] args) {

        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root"; 
        String password = "root123"; 

        Connection con = null;

        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            // 2. Establish connection
            con = DriverManager.getConnection(url, username, password);
            
            // 3. Check if connection is successful
            if (con != null) {
                System.out.println("Connection Successful");
            } else {
                System.out.println("Unable to connect");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Unable to connect");
            e.printStackTrace();
        } finally {
            // 4. Close connection
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
