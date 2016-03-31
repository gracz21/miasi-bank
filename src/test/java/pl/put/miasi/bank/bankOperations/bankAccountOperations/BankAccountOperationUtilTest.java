package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.Client;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.LinearInterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankOperations.exception.BalanceException;
import pl.put.miasi.bank.bankProducts.BankAccount;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

/**
 * @author Bartosz Skotarek
 */
public class BankAccountOperationUtilTest {
    private BankAccount sourceBankAccount;
    private BankAccount targetBankAccount;

    @Before
    public void before() {
        try {
            sourceBankAccount = new BankAccount(new LinearInterestMechanism(0.2), new Client("Test", "Test", "12345678901"));
            targetBankAccount = new BankAccount(new LinearInterestMechanism(0.2), new Client("Test", "Test", "12345678901"));
        } catch(InterestRateException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testPayment() throws Exception {
        BankAccountOperationUtil.payment(targetBankAccount, "Test", 450.0);
        assertEquals(targetBankAccount.getBalance(), 450.0, 0);
    }

    @Test(expected = InvalidParameterException.class)
    public void testPaymentAmountNegative() {
        BankAccountOperationUtil.payment(targetBankAccount, "Test", -10.0);
    }

    @Test
    public void testWithdraw() throws BalanceException {
        BankAccountOperationUtil.payment(targetBankAccount, "Test", 300.0);
        BankAccountOperationUtil.withdraw(targetBankAccount, "Test", 100.0);
        assertEquals(targetBankAccount.getBalance(), 200.0, 0);
    }

    @Test(expected = InvalidParameterException.class)
    public void testWithdrawAmountNegative() throws BalanceException {
        BankAccountOperationUtil.withdraw(targetBankAccount, "Test", -100.0);
    }

    @Test(expected = BalanceException.class)
    public void testWithdrawBalanceException() throws BalanceException {
        BankAccountOperationUtil.withdraw(targetBankAccount, "Test", 100.0);
    }

    @Test
    public void testTransfer() throws BalanceException {
        BankAccountOperationUtil.payment(sourceBankAccount, "Test", 150.0);
        BankAccountOperationUtil.transfer(sourceBankAccount, targetBankAccount, "Test", 50.0);
        assertEquals(sourceBankAccount.getBalance(), 100.0, 0);
        assertEquals(targetBankAccount.getBalance(), 50.0, 0);
    }

    @Test(expected = InvalidParameterException.class)
    public void testTransferAmountNegative() throws BalanceException {
        BankAccountOperationUtil.transfer(sourceBankAccount, targetBankAccount, "Test", -100.0);
    }

    @Test(expected = BalanceException.class)
    public void testTransferBalanceException() throws BalanceException {
        BankAccountOperationUtil.transfer(sourceBankAccount, targetBankAccount, "Test", 100.0);
    }
}