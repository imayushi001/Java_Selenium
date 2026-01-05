package Assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root123";

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            con = DriverManager.getConnection(url, username, password);

            // 3. Create Statement
            stmt = con.createStatement();

            // 4. SQL SELECT query
            String sql =
                    "SELECT * FROM Students " +
                    "WHERE semester = 7 AND branch = 'EC'";

            // 5. Execute Query
            rs = stmt.executeQuery(sql);

            System.out.println("Students of Semester 7 and EC branch:");
            System.out.println("------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("rollno") + "  " +
                        rs.getString("name") + "  " +
                        rs.getString("branch") + "  " +
                        rs.getInt("semester") + "  " +
                        rs.getInt("percentage") + "  " +
                        rs.getInt("year_of_passing")
                );
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

