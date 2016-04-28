//package pl.put.miasi.bank.bankOperations.bankAccountOperations;
//
//import static org.easymock.EasyMock.*;
//import static org.junit.Assert.fail;
//
//import org.easymock.EasyMockSupport;
//import org.junit.Before;
//import org.junit.Test;
//import pl.put.miasi.bank.bankProducts.BankAccount;
//import pl.put.miasi.bank.bankProducts.exception.BalanceException;
//
//import static org.junit.Assert.*;
//
///**
// * Created by inf109714 on 2016-04-15.
// */
//public class TransferTest extends EasyMockSupport {
//    BankAccount sourceBankAccount;
//    BankAccount targetBankAccount;
//    Transfer transfer;
//    double amount;
//
//    @Before
//    public void setup() {
//        sourceBankAccount = mock(BankAccount.class);
//        targetBankAccount = mock(BankAccount.class);
//    }
//
//    @Test
//    public void testGetOperationName() throws Exception {
//
//    }
//
//    @Test
//    public void testExecute() throws Exception {
////        amount = 400;
////        sourceBankAccount.updateBalance(eq(-amount));
////        targetBankAccount.updateBalance(eq(amount));
////        replayAll();
////
////        transfer = new Transfer("Test transfer", sourceBankAccount, targetBankAccount, amount);
////        transfer.execute();
////
////        verifyAll();
//    }
//
//    @Test
//    public void testPaymentAmountNegative() throws Exception {
//        amount = -400;
//        replayAll();
//
//        transfer = new Transfer("Test transfer", sourceBankAccount, targetBankAccount, amount);
//        try {
//            transfer.execute();
//            fail();
//        } catch (BalanceException e) {
//            verifyAll();
//        }
//    }
//
//    @Test
//    public void testPaymentExecutedAgain() throws Exception {
////        amount = 400;
////        sourceBankAccount.updateBalance(eq(-amount));
////        targetBankAccount.updateBalance(eq(amount));
////        replayAll();
////
////        transfer = new Transfer("Test transfer", sourceBankAccount, targetBankAccount, amount);
////        transfer.execute();
////        try {
////            transfer.execute();
////            fail();
////        } catch (BalanceException e) {
////            verifyAll();
////        }
//    }
//}