package pl.put.miasi.bank.bankOperations.bankProductOperations;

import static org.easymock.EasyMock.*;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

public class BankProductOperationUtilTest extends EasyMockSupport {
    private BankProduct bankProduct;
    private InterestMechanism interestMechanism;

    @Before
    public void before() throws InterestRateException, BalanceException {
        bankProduct = mock(BankProduct.class);
        interestMechanism = mock(InterestMechanism.class);
    }

    @Test
    public void testCalculateInterest() throws InterestRateException, BalanceException {
        double balance = 1000.0;
        double interest = 100.0;

        expect(interestMechanism.calculateInterest(eq(balance))).andReturn(interest);

        expect(bankProduct.getInterestMechanism()).andReturn(interestMechanism);
        expect(bankProduct.getBalance()).andReturn(balance);
        bankProduct.updateBalance(eq(interest));
        bankProduct.addBankOperation(isA(InterestCalculation.class));

        replayAll();

        BankProductOperationUtil.calculateInterest("Obliczenie odsetek", bankProduct);
        verifyAll();
    }

    @Test
    public void testChangeInterestMechanism() throws Exception {
        bankProduct.setInterestMechanism(interestMechanism);
        bankProduct.addBankOperation(isA(InterestMechanismChange.class));
        replayAll();

        BankProductOperationUtil.changeInterestMechanism("Test", bankProduct, interestMechanism);
        verifyAll();
    }

    @Test
    public void testcreaeteReport() throws Exception {
        // TODO zrobic
    }
}