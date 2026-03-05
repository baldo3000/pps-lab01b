package it.unibo.pps.e1;

import java.util.function.Function;

public class FeeBankAccount implements BankAccount {

    private final BankAccount decoratedAccount;
    private final Function<Integer, Integer> feeCalculator;

    public FeeBankAccount(BankAccount account, Function<Integer, Integer> feeCalculator) {
        this.decoratedAccount = account;
        this.feeCalculator = feeCalculator;
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
        decoratedAccount.withdraw(amount + this.feeCalculator.apply(amount));
    }
}
