package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.History;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.reports.Report;

/**
 * @author Kamil Walkowiak
 */
public abstract class BankProduct {
    private static long idGlobal;

    private long id = idGlobal++;
    private History history = new History();
    private InterestMechanism interestMechanism;
    protected double balance;

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

    public double calculateInterest(double amount) {
        return interestMechanism.calculateInterest(amount);
    }

    public InterestMechanism getInterestMechanism() {
        return interestMechanism;
    }

    public void setInterestMechanism(InterestMechanism interestMechanism) {
        this.interestMechanism = interestMechanism;
    }

    public void doOperation(BankOperation bankOperation) throws Exception {
        bankOperation.execute();
        this.history.addBankOperation(bankOperation);
    }

    public abstract BankProduct accept(Report report);
}
