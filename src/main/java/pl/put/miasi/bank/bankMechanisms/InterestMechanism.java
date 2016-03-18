package pl.put.miasi.bank.bankMechanisms;

/**
 * Mechanizm odestkowy
 */
public abstract class InterestMechanism {
    protected boolean linear;
    protected  double interestRate;

    public InterestMechanism(double interestRate, boolean linear) {
        this.interestRate = interestRate;
        this.linear = linear;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public boolean isLinear() {
        return linear;
    }

    public double calculateBalance(double saldo) {
        throw new UnsupportedOperationException();
    }
}
