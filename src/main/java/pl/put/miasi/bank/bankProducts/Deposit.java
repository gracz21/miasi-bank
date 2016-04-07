package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;

/**
 * Lokata
 */
public class Deposit extends BankProduct {
    public Deposit(double balance) {
        super(balance);
    }

    public void brokeDeposit() {
        setBalance(0);
    }
}
