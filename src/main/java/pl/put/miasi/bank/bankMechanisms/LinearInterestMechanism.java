package pl.put.miasi.bank.bankMechanisms;

/**
 * Mechanizm odestkowy
 */
public class LinearInterestMechanism extends InterestMechanism {
    public LinearInterestMechanism(double interestRate, boolean linear) {
        super(interestRate, linear);
    }

    public double calculateBalance(double balance) {
        return balance * interestRate;
    }
}
