package pl.put.miasi.bank.bankOperation;

import pl.put.miasi.bank.bankProducts.BankAccount;

/**
 * @author Bartosz Skotarek
 */
public abstract class BankOperationsAccounts extends BankOperation {
    protected BankAccount bankAccount;

    public BankOperationsAccounts(String identyfikator, BankAccount bankAccount) {
        super(identyfikator);
        this.bankAccount = bankAccount;
    }
}
