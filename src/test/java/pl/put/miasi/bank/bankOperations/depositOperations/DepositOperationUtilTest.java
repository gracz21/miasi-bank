package pl.put.miasi.bank.bankOperations.depositOperations;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankOperations.creditOperations.CreditInstallmentRepayment;
import pl.put.miasi.bank.bankOperations.creditOperations.CreditOperationUtil;
import pl.put.miasi.bank.bankOperations.creditOperations.CreditTaking;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import java.security.InvalidParameterException;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.junit.Assert.*;

/**
 * @author Bartosz Skotarek
 */
public class DepositOperationUtilTest extends EasyMockSupport {
    private BankAccount bankAccount;
    private InterestMechanism interestMechanism;
    private double amount;

    @Before
    public void before() throws InterestRateException, BalanceException {
        bankAccount = mock(BankAccount.class);
        interestMechanism = mock(InterestMechanism.class);
    }

    @Test
    public void depositAssumption() throws Exception {
        amount = 1000.0;

        bankAccount.updateBalance(eq(-amount));
        bankAccount.addBankOperation(isA(DepositAssumption.class));
        replayAll();

        DepositOperationUtil.depositAssumption("Zalozenie konta debetowego", bankAccount, interestMechanism, amount);
        verifyAll();
    }

    @Test
    public void depositAssumptionInsufficientResources() throws Exception {
        amount = -1000.0;

        replayAll();

        try {
            DepositOperationUtil.depositAssumption("Zalozenie konta debetowego", bankAccount, interestMechanism, amount);
            fail();
        } catch (InvalidParameterException e) {
            verifyAll();
        }
    }


    @Test
    public void depositBroke() throws Exception {
        amount = 1000.0;
        double interest = 100.0;

        bankAccount.updateBalance(eq(amount));
        bankAccount.addBankOperation(isA(DepositBroke.class));

        replayAll();

        Deposit deposit = new Deposit(amount);
        deposit.setInterestMechanism(interestMechanism);

        DepositOperationUtil.depositBroke("Zamkniecie konta debetowego", bankAccount, deposit);

        assertEquals(deposit.getBalance(), 0.0, 0.0);
        verifyAll();
    }

}