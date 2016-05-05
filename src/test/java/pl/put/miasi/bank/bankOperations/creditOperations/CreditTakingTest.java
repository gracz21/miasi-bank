package pl.put.miasi.bank.bankOperations.creditOperations;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;
import pl.put.miasi.bank.banks.Bank;

import java.security.InvalidParameterException;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.isA;
import static org.junit.Assert.fail;

/**
 * @author Bartosz Skotarek
 */
public class CreditTakingTest extends EasyMockSupport {
    private BankAccountDecorator bankAccountDecorator;
    private InterestMechanism interestMechanism;
    private Bank bank;

    @Before
    public void before() throws InterestRateException, BalanceException {
        bankAccountDecorator = mock(BankAccount.class);
        interestMechanism = mock(InterestMechanism.class);
        bank = mock(Bank.class);
    }

    @Test
    public void execute() throws Exception {
        double amount = 1000.0;

        bankAccountDecorator.payment(eq(amount));
        bank.addBankProduct(isA(Credit.class));

        replayAll();

        CreditTaking creditTaking = new CreditTaking("Test", amount, bankAccountDecorator, interestMechanism, bank);
        creditTaking.execute();

        verifyAll();
    }

    @Test
    public void executeInsufficientResources() throws Exception {
        double amount = -1000.0;

        replayAll();

        try {
            CreditTaking creditTaking = new CreditTaking("Test", amount, bankAccountDecorator, interestMechanism, bank);
            creditTaking.execute();

            fail();
        } catch (InvalidParameterException e) {
            verifyAll();
        }
    }
}