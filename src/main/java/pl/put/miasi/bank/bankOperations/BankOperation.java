package pl.put.miasi.bank.bankOperations;

import org.joda.time.DateTime;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import java.util.Comparator;
import java.util.Date;

/**
 * @author Bartosz Skotarek
 */
public abstract class BankOperation implements Comparable<BankOperation> {
    private static long idGlobal;

    private long id = idGlobal++;
    private DateTime realisationDate;
    private String description;

    protected BankOperation(String description) {
        this.description = description;
        this.realisationDate = new DateTime();
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

    public abstract String getOperationName();

    public abstract void execute() throws Exception;

    @Override
    public int compareTo(BankOperation o) {
        return this.realisationDate.compareTo(o.getRealisationDate());
    }
}
