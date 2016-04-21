package pl.put.miasi.bank.bankOperations.creditOperations;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import java.security.InvalidParameterException;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.isA;
import static org.junit.Assert.*;

/**
 * @author Bartosz Skotarek
 */
public class CreditTakingTest extends EasyMockSupport {
    private BankAccount bankAccount;
    private InterestMechanism interestMechanism;

    @Before
    public void before() throws InterestRateException, BalanceException {
        bankAccount = mock(BankAccount.class);
        interestMechanism = mock(InterestMechanism.class);
    }

    @Test
    public void execute() throws Exception {
        double amount = 1000.0;

        bankAccount.updateBalance(eq(amount));
        bankAccount.addBankOperation(isA(CreditTaking.class));
        replayAll();

        CreditTaking creditTaking = new CreditTaking("Test", amount, bankAccount, interestMechanism);
        creditTaking.execute();

        verifyAll();
    }

    @Test
    public void executeInsufficientResources() throws Exception {
        double amount = -1000.0;

        replayAll();

        try {
            CreditTaking creditTaking = new CreditTaking("Test", amount, bankAccount, interestMechanism);
            creditTaking.execute();

            fail();
        } catch (InvalidParameterException e) {
            verifyAll();
        }
    }
}