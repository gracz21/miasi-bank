package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

import java.security.InvalidParameterException;

import static org.easymock.EasyMock.eq;
import static org.junit.Assert.fail;

/**
 * Created by inf109714 on 2016-04-15.
 */
public class TransferTest extends EasyMockSupport {
    private BankAccountDecorator sourceBankAccountDecorator;
    private BankAccountDecorator targetBankAccountDecorator;
    private Transfer transfer;

    @Before
    public void setup() {
        sourceBankAccountDecorator = mock(BankAccount.class);
        targetBankAccountDecorator = mock(BankAccount.class);
    }

    @Test
    public void testGetOperationName() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
        double amount = 400;
        targetBankAccountDecorator.payment(eq(amount));
        sourceBankAccountDecorator.withdraw(eq(amount));
        replayAll();

        transfer = new Transfer("Test transfer", sourceBankAccountDecorator, targetBankAccountDecorator, amount);
        transfer.execute();

        verifyAll();
    }

    @Test
    public void testPaymentAmountNegative() throws Exception {
        double amount = -400;
        replayAll();

        transfer = new Transfer("Test transfer", sourceBankAccountDecorator, targetBankAccountDecorator, amount);
        try {
            transfer.execute();

            fail();
        } catch (InvalidParameterException e) {
            verifyAll();
        }
    }
}