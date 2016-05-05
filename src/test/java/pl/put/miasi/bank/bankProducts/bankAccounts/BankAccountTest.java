package pl.put.miasi.bank.bankProducts.bankAccounts;

import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

/**
 * @author Kamil Walkowiak
 */
public class BankAccountTest {
    private BankAccount bankAccount;

    @Before
    public void before() {
        bankAccount = new BankAccount();
    }

    @Test
    public void testPayment() {
        double amount = 100.0;

        bankAccount.payment(amount);
        assertEquals(amount, bankAccount.getBalance(), 0.0);
    }

    @Test(expected = InvalidParameterException.class)
    public void testPaymentWithNegativeAmount() {
        double amount = -100.0;

        bankAccount.payment(amount);
    }

    @Test
    public void testWithdraw() throws BalanceException {
        double amount = 100.0;
        bankAccount.payment(200.0);

        bankAccount.withdraw(amount);
        assertEquals(100.0, bankAccount.getBalance(), 0.0);
    }

    @Test(expected = InvalidParameterException.class)
    public void testWithdrawWithNegativeAmount() throws BalanceException {
        double amount = -100.0;

        bankAccount.withdraw(amount);
    }

    @Test(expected = BalanceException.class)
    public void testWithdrawBelowBalance() throws BalanceException {
        double amount = 200.0;
        bankAccount.payment(100.0);

        bankAccount.withdraw(amount);
    }
}
