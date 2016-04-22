package pl.put.miasi.bank.bankOperations.bankAccountOperations;


import static org.easymock.EasyMock.*;
import static org.junit.Assert.fail;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import static org.junit.Assert.*;

/**
 * Created by inf109714 on 2016-04-15.
 */
public class WithdrawalTest extends EasyMockSupport {
    BankAccount bankAccount;
    Withdrawal withdrawal;
    double amount;

    @Before
    public void setup() {
        bankAccount = mock(BankAccount.class);
    }

    @Test
    public void testGetOperationName() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
//        amount = 400;
//        bankAccount.updateBalance(eq(-amount));
//        replayAll();
//
//        withdrawal = new Withdrawal("Test withdrawal", bankAccount, amount);
//        withdrawal.execute();
//        verifyAll();
    }

    @Test
    public void testPaymentAmountNegative() throws Exception {
//        amount = -400;
//        bankAccount.updateBalance(eq(amount));
//        replayAll();
//
//        withdrawal = new Withdrawal("Test withdrawal", bankAccount, amount);
//        try {
//            withdrawal.execute();
//            fail();
//        } catch (BalanceException e) {
//            verifyAll();
//        }
    }

    @Test
    public void testPaymentExecutedAgain() throws Exception {
//        amount = 400;
//        bankAccount.updateBalance(eq(amount));
//        replayAll();
//
//        withdrawal = new Withdrawal("Test withdrawal", bankAccount, amount);
//        withdrawal.execute();
//        try {
//            withdrawal.execute();
//            fail();
//        } catch (BalanceException e) {
//            verifyAll();
//        }
    }
}