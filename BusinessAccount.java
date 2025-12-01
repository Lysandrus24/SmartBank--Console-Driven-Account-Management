public class BusinessAccount extends Account {

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
