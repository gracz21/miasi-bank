package pl.put.miasi.bank.bankMechanisms;

import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;

/**
 * Mechanizm odestkowy
 */
public class LinearInterestMechanism extends InterestMechanism {
    public LinearInterestMechanism(double interestRate) throws InterestRateException {
        super(interestRate);
    }

    @Override
    public double calculateInterest(double value) {
        return value * interestRate;
    }
}
