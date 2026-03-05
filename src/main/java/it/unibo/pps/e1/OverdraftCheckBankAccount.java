package it.unibo.pps.e1;

public class OverdraftCheckBankAccount implements BankAccount {
    private final BankAccount decoratedAccount;
    private final int maxOverdraft;

    public OverdraftCheckBankAccount(BankAccount account, int maxOverdraft) {
        this.decoratedAccount = account;
        this.maxOverdraft = maxOverdraft;
    }

    @Override
    public int getBalance() {
        return decoratedAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        decoratedAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() - amount < -maxOverdraft) {
            throw new IllegalStateException();
        }
        decoratedAccount.withdraw(amount);
    }
}
