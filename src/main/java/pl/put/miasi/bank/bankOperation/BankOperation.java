package pl.put.miasi.bank.bankOperation;

import java.util.Date;

/**
 * @author Bartosz Skotarek
 */
public abstract class BankOperation {
    protected String id;
    protected Date realisationDate;
    protected String description;

    public BankOperation(String id, String description) {
        this.id = id;
        this.realisationDate = new Date();
        this.description = description;
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
