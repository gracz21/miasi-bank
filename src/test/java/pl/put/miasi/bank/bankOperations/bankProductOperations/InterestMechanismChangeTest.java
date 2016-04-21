package pl.put.miasi.bank.bankOperations.bankProductOperations;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import static org.easymock.EasyMock.isA;
import static org.junit.Assert.*;

/**
 * @author Bartosz Skotarek
 */
public class InterestMechanismChangeTest extends EasyMockSupport {
    private BankProduct bankProduct;
    private InterestMechanism interestMechanism;

    @Before
    public void before() throws InterestRateException, BalanceException {
        bankProduct = mock(BankProduct.class);
        interestMechanism = mock(InterestMechanism.class);
    }

    @Test
    public void execute() throws Exception {
        bankProduct.setInterestMechanism(interestMechanism);
        //bankProduct.addBankOperation(isA(InterestMechanismChange.class));
        replayAll();

        InterestMechanismChange interestMechanismChange = new InterestMechanismChange("Test", interestMechanism, bankProduct);
        interestMechanismChange.execute();

        verifyAll();
    }



}