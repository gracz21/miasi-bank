package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import static org.easymock.EasyMock.*;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;
import pl.put.miasi.bank.bankProducts.BankAccount;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

/**
 * @author Bartosz Skotarek
 */
public class BankAccountOperationUtilTest extends EasyMockSupport {
    private BankAccount sourceBankAccount;
    private BankAccount targetBankAccount;
    private double amount;

    @Before
    public void before() throws InterestRateException {
        sourceBankAccount = mock(BankAccount.class);
        targetBankAccount = mock(BankAccount.class);
    }

    @Test
    public void testPayment() throws Exception {
        amount = 450;

        targetBankAccount.updateBalance(eq(amount));
        targetBankAccount.addBankOperation(isA(Payment.class));
        replayAll();

        BankAccountOperationUtil.payment(targetBankAccount, "Test", amount);
        verifyAll();
    }

    @Test
    public void testPaymentAmountNegative() throws BalanceException {
        amount = -10.0;

        replayAll();

        try {
            BankAccountOperationUtil.payment(targetBankAccount, "Test", -10.0);
            fail();
        } catch(InvalidParameterException e) {
            verifyAll();
        }
    }

    @Test
    public void testWithdraw() throws BalanceException {
        amount = 100;

        targetBankAccount.updateBalance(eq(-amount));
        targetBankAccount.addBankOperation(isA(Withdrawal.class));
        replayAll();

        BankAccountOperationUtil.withdraw(targetBankAccount, "Test", 100.0);
        verifyAll();
    }

    @Test
    public void testWithdrawAmountNegative() throws BalanceException {
        amount = -100.0;

        replayAll();

        try {
            BankAccountOperationUtil.withdraw(targetBankAccount, "Test", amount);
            fail();
        } catch(InvalidParameterException e) {
            verifyAll();
        }
    }

    @Test
    public void testTransfer() throws BalanceException {
        amount = 50.0;

        sourceBankAccount.updateBalance(eq(-amount));
        sourceBankAccount.addBankOperation(isA(Transfer.class));

        targetBankAccount.updateBalance(eq(amount));
        targetBankAccount.addBankOperation(isA(Transfer.class));

        replayAll();

        BankAccountOperationUtil.transfer(sourceBankAccount, targetBankAccount, "Test", 50.0);
        verifyAll();
    }

    @Test
    public void testTransferAmountNegative() throws BalanceException {
        amount = -100.0;

        replayAll();
        try {
            BankAccountOperationUtil.transfer(sourceBankAccount, targetBankAccount, "Test", amount);
            fail();
        } catch(InvalidParameterException e) {
            verifyAll();
        }

    }
}