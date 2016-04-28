package pl.put.miasi.bank.bankOperations.depositOperations;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.isA;
import static org.junit.Assert.assertEquals;

/**
 * @author Bartosz Skotarek
 */
public class DepositBrokeTest extends EasyMockSupport {
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

        bankAccount.payment(eq(amount));
        bankAccount.removeDeposit(isA(Deposit.class));

        replayAll();

        Deposit deposit = new Deposit(amount);
        deposit.setInterestMechanism(interestMechanism);

        DepositBroke depositBroke = new DepositBroke("Test", bankAccount, deposit);
        depositBroke.execute();

        assertEquals(deposit.getBalance(), 1000, 0.0);
        verifyAll();
    }

}