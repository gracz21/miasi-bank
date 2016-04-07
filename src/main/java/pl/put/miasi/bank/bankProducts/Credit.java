package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;

/**
 * Kredyt
 */
public class Credit extends BankProduct {
    public Credit(double balance) {
        super(balance);
    }

    public double calculateInstallment() {
        return getBalance() + calculateInterest(getBalance());
    }
}
