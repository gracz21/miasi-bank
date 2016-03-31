package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.History;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;

import java.util.UUID;

/**
 * @author Kamil Walkowiak
 */
public abstract class BankProduct {
    protected UUID id;
    protected History history = new History();
    protected InterestMechanism interestMechanism;
    protected double balance;

    public BankProduct(InterestMechanism interestMechanism) {
        this.id = UUID.randomUUID();
        this.interestMechanism = interestMechanism;
    }

    public String getUUID() {
        return id.toString();
    }

    public void addBankOperation(BankOperation bankOperation) {
        history.addBankOperation(bankOperation);
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double balance) {
        this.balance += balance;
    }

    public InterestMechanism getInterestMechanism() {
        return interestMechanism;
    }

    public void setInterestMechanism(InterestMechanism interestMechanism) {
        this.interestMechanism = interestMechanism;
    }
}
