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
    private static long idGlobal;

    private long id = idGlobal++;
    private History history = new History();
    private InterestMechanism interestMechanism;
    private double balance;

    public BankProduct(double balance) {
        this.balance = balance;
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

    public double calculateInterest(double amount) {
        return interestMechanism.calculateInterest(amount);
    }

    public InterestMechanism getInterestMechanism() {
        return interestMechanism;
    }

    public void setInterestMechanism(InterestMechanism interestMechanism) {
        this.interestMechanism = interestMechanism;
    }
}
