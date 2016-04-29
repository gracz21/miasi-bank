package pl.put.miasi.bank.bankOperations.depositOperations;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import java.security.InvalidParameterException;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.isA;
import static org.junit.Assert.fail;

/**
 * @author Bartosz Skotarek
 */
public class DepositAssumptionTest extends EasyMockSupport {
    private BankAccount bankAccountImpl;
    private InterestMechanism interestMechanism;

    @Before
    public void before() throws InterestRateException, BalanceException {
        bankAccountImpl = mock(BankAccount.class);
        interestMechanism = mock(InterestMechanism.class);
    }

    @Test
    public void depositAssumption() throws Exception {
        double amount = 1000.0;

        bankAccountImpl.withdraw(eq(amount));
        bankAccountImpl.addDeposit(isA(Deposit.class));

        replayAll();

        DepositAssumption depositAssumption = new DepositAssumption("Test", bankAccountImpl, amount, interestMechanism);
        depositAssumption.execute();

        verifyAll();
    }

    @Test
    public void executeInsufficientResources() throws Exception {
        double amount = -1000.0;

        replayAll();

        try {
            DepositAssumption depositAssumption = new DepositAssumption("Test", bankAccountImpl, amount, interestMechanism);
            depositAssumption.execute();

            fail();
        } catch (InvalidParameterException e) {
            verifyAll();
        }
    }

}