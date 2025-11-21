import java.util.ArrayList;
import java.util.Scanner;

// ===== ABSTRACTION =====
abstract class Account {
    private String accountNumber;
    private String accountHolder;
    protected double balance;
    protected ArrayList<String> transactionHistory = new ArrayList<>();

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        transactionHistory.add("Initial Deposit: +" + balance);
    }

    // ===== ENCAPSULATION (GETTERS) =====
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }

    // Common Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposit: +" + amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // ===== POLYMORPHISM (abstract method) =====
    public abstract void withdraw(double amount);

    public void showHistory() {
        System.out.println("----- TRANSACTION HISTORY -----");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }

    public void showInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// ===== INHERITANCE: SavingsAccount =====
class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdraw: -" + amount);
            System.out.println("Withdrawal Successful! (Savings Account Rules)");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}

// ===== INHERITANCE: StudentAccount =====
class StudentAccount extends Account {

    public StudentAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdraw: -" + amount);
            System.out.println("Withdrawal Successful! (Student Account Rules)");
        } else {
            System.out.println("Invalid amount or insufficient balance!");
        }
    }
}

// ===== MAIN SYSTEM =====
public class SmartBank {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==================================");
            System.out.println(" SMARTBANK SYSTEM ");
            System.out.println("==================================");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> loginAccount();
                case 3 -> {
                    System.out.println("Thank you for using SmartBank!");
                    return;
                }
                default -> System.out.println("Invalid input! Try again.");
            }
        }
    }

    public static void createAccount() {
        System.out.print("Enter Full Name: ");
        String holder = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String number = sc.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double initial = sc.nextDouble();
        sc.nextLine();

        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Student Account");
        int type = sc.nextInt();

        Account acc;
        if (type == 1) acc = new SavingsAccount(number, holder, initial);
        else acc = new StudentAccount(number, holder, initial);

        accounts.add(acc);
        System.out.println("Account Created Successfully!");
    }

    public static void loginAccount() {
        System.out.print("Enter Account Number: ");
        String number = sc.nextLine();

        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(number)) {
                accountMenu(acc);
                return;
            }
        }
        System.out.println("Account not found!");
    }

    public static void accountMenu(Account acc) {
        while (true) {
            System.out.println("\n===== ACCOUNT MENU =====");
            acc.showInfo();

            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: ");
                    acc.deposit(sc.nextDouble());
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    acc.withdraw(sc.nextDouble()); // << Polymorphism still applied
                }
                case 3 -> System.out.println("Current Balance: " + acc.getBalance());
                case 4 -> acc.showHistory();
                case 5 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}