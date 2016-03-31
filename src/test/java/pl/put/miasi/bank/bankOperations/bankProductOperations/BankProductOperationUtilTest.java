package pl.put.miasi.bank.bankOperations.bankProductOperations;

import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.Client;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.LinearInterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;

import static org.junit.Assert.*;

public class BankProductOperationUtilTest {
    private BankProduct bankProduct;

    @Before
    public void before() {
        try {
            bankProduct = new BankAccount(new LinearInterestMechanism(0.15), new Client("Test", "Test", "12345678901"));
        } catch(InterestRateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInterestCalculation() throws Exception {

    }

    @Test
    public void testInterestMechanismChange() throws Exception {
        InterestMechanism differentInterestMechanism = new LinearInterestMechanism(0.20);
        BankProductOperationUtil.InterestMechanismChange("Test", bankProduct, differentInterestMechanism);
        assertEquals(bankProduct.getInterestMechanism(), differentInterestMechanism);
    }

    @Test
    public void testReportCreation() throws Exception {

    }
}