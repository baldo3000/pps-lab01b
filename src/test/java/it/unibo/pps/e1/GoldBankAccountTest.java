package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends AbstractBankAccountTest {

    private final int OVERDRAFT = 500;

    @BeforeEach
    void init() {
        BankAccountFactory factory = new BankAccountFactoryImpl();
        this.account = factory.createGoldBankAccount();
    }

    @Test
    public void testWithdrawMoreThanAvailableBelowLimit() {
        int depositAmount = 1000;
        int withdrawAmount = depositAmount + OVERDRAFT;
        this.account.deposit(depositAmount);
        this.account.withdraw(withdrawAmount);
        assertEquals(depositAmount - withdrawAmount, this.account.getBalance());
    }

    @Test
    public void testWithdrawMoreThanAvailableAboveLimit() {
        int depositAmount = 1000;
        int withdrawAmount = depositAmount + OVERDRAFT + 1;
        this.account.deposit(depositAmount);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }
}
