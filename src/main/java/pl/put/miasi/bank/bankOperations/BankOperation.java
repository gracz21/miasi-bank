package pl.put.miasi.bank.bankOperations;

import org.joda.time.DateTime;
import pl.put.miasi.bank.bankProducts.BankProduct;

import java.util.Comparator;
import java.util.Date;

/**
 * @author Bartosz Skotarek
 */
public abstract class BankOperation implements Comparable<BankOperation> {
    private static long idGlobal;

    protected long id;
    protected DateTime realisationDate;
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

    public DateTime getRealisationDate() {
        return realisationDate;
    }

    public String getDescription() {
        return description;
    }

    public String getOperationName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int compareTo(BankOperation o) {
        return this.realisationDate.compareTo(o.getRealisationDate());
    }
}
