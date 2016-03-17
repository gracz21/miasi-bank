package pl.put.miasi.bank.bankOperations;

import pl.put.miasi.bank.bankProducts.BankProduct;

import java.util.Date;

/**
 * @author Bartosz Skotarek
 */
public abstract class BankOperation {
    private static long idGlobal;
    protected long id;
    protected Date realisationDate;
    protected String description;
    protected BankProduct bankProduct;

    protected BankOperation(String description, BankProduct bankProduct) {
        this.id = idGlobal++;
        this.description = description;
        this.bankProduct = bankProduct;
    }

    public long getId() {
        return id;
    }

    public Date getRealisationDate() {
        return realisationDate;
    }

    public String getDescription() {
        return description;
    }

    public String getOperationName() {
        throw new UnsupportedOperationException();
    }
}
