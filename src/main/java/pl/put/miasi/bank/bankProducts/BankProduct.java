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
    protected History history = new History();
    protected InterestMechanism interestMechanism;
    protected double balance;

    public BankProduct(double balance) {
        this.balance = balance;
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
        bankOperation.execute();
        this.history.addBankOperation(bankOperation);
    }

    public abstract BankProduct accept(Report report);
}
