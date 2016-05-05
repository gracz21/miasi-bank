package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.fail;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import java.security.InvalidParameterException;

/**
 * Created by inf109714 on 2016-04-15.
 */
public class PaymentTest extends EasyMockSupport {
    private BankAccountDecorator bankAccountDecorator;
    private Payment payment;

    @Before
    public void setup() throws BalanceException {
        bankAccountDecorator = mock(BankAccount.class);
    }

    @Test
    public void testGetOperationName() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
        double amount = 400;
        bankAccountDecorator.payment(eq(amount));
        replayAll();

        payment = new Payment("Test payment", bankAccountDecorator, amount);
        payment.execute();

        verifyAll();
    }

    @Test
    public void testPaymentAmountNegative() throws Exception {
        double amount = -400;
        replayAll();

        payment = new Payment("Test payment", bankAccountDecorator, amount);
        try {
            payment.execute();
            fail();
        } catch (InvalidParameterException e) {
            verifyAll();
        }
    }
}