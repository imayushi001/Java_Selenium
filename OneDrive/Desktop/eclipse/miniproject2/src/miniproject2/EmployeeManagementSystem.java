package miniproject2;
import java.io.*;
import java.util.*;

// Custom Exception
class ValidationException extends Exception {
    ValidationException(String msg) {
        super(msg);
    }
}

// Employee class
class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void show() {
        System.out.println(id + " | " + name + " | " + department + " | " + salary);
    }
}

// Main class
public class EmployeeManagementSystem {

    static final String FILE_NAME = "employees.dat";
    static Map<Integer, Employee> empMap = new HashMap<>();

    // ---------------- FILE HANDLING ----------------

    static void loadFromFile() {
        try {
            File f = new File(FILE_NAME);
            if (!f.exists()) return;

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            empMap = (HashMap<Integer, Employee>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
    }

    static void saveToFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(empMap);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    // ---------------- VALIDATIONS ----------------

    static void validateEmployee(Employee e) throws ValidationException {
        if (empMap.containsKey(e.id))
            throw new ValidationException("Employee ID already exists!");

        if (e.salary <= 0)
            throw new ValidationException("Salary must be positive!");

        if (e.department == null || e.department.trim().isEmpty())
            throw new ValidationException("Department cannot be empty!");
    }

    // ---------------- OPERATIONS ----------------

    static void addEmployee(Scanner sc) {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            Employee e = new Employee(id, name, dept, salary);
            validateEmployee(e);

            empMap.put(id, e);
            saveToFile();
            System.out.println("Employee Added Successfully.");

        } catch (ValidationException ve) {
            System.out.println(ve.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    static void displayEmployees() {
        if (empMap.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("ID | Name | Department | Salary");
        for (Employee e : empMap.values()) {
            e.show();
        }
    }

    static void searchEmployee(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        Employee e = empMap.get(id);

        if (e != null)
            e.show();
        else
            System.out.println("Employee not found.");
    }

    static void updateSalary(Scanner sc) {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            Employee e = empMap.get(id);
            if (e == null) {
                System.out.println("Employee not found.");
                return;
            }

            System.out.print("Enter New Salary: ");
            double sal = sc.nextDouble();

            if (sal <= 0)
                throw new ValidationException("Salary must be positive!");

            e.salary = sal;
            saveToFile();
            System.out.println("Salary Updated Successfully.");

        } catch (ValidationException ve) {
            System.out.println(ve.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    static void deleteEmployee(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        if (empMap.remove(id) != null) {
            saveToFile();
            System.out.println("Employee Deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    static void displaySortedEmployees() {
        List<Employee> list = new ArrayList<>(empMap.values());
        list.sort(Comparator.comparingDouble(e -> e.salary));

        for (Employee e : list) {
            e.show();
        }
    }

    static void displayDepartments() {
        Set<String> deptSet = new HashSet<>();

        for (Employee e : empMap.values()) {
            deptSet.add(e.department);
        }

        System.out.println("Departments:");
        for (String d : deptSet) {
            System.out.println(d);
        }
    }

    // ---------------- LOGIN ----------------

    static boolean login(Scanner sc) {
        String USER = "admin";
        String PASS = "admin123";

        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        return USER.equals(u) && PASS.equals(p);
    }

    // ---------------- MAIN ----------------

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        loadFromFile();

        System.out.println("=== Employee Management System ===");

        if (!login(sc)) {
            System.out.println("Login Failed!");
            return;
        }

        while (true) {
            System.out.println("\n1.Add Employee");
            System.out.println("2.Display All Employees");
            System.out.println("3.Search Employee by ID");
            System.out.println("4.Update Employee Salary");
            System.out.println("5.Delete Employee");
            System.out.println("6.Display Sorted Employees");
            System.out.println("7.Display Departments");
            System.out.println("8.Exit");
            System.out.print("Enter choice: ");

            try {
                int ch = sc.nextInt();
                switch (ch) {
                    case 1: addEmployee(sc); break;
                    case 2: displayEmployees(); break;
                    case 3: searchEmployee(sc); break;
                    case 4: updateSalary(sc); break;
                    case 5: deleteEmployee(sc); break;
                    case 6: displaySortedEmployees(); break;
                    case 7: displayDepartments(); break;
                    case 8:
                        System.out.println("Program Ended.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        }
    }
}
