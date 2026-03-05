package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;

public class CoreBankAccountTest extends AbstractBankAccountTest {
    @BeforeEach
    void init() {
        this.account = new CoreBankAccount();
    }
}
