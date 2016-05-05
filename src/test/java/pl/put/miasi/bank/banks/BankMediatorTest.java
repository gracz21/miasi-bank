package pl.put.miasi.bank.banks;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.fail;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations.InterbankOperation;
import pl.put.miasi.bank.banks.exceptions.BankNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kamil Walkowiak
 */
public class BankMediatorTest extends EasyMockSupport {
    private BankMediator bankMediator;
    private Bank bank;
    private Map<Long, InterbankOperation> interbankOperations;

    @Before
    public void before() {
        bankMediator = new BankMediator();
        bank = mock(Bank.class);
        interbankOperations = new HashMap<>();
        interbankOperations.put((long) 1, mock(InterbankOperation.class));
    }

    @Test
    public void testDeliverInterbankOperation() throws Exception {
        long sourceBankId = 1;
        long targetBankId = 2;

        expect(bank.getBankId()).andReturn(targetBankId).times(2);
        bank.handleInterbankOperations(eq(sourceBankId), eq(interbankOperations));
        replayAll();

        bankMediator.addBank(bank);
        bankMediator.deliverInterbankOperation(sourceBankId, targetBankId, interbankOperations);
        verifyAll();
    }

    @Test
    public void testDeliverInterbankOperationWithException() throws Exception {
        long sourceBankId = 1;
        long targetBankId = 2;

        expect(bank.getBankId()).andReturn(targetBankId);
        replayAll();

        bankMediator.addBank(bank);
        try {
            bankMediator.deliverInterbankOperation(sourceBankId, 3, interbankOperations);
            fail();
        } catch(BankNotFoundException e) {
            verifyAll();
        }

    }
}