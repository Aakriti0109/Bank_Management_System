import java.util.*;

// Bank Account Class
class BankAccount {
    private int accountNumber;
    private String name;
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // Deposit Method
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }

    // Display Account Details
    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: " + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

// Main Class
public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    accounts.add(new BankAccount(accNo, name, balance));
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == accNo) {
                            System.out.print("Enter amount to deposit: ");
                            double amount = sc.nextDouble();
                            acc.deposit(amount);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == accNo) {
                            System.out.print("Enter amount to withdraw: ");
                            double amount = sc.nextDouble();
                            acc.withdraw(amount);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == accNo) {
                            acc.display();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}