//package pl.put.miasi.bank.bankProducts;
//
//import org.junit.Before;
//import org.junit.Test;
//import pl.put.miasi.bank.bankProducts.exception.BalanceException;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * @author Kamil Walkowiak
// */
//public class BankProductTest {
//    private BankProduct bankProduct;
//
//    @Before
//    public void before() {
//        bankProduct = new Deposit(10.0);
//    }
//
//    @Test
//    public void updateBalanceTest() throws BalanceException {
//        bankProduct.updateBalance(10.0);
//        assertEquals(bankProduct.getBalance(), 20.0, 0.0);
//
//        bankProduct.updateBalance(-5.0);
//        assertEquals(bankProduct.getBalance(), 15.0, 0.0);
//    }
//
//    @Test(expected = BalanceException.class)
//    public void updateBalanceInsufficientBalanceTest() throws BalanceException {
//        bankProduct.updateBalance(-20.0);
//    }
//}
