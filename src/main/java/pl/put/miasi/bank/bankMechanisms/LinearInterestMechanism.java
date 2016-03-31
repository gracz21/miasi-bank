package pl.put.miasi.bank.bankMechanisms;

/**
 * Mechanizm odestkowy
 */
public class LinearInterestMechanism extends InterestMechanism {
    public LinearInterestMechanism(double interestRate) {
        super(interestRate);
    }

    @Override
    public double calculateInterest(double value) {
        return value * interestRate;
    }
}
