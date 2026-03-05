package it.unibo.pps.e1;

public class CoreBankAccountTest extends BankAccountTest {
    @Override
    protected BankAccount createBankAccountToTest() {
        return new CoreBankAccount();
    }
}
