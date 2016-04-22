package pl.put.miasi.bank.bankProducts;

import static org.easymock.EasyMock.*;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.DebitMechanism;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Kamil Walkowiak
 */
public class BankAccountTest  extends EasyMockSupport {
//    private BankAccount bankAccount;
//
//    @Before
//    public void before() {
//        bankAccount = new BankAccount();
//    }
//
//    @Test
//    public void updateBalanceWithoutDebitTest() throws BalanceException {
//        bankAccount.updateBalance(10.0);
//        assertEquals(bankAccount.getBalance(), 10.0, 0.0);
//
//        bankAccount.updateBalance(-5.0);
//        assertEquals(bankAccount.getBalance(), 5.0, 0.0);
//    }
//
//    @Test(expected = BalanceException.class)
//    public void updateBalancWithoutDebitInsufficientBalanceTest() throws BalanceException {
//        bankAccount.updateBalance(-5.0);
//    }
//
//    @Test
//    public void updateBalanceWithDebitTest() throws BalanceException {
//        setupDebitMock();
//
//        bankAccount.updateBalance(-10.0);
//        assertEquals(bankAccount.getBalance(), -10.0, 0.0);
//        verifyAll();
//    }
//
//    @Test
//    public void updateBalanceWithDebitInsufficentBallanceTest() {
//        setupDebitMock();
//
//        try {
//            bankAccount.updateBalance(-100);
//            fail();
//        } catch(BalanceException e) {
//            verifyAll();
//        }
//    }
//
//    private void setupDebitMock() {
//        DebitMechanism debitMechanism = mock(DebitMechanism.class);
//        expect(debitMechanism.getMaxDebit()).andReturn(50.0);
//        replayAll();
//        bankAccount.setDebitMechanism(debitMechanism);
//    }
}
