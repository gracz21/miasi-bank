package pl.put.miasi.bank.bankProducts;

import static org.easymock.EasyMock.*;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.DebitMechanism;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDebitDecorator;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import static org.junit.Assert.*;

/**
 * Created by inf109714 on 2016-04-22.
 */
public class BankAccountDebitDecoratorTest extends EasyMockSupport {
    private BankAccountDebitDecorator bankAccountDebitDecorator;
    private BankAccount bankAccount;
    private DebitMechanism debitMechanism;

    @Before
    public void before() {
        bankAccount = mock(BankAccount.class);
        debitMechanism = mock(DebitMechanism.class);
        expect(debitMechanism.getMaxDebit()).andReturn(200.0);
    }

    @Test
    public void testWithdrawWithoutDebit() throws Exception {
        double amount = 100.0;

        expect(bankAccount.getBalance()).andReturn(amount);
        bankAccount.withdraw(eq(amount));

        replayAll();

        bankAccountDebitDecorator = new BankAccountDebitDecorator(debitMechanism, bankAccount);
        bankAccountDebitDecorator.withdraw(100.0);

        assertEquals(0.0, bankAccountDebitDecorator.getDebitValue(), 0.0);
        verifyAll();
    }

    @Test
    public void testWithdrawWithDebit() throws BalanceException {
        double amount = 200.0;

        expect(bankAccount.getBalance()).andReturn(100.0);
        bankAccount.withdraw(eq(100.0));

        replayAll();

        bankAccountDebitDecorator = new BankAccountDebitDecorator(debitMechanism, bankAccount);
        bankAccountDebitDecorator.withdraw(amount);

        assertEquals(100.0, bankAccountDebitDecorator.getDebitValue(), 0.0);
        verifyAll();
    }

    @Test
    public void testWithdrawWithNegativeAmount() throws BalanceException {
        double amount = -200.0;

        expect(bankAccount.getBalance()).andReturn(100.0);

        replayAll();

        bankAccountDebitDecorator = new BankAccountDebitDecorator(debitMechanism, bankAccount);

        try {
            bankAccountDebitDecorator.withdraw(amount);
            fail();
        } catch (BalanceException e) {
            verifyAll();
        }
    }

    @Test
    public void testWithdrawAboveDebit() throws BalanceException {
        double amount = 500.0;

        expect(bankAccount.getBalance()).andReturn(100.0);

        replayAll();

        bankAccountDebitDecorator = new BankAccountDebitDecorator(debitMechanism, bankAccount);

        try {
            bankAccountDebitDecorator.withdraw(amount);
            fail();
        } catch (BalanceException e) {
            verifyAll();
        }
    }

    @Test
    public void testPayment() throws Exception {
        double amount = 100;

        bankAccount.payment(eq(amount));

        replay(bankAccount);

        bankAccountDebitDecorator = new BankAccountDebitDecorator(debitMechanism, bankAccount);
        bankAccount.payment(amount);

        assertEquals(0.0, bankAccountDebitDecorator.getDebitValue(), 0.0);
        verify(bankAccount);
    }
}