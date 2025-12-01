import java.util.Scanner;

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
                        acc.withdraw(sc.nextDouble());
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
