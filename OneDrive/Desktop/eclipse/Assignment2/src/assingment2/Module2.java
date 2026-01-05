package assingment2;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Module2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            try {
                System.out.println("\n--- REGEX VALIDATION MENU ---");
                System.out.println("1. Validate Mobile Number");
                System.out.println("2. Validate Email ID");
                System.out.println("3. Validate Username");
                System.out.println("4. Validate Password");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine(); // enter key clear

                if (choice == 1) {
                    System.out.print("Enter Mobile Number: ");
                    String mobile = sc.nextLine();

                    if (validateMobile(mobile))
                        System.out.println("Welcome! Valid Mobile Number");
                    else
                        System.out.println("Invalid Mobile Number");
                }

                else if (choice == 2) {
                    System.out.print("Enter Email ID: ");
                    String email = sc.nextLine();

                    if (validateEmail(email))
                        System.out.println("Welcome! Valid Email ID");
                    else
                        System.out.println("Invalid Email ID");
                }

                else if (choice == 3) {
                    System.out.print("Enter Username: ");
                    String username = sc.nextLine();

                    if (validateUsername(username))
                        System.out.println("Welcome! Valid Username");
                    else
                        System.out.println("Invalid Username");
                }

                else if (choice == 4) {
                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();

                    if (validatePassword(password))
                        System.out.println("Welcome! Valid Password");
                    else
                        System.out.println("Invalid Password");
                }

                else if (choice == 5) {
                    System.out.println("Thank you! Program exited.");
                    break;
                }

                else {
                    System.out.println("Invalid choice!");
                }
            }
            catch (Exception e) {
                System.out.println("Error! Please enter correct input.");
                sc.nextLine();
            }
        }
        sc.close();
    }

    // Mobile: 10 digits, starts with 6-9
    static boolean validateMobile(String mobile) {
        return Pattern.matches("[6-9][0-9]{9}", mobile);
    }

    // Email validation
    static boolean validateEmail(String email) {
        return Pattern.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+", email);
    }

    // Username: min 5 chars, letters & digits
    static boolean validateUsername(String username) {
        return Pattern.matches("[A-Za-z0-9]{5,}", username);
    }

    // Password: min 8 chars, 1 digit, 1 capital, 1 special char
    static boolean validatePassword(String password) {
        return Pattern.matches("(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}", password);
    }
}
