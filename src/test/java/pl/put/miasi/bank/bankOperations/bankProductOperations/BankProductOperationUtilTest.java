package pl.put.miasi.bank.bankOperations.bankProductOperations;

import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.LinearInterestMechanism;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;

import static org.junit.Assert.*;

public class BankProductOperationUtilTest {
    BankProduct bankProduct;

    @Before
    public void before() {
        bankProduct = new BankAccount(new LinearInterestMechanism(15, true)));
    }

    @Test
    public void testInterestCalculation() throws Exception {

    }

    @Test
    public void testInterestMechanismChange() throws Exception {
        InterestMechanism differentInterestMechanism = new InterestMechanism();
        BankProductOperationUtil.InterestMechanismChange("Test", bankProduct, differentInterestMechanism);
        assertEquals(bankProduct.getInterestMechanism(), differentInterestMechanism);
    }

    @Test
    public void testReportCreation() throws Exception {

    }
}