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

    protected long id = idGlobal++;
    protected DateTime realisationDate;
    protected String description;
    protected boolean executed;

    protected BankOperation(String description) {
        this.description = description;
        this.realisationDate = new DateTime();
        this.executed = false;
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

    public void execute() throws Exception {
        if(!executed) {
            executed = true;
        } else {
            throw new UnsupportedOperationException("Operation already executed");
        }
    }

    @Override
    public int compareTo(BankOperation o) {
        return this.realisationDate.compareTo(o.getRealisationDate());
    }
}
