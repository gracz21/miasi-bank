package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.reports.Report;

/**
 * Kredyt
 */
public class Credit extends BankProduct {
    boolean isActive;

    public Credit(double balance) {
        super(balance);
        isActive = true;
    }

    public boolean isActive() {
        return isActive;
    }

    public void deactivate() {
        isActive = false;
    }

    @Override
    public BankProduct accept(Report report) {
        return null;
    }

    public double calculateInstallment() {
        return getBalance() + calculateInterest(getBalance());
    }
}
