package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.reports.Report;

/**
 * Lokata
 */
public class Deposit extends BankProduct {
    private boolean isActive;

    public Deposit(double balance) {
        super(balance);
        this.isActive = true;
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
}
