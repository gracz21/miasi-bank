package pl.put.miasi.bank.bankOperations.bankAccountOperations;


import static org.easymock.EasyMock.*;
import static org.junit.Assert.fail;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

import java.security.InvalidParameterException;

/**
 * Created by inf109714 on 2016-04-15.
 */
public class WithdrawalTest extends EasyMockSupport {
    private BankAccountDecorator bankAccountDecorator;
    private Withdrawal withdrawal;

    @Before
    public void setup() {
        bankAccountDecorator = mock(BankAccount.class);
    }

    @Test
    public void testGetOperationName() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
        double amount = 400;
        bankAccountDecorator.withdraw(eq(amount));
        replayAll();

        withdrawal = new Withdrawal("Test withdrawal", bankAccountDecorator, amount);
        withdrawal.execute();
        verifyAll();
    }

    @Test
    public void testPaymentAmountNegative() throws Exception {
        double amount = -400;
        replayAll();

        withdrawal = new Withdrawal("Test withdrawal", bankAccountDecorator, amount);
        try {
            withdrawal.execute();
            fail();
        } catch (InvalidParameterException e) {
            verifyAll();
        }
    }

    @Test
    public void testPaymentExecutedAgain() throws Exception {
        double amount = 400;
        bankAccountDecorator.withdraw(eq(amount));
        replayAll();

        withdrawal = new Withdrawal("Test withdrawal", bankAccountDecorator, amount);
        withdrawal.execute();
        try {
            withdrawal.execute();
            fail();
        } catch (UnsupportedOperationException e) {
            verifyAll();
        }
    }
}