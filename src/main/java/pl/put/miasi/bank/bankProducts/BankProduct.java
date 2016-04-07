package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.History;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import java.util.UUID;

/**
 * @author Kamil Walkowiak
 */
public abstract class BankProduct {
    protected UUID id;
    protected History history = new History();
    protected InterestMechanism interestMechanism;
    protected double balance;

    public BankProduct() {
        this.id = UUID.randomUUID();
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
    public History getHistory() {
        return history;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void updateBalance(double amount) throws BalanceException {
        if(this.balance + amount >= 0) {
            this.balance += amount;
        } else {
            throw new BalanceException("Insufficient balance");
        }
    }

    public InterestMechanism getInterestMechanism() {
        return interestMechanism;
    }

    public void setInterestMechanism(InterestMechanism interestMechanism) {
        this.interestMechanism = interestMechanism;
    }
}
