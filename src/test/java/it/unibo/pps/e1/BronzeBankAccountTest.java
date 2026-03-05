package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends AbstractBankAccountTest {
    @BeforeEach
    void init() {
        BankAccountFactory factory = new BankAccountFactoryImpl();
        this.account = factory.createBronzeBankAccount();
    }

    @Test
    @Override
    public void testCanWithdraw() {
        int depositAmount = 1000;
        int withdrawAmount = 99;
        this.account.deposit(depositAmount);
        this.account.withdraw(withdrawAmount);
        assertEquals(depositAmount - withdrawAmount, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithFee() {
        int depositAmount = 1000;
        int withdrawAmount = 100;
        int expectedFee = 1;
        this.account.deposit(depositAmount);
        this.account.withdraw(withdrawAmount);
        assertEquals(depositAmount - withdrawAmount - expectedFee, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        int depositAmount = 1000;
        int withdrawAmount = 1200;
        this.account.deposit(depositAmount);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }
}
