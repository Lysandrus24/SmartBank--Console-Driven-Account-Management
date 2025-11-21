import java.util.Scanner;

// ===== CUSTOM EXCEPTION =====
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// ===== ABSTRACTION =====
abstract class Account {
    private String accountNumber;
    private String accountHolder;
    protected double balance;
    protected String[] transactionHistory = new String[50];
    protected int transactionCount = 0;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        addTransaction("Initial Deposit: +" + balance);
    }

    // ===== ENCAPSULATION =====
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    protected void addTransaction(String record) {
        if (transactionCount < transactionHistory.length) {
            transactionHistory[transactionCount++] = record;
        }
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit must be greater than zero!");
        }
        balance += amount;
        addTransaction("Deposit: +" + amount);
        System.out.println("Deposit successful!");
    }

    // ===== POLYMORPHISM =====
    public abstract void withdraw(double amount) throws InvalidAmountException;

    public void showHistory() {
        System.out.println("----- TRANSACTION HISTORY -----");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactionHistory[i]);
        }
    }

    public void showInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// ===== SUBCLASS 1 =====
class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal must be greater than zero!");
        }
        if (amount > balance) {
            throw new InvalidAmountException("Insufficient balance!");
        }
        balance -= amount;
        addTransaction("Withdraw: -" + amount);
        System.out.println("Withdrawal Successful! (Savings Rules)");
    }
}

// ===== SUBCLASS 2 =====
class StudentAccount extends Account {

    public StudentAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be positive!");
        }
        if (amount > 2000) {
            throw new InvalidAmountException("Student withdrawal limit is 2000 only!");
        }
        if (amount > balance) {
            throw new InvalidAmountException("Insufficient balance!");
        }
        balance -= amount;
        addTransaction("Withdraw: -" + amount);
        System.out.println("Withdrawal Successful! (Student Rules)");
    }
}

// ===== SUBCLASS 3 =====
class BusinessAccount extends Account {

    public BusinessAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {
        double fee = 50;

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid withdrawal amount!");
        }

        if (amount + fee > balance) {
            throw new InvalidAmountException("Not enough balance (includes ₱50 service fee).");
        }

        balance -= (amount + fee);
        addTransaction("Withdraw: -" + amount + " (Fee: 50)");
        System.out.println("Withdrawal Successful! (Business Rules)");
    }
}

// ===== MAIN SYSTEM =====
public class SmartBank {
    static Scanner sc = new Scanner(System.in);

    // ===== ARRAY STORAGE =====
    static Account[] accounts = new Account[100];
    static int accountCount = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n===============================");
                System.out.println("        SMARTBANK SYSTEM       ");
                System.out.println("===============================");
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
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    public static void createAccount() {
        try {
            System.out.print("Enter Full Name: ");
            String holder = sc.nextLine();

            System.out.print("Enter Account Number: ");
            String number = sc.nextLine();

            System.out.print("Enter Initial Deposit: ");
            double initial = sc.nextDouble();
            sc.nextLine();

            System.out.println("\nSelect Account Type:");
            System.out.println("1. Savings Account");
            System.out.println("2. Student Account");
            System.out.println("3. Business Account");
            System.out.print("Choice: ");
            int type = sc.nextInt();

            Account acc;

            if (type == 1) acc = new SavingsAccount(number, holder, initial);
            else if (type == 2) acc = new StudentAccount(number, holder, initial);
            else acc = new BusinessAccount(number, holder, initial);

            accounts[accountCount++] = acc;

            System.out.println("Account Created Successfully!");

        } catch (Exception e) {
            System.out.println("Error creating account: " + e.getMessage());
            sc.nextLine();
        }
    }

    public static void loginAccount() {
        System.out.print("Enter Account Number: ");
        String number = sc.nextLine();

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(number)) {
                accountMenu(accounts[i]);
                return;
            }
        }

        System.out.println("Account not found!");
    }

    public static void accountMenu(Account acc) {
        while (true) {
            try {
                System.out.println("\n===== ACCOUNT MENU =====");
                acc.showInfo();

                System.out.println("\n1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. View Transaction History");
                System.out.println("5. Logout");
                System.out.print("Choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter deposit amount: ");
                        acc.deposit(sc.nextDouble());
                    }
                    case 2 -> {
                        System.out.print("Enter withdraw amount: ");
                        acc.withdraw(sc.nextDouble()); // Polymorphism
                    }
                    case 3 -> System.out.println("Current Balance: " + acc.getBalance());
                    case 4 -> acc.showHistory();
                    case 5 -> {
                        System.out.println("Logging out...");
                        return;
                    }
                    default -> System.out.println("Invalid option!");
                }

            } catch (InvalidAmountException e) {
                System.out.println("Transaction Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("System Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}
