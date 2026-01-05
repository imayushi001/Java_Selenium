package Assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStudentRecord {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydb"; // your database
        String username = "root";
        String password = "root123";

        Connection con = null;
        Statement stmt = null;

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            con = DriverManager.getConnection(url, username, password);

            // 3. Create Statement
            stmt = con.createStatement();

            // 4. Delete students whose branch is Civil and year_of_passing is 2024
            String deleteSQL =
                    "DELETE FROM Students " +
                    "WHERE branch = 'Civil' AND year_of_passing = 2024";

            int rowsDeleted = stmt.executeUpdate(deleteSQL);
            System.out.println(rowsDeleted + " record(s) deleted successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
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

