//package pl.put.miasi.bank.bankOperations.creditOperations;
//
//import org.easymock.EasyMockSupport;
//import org.junit.Before;
//import org.junit.Test;
//import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
//import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
//import pl.put.miasi.bank.bankProducts.BankAccount;
//import pl.put.miasi.bank.bankProducts.Credit;
//import pl.put.miasi.bank.bankProducts.exception.BalanceException;
//
//import static org.easymock.EasyMock.*;
//import static org.junit.Assert.*;
//
///**
// * @author Bartosz Skotarek
// */
//public class CreditInstallmentRepaymentTest extends EasyMockSupport {
//    private BankAccount bankAccount;
//    private InterestMechanism interestMechanism;
//
//    @Before
//    public void before() throws InterestRateException, BalanceException {
//        bankAccount = mock(BankAccount.class);
//        interestMechanism = mock(InterestMechanism.class);
//    }
//
//    @Test
//    public void execute() throws Exception {
//        double amount = 1000.0;
//        double interest = 100.0;
//        Credit credit = new Credit(amount);
//
//        bankAccount.updateBalance(eq(-amount - interest));
//        bankAccount.addBankOperation(isA(CreditInstallmentRepayment.class));
//
//        expect(interestMechanism.calculateInterest(eq(amount))).andReturn(interest);
//
//        replayAll();
//
//        credit.setInterestMechanism(interestMechanism);
//
//        CreditInstallmentRepayment creditInstallmentRepayment = new CreditInstallmentRepayment("Test", bankAccount, credit);
//        creditInstallmentRepayment.execute();
//
//        assertEquals(credit.getBalance(), 0.0, 0.0);
//        verifyAll();
//    }
//
//}