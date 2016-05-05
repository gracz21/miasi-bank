package pl.put.miasi.bank.banks;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations.InterbankOperation;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations.InterbankTransfer;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;

import java.util.HashMap;
import java.util.Map;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.junit.Assert.*;

/**
 * @author Kamil Walkowiak
 */
public class BankTest extends EasyMockSupport {
    private Bank bank;
    private BankAccount bankAccount;
    private Map<Long, InterbankOperation> interbankOperations;
    private InterbankTransfer interbankTransfer;

    @Before
    public void before() {
        bank = new Bank();
        bankAccount = mock(BankAccount.class);
        interbankOperations = new HashMap<>();
        interbankTransfer = mock(InterbankTransfer.class);
    }

    @Test
    public void handleInterbankOperationsTest() throws Exception {
        long sourceBankId = 2;
        long accountId = 1;

        interbankTransfer.setExecutorObject(eq(bankAccount));
        expect(bankAccount.getId()).andReturn(accountId);
        bankAccount.doOperation(eq(interbankTransfer));
        replayAll();

        interbankOperations.put(accountId, interbankTransfer);
        bank.addBankProduct(bankAccount);

        bank.handleInterbankOperations(sourceBankId, interbankOperations);
        verifyAll();
    }

    @Test
    public void handleInterbankOperationsTargetNotExistTest() throws Exception {
        long sourceBankId = 2;
        long accountId = 1;

        expect(interbankTransfer.getDescription()).andReturn("Test");
        expect(interbankTransfer.getAmount()).andReturn(100.0);
        expect(interbankTransfer.getSourceBankAccountId()).andReturn(sourceBankId);
        expect(bankAccount.getId()).andReturn(accountId);
        replayAll();

        interbankOperations.put((long) 2, interbankTransfer);
        bank.addBankProduct(bankAccount);

        bank.handleInterbankOperations(sourceBankId, interbankOperations);
        verifyAll();
    }
}