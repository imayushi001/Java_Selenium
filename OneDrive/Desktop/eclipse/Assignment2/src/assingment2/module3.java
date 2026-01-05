package assingment2;
import java.util.*;
import java.util.regex.*;

//interface
interface StudentOperations {
	void addStudent(Student s);
	void displayStudents();
	void removeStudent(int roll);
	void searchStudent(int roll);
}

//student class
class Student {
	int roll;
	String name;
	String email;
	
	Student(int roll, String name, String email){
		this.roll = roll;
		this.name = name;
		this.email = email;
	}
	
	void show() {
		System.out.println("Roll: "+ roll + ", name: "+ name + ",Email: "+ email);
	}
}

public class module3 implements StudentOperations {
	
	//list interface using Arraylist
	List<Student> list = new ArrayList<>();
	
	//vector collection
	Vector<Student> vector = new Vector<>();
	
	//REGEX method for email validation
	boolean validEmail(String email) {
	    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	    return Pattern.matches(regex, email);
	}

	
	//add students
	public void addStudent(Student s) {
		list.add(s);     //storing in list
		vector.add(s);  //storing in vector 
		System.out.println("Student Added Sucessfully.");
	}
	
	//display students
	public void displayStudents() {
		if (list.isEmpty()) {
			System.out.println("No records found.");
			return;
		}
		for(Student s : list) {
			s.show();
		}
	}
	
	//remove student by roll
	public void removeStudent(int roll) {
		boolean found = false;
		Iterator<Student> it = list.iterator();
		
		while (it.hasNext()) {
			Student s = it.next();
			if(s.roll == roll) {
				it.remove();
				found = true;
				System.out.println("Student removed");
				break;
			}
		}
		if (!found) {
			System.out.println("Student not found");
		}
	}
	
	// Search student by roll
    public void searchStudent(int roll) {
        for (Student s : list) {
            if (s.roll == roll) {
                s.show();
                return;
            }
        }
        System.out.println("Student Not Found.");
    }

//MAIN METHOD
public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    module3 obj = new module3();

    while (true) {
        System.out.println("\n1.Add Student");
        System.out.println("2.Display Students");
        System.out.println("3.Remove Student");
        System.out.println("4.Search Student");
        System.out.println("5.Exit");
        System.out.print("Enter Choice: ");

        try {
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    if (!obj.validEmail(email)) {
                        throw new Exception("Invalid Email Format!");
                    }

                    Student s = new Student(roll, name, email);
                    obj.addStudent(s);
                    break;

                case 2:
                    obj.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll No to Remove: ");
                    obj.removeStudent(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Roll No to Search: ");
                    obj.searchStudent(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Program Ended.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Please enter valid input!");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
}
