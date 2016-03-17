package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.History;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;

/**
 * @author Kamil Walkowiak
 */
public abstract class BankProduct {
    protected String id;
    protected History history;
    protected InterestMechanism interestMechanism;
    protected double balance;

    public void addBankOperation(BankOperation bankOperation) {
        history.addBankOperation(bankOperation);
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double balance) {
        this.balance += balance;
    }
}
