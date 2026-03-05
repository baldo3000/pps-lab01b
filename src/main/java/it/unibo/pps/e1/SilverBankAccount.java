package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount {
    private final int FEE_AMOUNT = 1;

    private final BankAccount base;

    public SilverBankAccount(BankAccount account) {
        this.base = account;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount) {
            throw new IllegalStateException();
        }
        base.withdraw(amount + FEE_AMOUNT);
    }
}
