package pl.put.miasi.bank.bankOperations.creditOperations;

import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.LinearInterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.Credit;

import javax.naming.InsufficientResourcesException;
import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

/**
 * Created by inf109764 on 2016-04-01.
 */
public class CreditOperationUtilTest {
    private BankAccount bankAccount;

    @Before
    public void before() throws InterestRateException {
        bankAccount = new BankAccount();
        bankAccount.setInterestMechanism(new LinearInterestMechanism(0.5));
        bankAccount.updateBalance(1000);
    }

    @Test(expected = InvalidParameterException.class)
    public void testTakeCreditInsufficientResources() throws Exception {
        CreditOperationUtil.takeCredit("Wziecie kredytu", bankAccount, new LinearInterestMechanism(0.1), -10000);
    }

    @Test
    public void testTakeCredit() throws Exception {
        LinearInterestMechanism interestMechanism = new LinearInterestMechanism(0.1);
        Credit credit = CreditOperationUtil.takeCredit("Wziecie kredytu", bankAccount, interestMechanism, 10000);

        assertEquals(credit.getBalance(), 10000, 0);
    }

    @Test
    public void testCreditInstallmentRepayment() throws Exception {

    }
}