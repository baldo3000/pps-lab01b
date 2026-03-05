package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest {

    @Override
    protected BankAccount createBankAccountToTest() {
        return new SilverBankAccount(new CoreBankAccount());
    }

    @Test
    @Override
    public void testCanWithdraw() {
        int depositAmount = 1000;
        int withdrawAmount = 200;
        this.account.deposit(depositAmount);
        this.account.withdraw(withdrawAmount);
        assertEquals(depositAmount - withdrawAmount - 1, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        int depositAmount = 1000;
        int withdrawAmount = 1200;
        this.account.deposit(depositAmount);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }
}
