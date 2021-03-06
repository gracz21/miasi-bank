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

    protected long id = idGlobal++;
    protected History history;
    protected InterestMechanism interestMechanism;
    protected double balance;

    public BankProduct(double balance) {
        this.balance = balance;
        this.history = new History();
    }

    public long getId() {
        return id;
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

    public InterestMechanism getInterestMechanism() {
        return interestMechanism;
    }

    public void setInterestMechanism(InterestMechanism interestMechanism) {
        this.interestMechanism = interestMechanism;
    }

    public void doOperation(BankOperation bankOperation) throws Exception {
        try {
            bankOperation.execute();
            this.history.addBankOperation(bankOperation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract BankProduct accept(Report report);
}
