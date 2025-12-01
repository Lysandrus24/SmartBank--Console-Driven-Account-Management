public class StudentAccount extends Account {

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
