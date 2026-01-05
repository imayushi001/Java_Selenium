package miniProject3;


import java.sql.*;
import java.util.Scanner;

public class StudentManagement{

    static Scanner sc = new Scanner(System.in);
    static String url = "jdbc:mysql://localhost:3306/school";
    static String user = "root";
    static String pass = "root123";

    public static void main(String[] args) {

        if (!login()) {
            System.out.println("Invalid Login! Program terminated.");
            return;
        }

        while (true) {
            System.out.println("\n---- STUDENT MENU ----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Eno");
            System.out.println("4. Update Student Branch");
            System.out.println("5. Delete Student by Eno");
            System.out.println("6. Display Sorted Students");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: displayStudents(); break;
                    case 3: searchStudent(); break;
                    case 4: updateBranch(); break;
                    case 5: deleteStudent(); break;
                    case 6: sortStudents(); break;
                    case 7:
                        System.out.println("Thank you!");
                        return;
                    default:
                        throw new Exception("Invalid menu choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // 🔐 LOGIN
    static boolean login() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();
        return u.equals("admin") && p.equals("admin123");
    }

    // 1️⃣ ADD STUDENT
    static void addStudent() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();
        if (exists(eno)) throw new Exception("Eno already exists");

        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Branch: ");
        String branch = sc.next();
        if (branch.isEmpty()) throw new Exception("Branch cannot be empty");

        System.out.print("Semester: ");
        int sem = sc.nextInt();

        System.out.print("Percentage: ");
        float per = sc.nextFloat();
        if (per <= 0) throw new Exception("Percentage must be positive");

        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps =
            con.prepareStatement("INSERT INTO Students VALUES(?,?,?,?,?)");

        ps.setInt(1, eno);
        ps.setString(2, name);
        ps.setString(3, branch);
        ps.setInt(4, sem);
        ps.setFloat(5, per);

        ps.executeUpdate();
        System.out.println("Student added successfully");
        con.close();
    }

    // 2️⃣ DISPLAY
    static void displayStudents() throws Exception {
        Connection con = DriverManager.getConnection(url, user, pass);
        ResultSet rs = con.createStatement()
                .executeQuery("SELECT * FROM Students");

        while (rs.next()) {
            System.out.println(
                rs.getInt(1) + " " +
                rs.getString(2) + " " +
                rs.getString(3) + " " +
                rs.getInt(4) + " " +
                rs.getFloat(5)
            );
        }
        con.close();
    }

    // 3️⃣ SEARCH
    static void searchStudent() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps =
            con.prepareStatement("SELECT * FROM Students WHERE student_eno=?");
        ps.setInt(1, eno);

        ResultSet rs = ps.executeQuery();
        if (rs.next())
            System.out.println("Found: " + rs.getString("name"));
        else
            throw new Exception("Student not found");

        con.close();
    }

    // 4️⃣ UPDATE
    static void updateBranch() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        System.out.print("New Branch: ");
        String branch = sc.next();
        if (branch.isEmpty()) throw new Exception("Branch cannot be empty");

        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps =
            con.prepareStatement("UPDATE Students SET branch=? WHERE student_eno=?");

        ps.setString(1, branch);
        ps.setInt(2, eno);

        if (ps.executeUpdate() == 0)
            throw new Exception("Student not found");

        System.out.println("Branch updated");
        con.close();
    }

    // 5️⃣ DELETE
    static void deleteStudent() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps =
            con.prepareStatement("DELETE FROM Students WHERE student_eno=?");
        ps.setInt(1, eno);

        if (ps.executeUpdate() == 0)
            throw new Exception("Student not found");

        System.out.println("Student deleted");
        con.close();
    }

    // 6️⃣ SORT
    static void sortStudents() throws Exception {
        Connection con = DriverManager.getConnection(url, user, pass);
        ResultSet rs = con.createStatement()
                .executeQuery("SELECT * FROM Students ORDER BY percentage DESC");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " +
                               rs.getString(2) + " " +
                               rs.getFloat(5));
        }
        con.close();
    }

    // 🔎 CHECK UNIQUE
    static boolean exists(int eno) throws Exception {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps =
            con.prepareStatement("SELECT student_eno FROM Students WHERE student_eno=?");
        ps.setInt(1, eno);
        ResultSet rs = ps.executeQuery();
        boolean found = rs.next();
        con.close();
        return found;
    }
}