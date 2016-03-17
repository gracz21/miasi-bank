package pl.put.miasi.bank.bankOperations;

import pl.put.miasi.bank.bankProducts.BankAccount;

import java.util.Date;

/**
 * @author Bartosz Skotarek
 */
public abstract class BankOperation {
    protected String id;
    protected Date realisationDate;
    protected String description;

    protected BankOperation(String id, String description, BankAccount bankAccount, double amount) {
        this.id = id;
        this.description = description;
    }

    protected void realise() {
        throw new UnsupportedOperationException();
    }

    public String getId() {
        return id;
    }

    public Date getRealisationDate() {
        return realisationDate;
    }

    public String getDescription() {
        return description;
    }
}
