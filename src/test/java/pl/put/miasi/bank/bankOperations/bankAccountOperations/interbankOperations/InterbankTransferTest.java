package pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

import java.security.InvalidParameterException;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.fail;

/**
 * @author Bartosz Skotarek
 */
public class InterbankTransferTest extends EasyMockSupport {

    @Test
    public void executeNullPointerException() throws Exception {
        replayAll();

        InterbankTransfer interbankTransfer = new InterbankTransfer("Test", 1, 2, 100, TransferDirection.IN);
        try {
            interbankTransfer.execute();
            fail();
        } catch (NullPointerException e) {
            verifyAll();
        }
    }

    @Test
    public void executeNegativeAmount() throws Exception {
        replayAll();

        InterbankTransfer interbankTransfer = new InterbankTransfer("Test", 1, 2, -100, TransferDirection.IN);
        interbankTransfer.setExecutorObject(new BankAccount());
        try {
            interbankTransfer.execute();
            fail();
        } catch (InvalidParameterException e) {
            verifyAll();
        }
    }

    @Test
    public void execute() throws Exception {
        double amount = 100.0;

        replayAll();

        InterbankTransfer interbankTransfer = new InterbankTransfer("Test", 1, 2, amount, TransferDirection.IN);
        interbankTransfer.setExecutorObject(new BankAccount());

        interbankTransfer.execute();

        verifyAll();
    }


}