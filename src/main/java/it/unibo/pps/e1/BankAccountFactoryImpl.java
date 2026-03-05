package it.unibo.pps.e1;

import java.util.function.Function;

public class BankAccountFactoryImpl implements BankAccountFactory {

    private BankAccount createFeeBankAccountWithOverdraftChecked(Function<Integer, Integer> feeCalculator, int maxOverdraft) {
        return new FeeBankAccount(new OverdraftCheckBankAccount(new CoreBankAccount(), maxOverdraft), feeCalculator);
    }

    @Override
    public BankAccount createGoldBankAccount() {
        int maxOverdraft = 500;
        return createFeeBankAccountWithOverdraftChecked(amount -> 0, maxOverdraft);
    }

    @Override
    public BankAccount createSilverBankAccount() {
        int maxOverdraft = 0;
        int fee = 1;
        return createFeeBankAccountWithOverdraftChecked(amount -> fee, maxOverdraft);
    }

    @Override
    public BankAccount createBronzeBankAccount() {
        int maxOverdraft = 0;
        int fee = 1;
        int feeThreshold = 100;
        return createFeeBankAccountWithOverdraftChecked(amount -> amount < feeThreshold ? 0 : fee, maxOverdraft);
    }
}
