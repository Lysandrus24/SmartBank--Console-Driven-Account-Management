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
