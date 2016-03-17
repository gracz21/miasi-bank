package pl.put.miasi.bank.bankOperations;

import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;

import java.util.Date;

/**
 * @author Bartosz Skotarek
 */
public abstract class BankOperation {
    protected int id;
    protected Date realisationDate;
    protected String description;
    protected BankProduct bankProduct;

    private static int globalId;

    protected BankOperation(String description, BankProduct bankProduct) {
        this.id = globalId++;
        this.realisationDate = new Date();
        this.description = description;
        this.bankProduct = bankProduct;
    }

    public int getId() {
        return id;
    }

    public Date getRealisationDate() {
        return realisationDate;
    }

    public String getDescription() {
        return description;
    }
}
