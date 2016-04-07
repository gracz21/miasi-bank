package pl.put.miasi.bank.bankMechanisms;

import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;

import static org.junit.Assert.assertEquals;

/**
 * @author Kamil Walkowiak
 */
public class LinearInterestMechanismTest {
    private LinearInterestMechanism linearInterestMechanism;

    @Before
    public void before() throws InterestRateException {
        linearInterestMechanism = new LinearInterestMechanism(0.1);
    }

    @Test
    public void calculateInterestTest() {
        double interest = linearInterestMechanism.calculateInterest(100.0);
        assertEquals(interest, 10.0, 0.0);
    }
}
