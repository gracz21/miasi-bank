package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.fail;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

/**
 * Created by inf109714 on 2016-04-15.
 */
public class PaymentTest extends EasyMockSupport {
    BankAccount bankAccount;
    Payment payment;
    double amount;

    @Before
    public void setup() throws BalanceException {
        bankAccount = mock(BankAccount.class);
    }

    @Test
    public void testGetOperationName() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
        amount = 400;
        bankAccount.updateBalance(eq(amount));
        replayAll();

        payment = new Payment("Test payment", bankAccount, amount);
        payment.execute();

        verifyAll();
    }

    @Test
    public void testPaymentAmountNegative() throws Exception {
        amount = -400;
        bankAccount.updateBalance(eq(amount));
        replayAll();

        payment = new Payment("Test payment", bankAccount, amount);
        try {
            payment.execute();
            fail();
        } catch (BalanceException e) {
            verifyAll();
        }
    }

    @Test
    public void testPaymentExecutedAgain() throws Exception {
        amount = 400;
        bankAccount.updateBalance(eq(amount));
        replayAll();

        payment = new Payment("Test payment", bankAccount, amount);
        payment.execute();
        try {
            payment.execute();
            fail();
        } catch (UnsupportedOperationException e) {
            verifyAll();
        }
    }
}