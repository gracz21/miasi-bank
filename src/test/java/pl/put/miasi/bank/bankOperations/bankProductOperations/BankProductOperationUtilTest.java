package pl.put.miasi.bank.bankOperations.bankProductOperations;

import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.Client;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.LinearInterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import static org.junit.Assert.*;

public class BankProductOperationUtilTest {
    private BankProduct bankProduct;

    @Before
    public void before() throws InterestRateException, BalanceException {
        bankProduct = new BankAccount();
        bankProduct.setInterestMechanism(new LinearInterestMechanism(0.5));
        bankProduct.updateBalance(1000);
    }

    @Test
    public void testCalculateInterest() throws InterestRateException, BalanceException {
        BankProductOperationUtil.calculateInterest("Obliczenie odsetek", bankProduct);

        assertEquals(bankProduct.getBalance(), 1500, 0);
    }

    @Test
    public void testChangeInterestMechanism() throws Exception {
        InterestMechanism differentInterestMechanism = new LinearInterestMechanism(0.20);
        BankProductOperationUtil.changeInterestMechanism("Test", bankProduct, differentInterestMechanism);
        assertEquals(bankProduct.getInterestMechanism(), differentInterestMechanism);
    }

    @Test
    public void testcreaeteReport() throws Exception {
        // TODO zrobic
    }
}