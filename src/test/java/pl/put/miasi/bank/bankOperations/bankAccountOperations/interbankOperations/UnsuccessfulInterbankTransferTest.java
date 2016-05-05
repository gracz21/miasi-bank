package pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations;

import org.easymock.EasyMockSupport;
import org.junit.Test;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

/**
 * @author Bartosz Skotarek
 */
public class UnsuccessfulInterbankTransferTest extends EasyMockSupport {
    @Test
    public void executeNullPointerException() throws Exception {
        replayAll();

        UnsuccessfulInterbankTransfer unsuccessfulInterbankTransfer = new UnsuccessfulInterbankTransfer("Test", -100);
        try {
            unsuccessfulInterbankTransfer.execute();
            fail();
        } catch (InvalidParameterException e) {
            verifyAll();
        }
    }

    @Test
    public void execute() throws Exception {
        replayAll();

        UnsuccessfulInterbankTransfer unsuccessfulInterbankTransfer = new UnsuccessfulInterbankTransfer("Test", 100);
        unsuccessfulInterbankTransfer.setExecutorObject(new BankAccount());
        unsuccessfulInterbankTransfer.execute();

        verifyAll();
    }
}