package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankMechanisms.DebitMechanism;

import java.util.Date;

/**
 * @author Bartosz Skotarek
 */
public class BankAccount extends BankProduct {
    private Date dateOfCreation;
    private double balance;
    private DebitMechanism debitMechanism;

    public BankAccount(DebitMechanism debitMechanism) {
        this.dateOfCreation = new Date();
        this.balance = 0.0;
        this.debitMechanism = debitMechanism;
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public double getBalance() {
        return balance;
    }
}
