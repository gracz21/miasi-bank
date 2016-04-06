package pl.put.miasi.bank.bankOperations.creditOperations;

import static org.easymock.EasyMock.*;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by inf109764 on 2016-04-01.
 */
public class CreditOperationUtilTest extends EasyMockSupport {
    private BankAccount bankAccount;
    private InterestMechanism interestMechanism;
    private double amount;

    @Before
    public void before() throws InterestRateException, BalanceException {
        bankAccount = mock(BankAccount.class);
        interestMechanism = mock(InterestMechanism.class);
    }

    @Test
    public void testTakeCreditInsufficientResources() throws Exception {
        amount = 1000.0;

        bankAccount.updateBalance(eq(amount));
        bankAccount.addBankOperation(isA(CreditTaking.class));
        replayAll();

        CreditOperationUtil.takeCredit("Wziecie kredytu", bankAccount, interestMechanism, amount);
        verifyAll();
    }

    @Test
    public void testTakeCredit() throws Exception {
        amount = -1000.0;

        replayAll();

        try {
            CreditOperationUtil.takeCredit("Wziecie kredytu", bankAccount, interestMechanism, 10000);
            fail();
        } catch(InvalidParameterException e) {
            verifyAll();
        }
    }

    @Test
    public void testCreditInstallmentRepayment() throws Exception {
        amount = 1000.0;
        double interest = 100.0;
        Credit credit = new Credit(amount);

        bankAccount.updateBalance(eq(-amount-interest));
        bankAccount.addBankOperation(isA(CreditInstallmentRepayment.class));

        expect(interestMechanism.calculateInterest(eq(amount))).andReturn(interest);

        replayAll();

        credit.setInterestMechanism(interestMechanism);

        CreditOperationUtil.creditInstallmentRepayment("Oplata raty", bankAccount, credit);
        assertEquals(credit.getBalance(), 0.0, 0.0);
        verifyAll();
    }
}