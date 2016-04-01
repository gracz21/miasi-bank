package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;

/**
 * Lokata
 */
public class Deposit extends BankProduct {
    public Deposit(double balance) {
        super();
        this.balance = balance;
    }

    public void brokeDeposit() {
        this.balance = 0.0;
    }
}
