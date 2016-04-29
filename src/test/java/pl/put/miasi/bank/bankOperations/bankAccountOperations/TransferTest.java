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
    private BankAccount sourceBankAccount;
    private BankAccount targetBankAccount;
    private Transfer transfer;

    @Before
    public void setup() {
        sourceBankAccount = mock(BankAccount.class);
        targetBankAccount = mock(BankAccount.class);
    }

    @Test
    public void testGetOperationName() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
        double amount = 400;
        targetBankAccount.payment(eq(amount));
        replayAll();

        transfer = new Transfer("Test transfer", sourceBankAccount, targetBankAccount, amount);
        transfer.execute();

        verifyAll();
    }

    @Test
    public void testPaymentAmountNegative() throws Exception {
        double amount = -400;
        sourceBankAccount.withdraw(eq(-amount));
        replayAll();

        transfer = new Transfer("Test transfer", sourceBankAccount, targetBankAccount, amount);
        transfer.execute();

        verifyAll();
    }
}