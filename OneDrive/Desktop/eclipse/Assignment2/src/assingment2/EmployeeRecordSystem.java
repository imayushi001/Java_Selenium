package assingment2;

import java.util.*;
import java.util.regex.*;

// Interface
interface EmployeeOperations {
    void addEmployee(Employee e);
    void displayEmployees();
    void searchEmployee(int id);
    void removeEmployee(int id);
}

// Employee class
class Employee {
    int id;
    String name;
    String email;

    Employee(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    void show() {
        System.out.println("ID: " + id +
                           ", Name: " + name +
                           ", Email: " + email);
    }
}

// Main class
public class EmployeeRecordSystem implements EmployeeOperations {

    // Collections
    HashMap<Integer, Employee> hashMap = new HashMap<>();
    Hashtable<Integer, Employee> hashTable = new Hashtable<>();
    TreeMap<Integer, Employee> treeMap = new TreeMap<>();

    // REGEX for email validation
    boolean validEmail(String email) {
        String regex = ".+@.+\\..+";
        return Pattern.matches(regex, email);
    }

    // Add employee
    public void addEmployee(Employee e) {
        hashMap.put(e.id, e);
        hashTable.put(e.id, e);
        treeMap.put(e.id, e);
        System.out.println("Employee Added Successfully.");
    }

    // Display employees (TreeMap for sorted order)
    public void displayEmployees() {
        if (treeMap.isEmpty()) {
            System.out.println("No Employee Records Found.");
            return;
        }
        for (Employee e : treeMap.values()) {
            e.show();
        }
    }

    // Search employee
    public void searchEmployee(int id) {
        Employee e = hashMap.get(id);
        if (e != null) {
            e.show();
        } else {
            System.out.println("Employee Not Found.");
        }
    }

    // Remove employee
    public void removeEmployee(int id) {
        if (hashMap.containsKey(id)) {
            hashMap.remove(id);
            hashTable.remove(id);
            treeMap.remove(id);
            System.out.println("Employee Removed Successfully.");
        } else {
            System.out.println("Employee Not Found.");
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeRecordSystem obj = new EmployeeRecordSystem();

        // Demonstrating null support
        System.out.println("\n--- Null Support Demo ---");
        obj.hashMap.put(null, null);  // Allowed
        
        System.out.println("HashMap allows ONE null key & multiple null values.");
        System.out.println("Hashtable does NOT allow null key or null value.");
        System.out.println("TreeMap does NOT allow null key.");

        while (true) {
            System.out.println("\n1.Add Employee");
            System.out.println("2.Display Employees");
            System.out.println("3.Search Employee");
            System.out.println("4.Remove Employee");
            System.out.println("5.Exit");
            System.out.print("Enter Choice: ");

            try {
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        if (!obj.validEmail(email)) {
                            throw new Exception("Invalid Email Format!");
                        }

                        Employee e = new Employee(id, name, email);
                        obj.addEmployee(e);
                        break;

                    case 2:
                        obj.displayEmployees();
                        break;

                    case 3:
                        System.out.print("Enter Employee ID to Search: ");
                        obj.searchEmployee(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter Employee ID to Remove: ");
                        obj.removeEmployee(sc.nextInt());
                        break;

                    case 5:
                        System.out.println("Program Ended.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter valid input!");
                sc.nextLine();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
