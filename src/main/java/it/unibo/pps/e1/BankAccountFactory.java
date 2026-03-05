package it.unibo.pps.e1;

public interface BankAccountFactory {
    BankAccount createGoldBankAccount();

    BankAccount createSilverBankAccount();

    BankAccount createBronzeBankAccount();
}
