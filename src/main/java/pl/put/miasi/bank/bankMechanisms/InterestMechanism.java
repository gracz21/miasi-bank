package pl.put.miasi.bank.bankMechanisms;

import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;

/**
 * Mechanizm odestkowy
 */
public abstract class InterestMechanism {
    protected  double interestRate;

    public InterestMechanism(double interestRate) throws InterestRateException {
        if(interestRate <= 1.0) {
            this.interestRate = interestRate;
        } else {
            throw new InterestRateException("Interest rate cannot be higher than 1.0");
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double calculateInterest(double value) {
        throw new UnsupportedOperationException();
    }
}
