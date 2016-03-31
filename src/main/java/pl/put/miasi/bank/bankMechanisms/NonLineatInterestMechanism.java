package pl.put.miasi.bank.bankMechanisms;

import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;

/**
 * @author Kamil Walkowiak
 */
public class NonLineatInterestMechanism extends InterestMechanism {
    public NonLineatInterestMechanism(double interestRate) throws InterestRateException {
        super(interestRate);
    }

    //TODO Zapytac, o co c'mon?
}
