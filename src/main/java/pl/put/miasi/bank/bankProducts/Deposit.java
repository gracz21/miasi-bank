package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;
import pl.put.miasi.bank.reports.Report;

/**
 * Lokata
 */
public class Deposit extends BankProduct {
    private boolean isActive;
    private BankAccountDecorator bankAccountDecorator;

    public Deposit(double balance, BankAccountDecorator bankAccountDecorator) {
        super(balance);
        this.isActive = true;
        this.bankAccountDecorator = bankAccountDecorator;
    }

    public BankAccountDecorator getBankAccountDecorator() {
        return bankAccountDecorator;
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
