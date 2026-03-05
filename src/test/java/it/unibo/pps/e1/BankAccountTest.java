package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BankAccountTest {

    protected BankAccount account;

    protected abstract BankAccount createBankAccountToTest();

    @BeforeEach
    void init() {
        this.account = createBankAccountToTest();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        int depositAmount = 1000;
        this.account.deposit(depositAmount);
        assertEquals(depositAmount, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        int depositAmount = 1000;
        int withdrawAmount = 200;
        this.account.deposit(depositAmount);
        this.account.withdraw(withdrawAmount);
        assertEquals(depositAmount - withdrawAmount, this.account.getBalance());
    }
}
