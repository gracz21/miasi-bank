package pl.put.miasi.bank.bankOperations.creditOperations;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

/**
 * @author Bartosz Skotarek
 */
public class CreditInstallmentRepaymentTest extends EasyMockSupport {
    private BankAccountDecorator bankAccountDecorator;
    private InterestMechanism interestMechanism;

    @Before
    public void before() throws InterestRateException, BalanceException {
        bankAccountDecorator = mock(BankAccount.class);
        interestMechanism = mock(InterestMechanism.class);
    }

    @Test
    public void execute() throws Exception {
        double amount = 1000.0;
        double interest = 100.0;

        bankAccountDecorator.withdraw(eq(amount + interest));
        expect(interestMechanism.calculateInterest(eq(amount))).andReturn(interest);

        replayAll();

        Credit credit = new Credit(amount, bankAccountDecorator);
        credit.setInterestMechanism(interestMechanism);

        CreditInstallmentRepayment creditInstallmentRepayment = new CreditInstallmentRepayment("Test", bankAccountDecorator, credit);
        creditInstallmentRepayment.execute();

        assertEquals(credit.getBalance(), 0.0, 0.0);
        verifyAll();
    }

}