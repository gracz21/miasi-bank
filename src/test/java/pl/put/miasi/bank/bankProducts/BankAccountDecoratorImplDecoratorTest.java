package pl.put.miasi.bank.bankProducts;

import static org.easymock.EasyMock.*;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.DebitMechanism;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecoratorDebit;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import static org.junit.Assert.*;

/**
 * Created by inf109714 on 2016-04-22.
 */
public class BankAccountDecoratorImplDecoratorTest extends EasyMockSupport {
    private BankAccountDecoratorDebit bankAccountDecoratorDebit;
    private BankAccount bankAccountImpl;
    private DebitMechanism debitMechanism;

    @Before
    public void before() {
        bankAccountImpl = mock(BankAccount.class);
        debitMechanism = mock(DebitMechanism.class);
        expect(debitMechanism.getMaxDebit()).andReturn(200.0);
    }

    @Test
    public void testWithdrawWithoutDebit() throws Exception {
        double amount = 100.0;

        expect(bankAccountImpl.getBalance()).andReturn(amount);
        bankAccountImpl.withdraw(eq(amount));

        replayAll();

        bankAccountDecoratorDebit = new BankAccountDecoratorDebit(debitMechanism, bankAccountImpl);
        bankAccountDecoratorDebit.withdraw(100.0);

        assertEquals(0.0, bankAccountDecoratorDebit.getDebitValue(), 0.0);
        verifyAll();
    }

    @Test
    public void testWithdrawWithDebit() throws BalanceException {
        double amount = 200.0;

        expect(bankAccountImpl.getBalance()).andReturn(100.0);
        bankAccountImpl.withdraw(eq(100.0));

        replayAll();

        bankAccountDecoratorDebit = new BankAccountDecoratorDebit(debitMechanism, bankAccountImpl);
        bankAccountDecoratorDebit.withdraw(amount);

        assertEquals(100.0, bankAccountDecoratorDebit.getDebitValue(), 0.0);
        verifyAll();
    }

    @Test
    public void testWithdrawWithNegativeAmount() throws BalanceException {
        double amount = -200.0;

        expect(bankAccountImpl.getBalance()).andReturn(100.0);

        replayAll();

        bankAccountDecoratorDebit = new BankAccountDecoratorDebit(debitMechanism, bankAccountImpl);

        try {
            bankAccountDecoratorDebit.withdraw(amount);
            fail();
        } catch (BalanceException e) {
            verifyAll();
        }
    }

    @Test
    public void testWithdrawAboveDebit() throws BalanceException {
        double amount = 500.0;

        expect(bankAccountImpl.getBalance()).andReturn(100.0);

        replayAll();

        bankAccountDecoratorDebit = new BankAccountDecoratorDebit(debitMechanism, bankAccountImpl);

        try {
            bankAccountDecoratorDebit.withdraw(amount);
            fail();
        } catch (BalanceException e) {
            verifyAll();
        }
    }

    @Test
    public void testPayment() throws Exception {
        double amount = 100;

        bankAccountImpl.payment(eq(amount));

        replay(bankAccountImpl);

        bankAccountDecoratorDebit = new BankAccountDecoratorDebit(debitMechanism, bankAccountImpl);
        bankAccountImpl.payment(amount);

        assertEquals(0.0, bankAccountDecoratorDebit.getDebitValue(), 0.0);
        verify(bankAccountImpl);
    }
}