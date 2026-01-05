package assingment2;
import java.util.Scanner;

//Banking interface
interface BankingOperations {
 void deposit(double amount);
 void withdraw(double amount) throws InsufficientBalanceException;
 double getBalance();
}

//Customer interface
interface CustomerOperations {
 void updateAddress(String address);
 void displayCustomerDetails();
}

//Custom Exception
class InsufficientBalanceException extends Exception {
 public InsufficientBalanceException(String message) {
     super(message);
 }
}

//BankAccount class
class BankAccount implements BankingOperations, CustomerOperations {

 private int accountNumber;
 private String customerName;
 private String address;
 private double balance;

 public BankAccount(int accountNumber, String customerName, String address, double balance) {
     this.accountNumber = accountNumber;
     this.customerName = customerName;
     this.address = address;
     this.balance = balance;
 }

 public void deposit(double amount) {
     if (amount <= 0) {
         System.out.println("Invalid deposit amount");
         return;
     }
     balance += amount;
     System.out.println("Deposited: " + amount);
 }
 public void withdraw(double amount) throws InsufficientBalanceException {
     if (amount > balance) {
         throw new InsufficientBalanceException("Insufficient balance");
     }
     balance -= amount;
     System.out.println("Withdrawn: " + amount);
 }

 public double getBalance() {
     return balance;
 }

 public void updateAddress(String address) {
     this.address = address;
     System.out.println("Address updated successfully");
 }

 public void displayCustomerDetails() {
     System.out.println("\n--- Customer Details ---");
     System.out.println("Account Number : " + accountNumber);
     System.out.println("Customer Name  : " + customerName);
     System.out.println("Address        : " + address);
     System.out.println("Balance        : " + balance);
 }
}
public class bankSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Account Number: ");
		int accNo= sc.nextInt();
		sc.nextLine();
		
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
	
        BankAccount account = new BankAccount(accNo, name, address, balance);
        
        int choice= 0;
        
        while(choice != 5) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Update Address");
            System.out.println("4. Display Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: "); 
            
            choice = sc.nextInt();
            sc.nextLine();
            
            if(choice ==1) {
            	System.out.print("Enter deposit amount: ");
            	double dep = sc.nextDouble();
            	account.deposit(dep);
            }
            else if (choice == 2) {
                     System.out.print("Enter withdraw amount: ");
                     double wd = sc.nextDouble();
                     try {
                         account.withdraw(wd);
                     } catch (InsufficientBalanceException e) {
                         System.out.println(e.getMessage());
                     }
                 }
            else if (choice == 3) {
                     System.out.print("Enter new address: ");
                     String newAddress = sc.nextLine();
                     account.updateAddress(newAddress);
                 }
            else if (choice == 4) {
                     account.displayCustomerDetails();
                 }
            else if (choice == 5) {
                     System.out.println("Thank you for using Bank Application 😊");
                 }
            else {
                     System.out.println("Invalid choice");
                 }
        }
        
        sc.close();
		
	}

}

