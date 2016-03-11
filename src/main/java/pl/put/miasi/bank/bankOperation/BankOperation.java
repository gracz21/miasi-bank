package pl.put.miasi.bank.bankOperation;

/**
 * @author Bartosz Skotarek
 */
public abstract class BankOperation {
    protected String id;

    public BankOperation(String identyfikator) {
        this.id = identyfikator;
    }

    public String getIdentyfikator() {
        return id;
    }
}
