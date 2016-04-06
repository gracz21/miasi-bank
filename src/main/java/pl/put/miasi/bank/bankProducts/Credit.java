package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;

/**
 * Kredyt
 */
public class Credit extends BankProduct {
    public Credit(double balance) {
        super();
        this.balance = balance;
    }

    public double calculateInstallment() {
        return balance + interestMechanism.calculateInterest(this.balance);
    }
}
