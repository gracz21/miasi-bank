package pl.put.miasi.bank.bankMechanisms;

/**
 * Mechanizm odestkowy
 */
public abstract class InterestMechanism {
    protected  double interestRate;

    public InterestMechanism(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double calculateInterest(double value) {
        throw new UnsupportedOperationException();
    }
}
