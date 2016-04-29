package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;

import static org.easymock.EasyMock.eq;

/**
 * Created by inf109714 on 2016-04-15.
 */
public class TransferTest extends EasyMockSupport {
    private BankAccount sourceBankAccountImpl;
    private BankAccount targetBankAccountImpl;
    private Transfer transfer;

    @Before
    public void setup() {
        sourceBankAccountImpl = mock(BankAccount.class);
        targetBankAccountImpl = mock(BankAccount.class);
    }

    @Test
    public void testGetOperationName() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
        double amount = 400;
        targetBankAccountImpl.payment(eq(amount));
        replayAll();

        transfer = new Transfer("Test transfer", sourceBankAccountImpl, targetBankAccountImpl, amount);
        transfer.execute();

        verifyAll();
    }

    @Test
    public void testPaymentAmountNegative() throws Exception {
        double amount = -400;
        sourceBankAccountImpl.withdraw(eq(-amount));
        replayAll();

        transfer = new Transfer("Test transfer", sourceBankAccountImpl, targetBankAccountImpl, amount);
        transfer.execute();

        verifyAll();
    }
}