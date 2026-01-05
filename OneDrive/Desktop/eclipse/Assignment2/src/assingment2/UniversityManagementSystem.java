package assingment2;

import java.util.*;
import java.util.regex.Pattern;

//Interface
interface UniversityOperations {
    void addStudent();
    void displayStudents();
    void removeStudentById();
    void searchStudentById();
    void sortStudentsByMarks();
    void convertHashMapToTreeMap();
    void countStudentsCourseWise();
    void displayAllCourses();
}

//Student Class
class Students {
    int id;
    String name;
    String course;
    int marks;

    Students(int id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }
}

//Main Class
public class UniversityManagementSystem implements UniversityOperations {

    // Collections
    List<Students> studentList = new ArrayList<>();
    Vector<Students> studentVector = new Vector<>();
    Stack<Students> studentStack = new Stack<>();

    HashMap<Integer, Students> studentMap = new HashMap<>();
    Hashtable<Integer, Students> studentTable = new Hashtable<>();
    TreeMap<Integer, Students> studentTreeMap = new TreeMap<>();

    Set<String> courseSet = new HashSet<>();   // unique courses

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        UniversityManagementSystem usms =
                new UniversityManagementSystem();
        usms.menu();
    }

    //Menu 
    void menu() {
        while (true) {
            try {
                System.out.println("\n--- UNIVERSITY STUDENT MANAGEMENT ---");
                System.out.println("1. Add Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Remove Student by ID");
                System.out.println("4. Search Student by ID");
                System.out.println("5. Sort Students by Marks");
                System.out.println("6. Convert HashMap to TreeMap");
                System.out.println("7. Count Students Course-wise");
                System.out.println("8. Display All Courses");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: displayStudents(); break;
                    case 3: removeStudentById(); break;
                    case 4: searchStudentById(); break;
                    case 5: sortStudentsByMarks(); break;
                    case 6: convertHashMapToTreeMap(); break;
                    case 7: countStudentsCourseWise(); break;
                    case 8: displayAllCourses(); break;
                    case 9:
                        System.out.println("Program Exited");
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice");
                }

            } catch (Exception e) {
                System.out.println("Invalid Input!");
                sc.nextLine();
            }
        }
    }

    /* ---------- Add Student ---------- */
    public void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (studentMap.containsKey(id)) {
                System.out.println("Duplicate ID not allowed!");
                return;
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            if (!Pattern.matches("[A-Za-z ]+", name)) {
                System.out.println("Invalid Name!");
                return;
            }

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            Students s = new Students(id, name, course, marks);

            studentList.add(s);
            studentVector.add(s);
            studentStack.push(s);
            studentMap.put(id, s);
            studentTable.put(id, s);
            courseSet.add(course);

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            System.out.println("Error while adding student.");
            sc.nextLine();
        }
    }

    /* ---------- Display Students ---------- */
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No Students Found.");
            return;
        }

        System.out.println("\n--- Student Records ---");
        for (Students s : studentList) {
            System.out.println("ID: " + s.id +
                    ", Name: " + s.name +
                    ", Course: " + s.course +
                    ", Marks: " + s.marks);
        }
    }

    /* ---------- Remove Student ---------- */
    public void removeStudentById() {
        System.out.print("Enter Student ID to Remove: ");
        int id = sc.nextInt();

        Students s = studentMap.remove(id);
        if (s != null) {
            studentList.remove(s);
            studentVector.remove(s);
            studentStack.remove(s);
            studentTable.remove(id);
            System.out.println("Student Removed!");
        } else {
            System.out.println("Student Not Found!");
        }
    }

    /* ---------- Search Student ---------- */
    public void searchStudentById() {
        System.out.print("Enter Student ID to Search: ");
        int id = sc.nextInt();

        Students s = studentMap.get(id);
        if (s != null) {
            System.out.println("Student Found:");
            System.out.println("ID: " + s.id +
                    ", Name: " + s.name +
                    ", Course: " + s.course +
                    ", Marks: " + s.marks);
        } else {
            System.out.println("Student Not Found!");
        }
    }

    /* ---------- Sort by Marks ---------- */
    public void sortStudentsByMarks() {
        studentList.sort((a, b) -> b.marks - a.marks);
        System.out.println("Students Sorted by Marks (Descending).");
        displayStudents();
    }

    /* ---------- HashMap to TreeMap ---------- */
    public void convertHashMapToTreeMap() {
        studentTreeMap = new TreeMap<>(studentMap);
        System.out.println("HashMap converted to TreeMap (Sorted by ID).");
    }

    /* ---------- Course-wise Count ---------- */
    public void countStudentsCourseWise() {
        Map<String, Integer> countMap = new HashMap<>();

        for (Students s : studentList) {
            countMap.put(s.course,
                    countMap.getOrDefault(s.course, 0) + 1);
        }

        System.out.println("\n--- Course-wise Student Count ---");
        for (String course : countMap.keySet()) {
            System.out.println(course + " : " + countMap.get(course));
        }
    }

    /* ---------- Display Courses ---------- */
    public void displayAllCourses() {
        System.out.println("\n--- Available Courses (Unique) ---");
        for (String c : courseSet) {
            System.out.println(c);
        }
    }
}