package pl.put.miasi.bank.bankProducts;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

/**
 * @author Kamil Walkowiak
 */
public class CreditTest extends EasyMockSupport {
    private Credit credit;
    private InterestMechanism interestMechanism;
    private BankAccountDecorator bankAccountDecorator;
    private double amount;

    @Before
    public void before() {
        bankAccountDecorator = mock(BankAccount.class);

        amount = 100.0;
        credit = new Credit(amount, bankAccountDecorator);

        interestMechanism = mock(InterestMechanism.class);
        expect(interestMechanism.calculateInterest(eq(amount))).andReturn(amount*0.1);
        replayAll();

        credit.setInterestMechanism(interestMechanism);
    }

    @Test
    public void calculateInstallmentTest() {
        assertEquals(credit.calculateInstallment(), amount+amount*0.1, 0.0);
        verifyAll();
    }
}
