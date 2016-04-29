package pl.put.miasi.bank.bankOperations.bankProductOperations;

import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.junit.Assert.*;

/**
 * @author Bartosz Skotarek
 */
public class InterestCalculationTest extends EasyMockSupport {
    private BankProduct bankProduct;
    private InterestMechanism interestMechanism;

    @Before
    public void before() throws InterestRateException, BalanceException {
        bankProduct = mock(BankProduct.class);
        interestMechanism = mock(InterestMechanism.class);
    }

    @Test
    public void execute() throws Exception {
        double balance = 1000.0;
        double interest = 100.0;

        expect(interestMechanism.calculateInterest(eq(balance))).andReturn(interest);

        expect(bankProduct.getInterestMechanism()).andReturn(interestMechanism);
        expect(bankProduct.getBalance()).andReturn(balance);

        replayAll();

        InterestCalculation interestCalculation = new InterestCalculation("Test", bankProduct);
        interestCalculation.execute();

        verifyAll();
    }

}