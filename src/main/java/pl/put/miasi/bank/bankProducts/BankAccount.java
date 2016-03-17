package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankMechanisms.DebitMechanism;

import java.util.Date;

/**
 * @author Bartosz Skotarek
 */
public class BankAccount extends BankProduct {
    private Date dateOfCreation;
    private DebitMechanism debitMechanism;

    public BankAccount(DebitMechanism debitMechanism) {
        this.dateOfCreation = new Date();
        this.debitMechanism = debitMechanism;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }
}
