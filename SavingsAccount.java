public class SavingsAccount extends Account {

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
