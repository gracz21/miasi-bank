package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankAccount;

/**
 * @author Bartosz Skotarek
 */
public abstract class BankAccountOperation extends BankOperation {
    protected BankAccount bankAccount;
    protected double amount;

    protected BankAccountOperation(String id, String description, BankAccount bankAccount, double amount) {
        super(id, description, bankAccount, amount);
        this.bankAccount = bankAccount;
        this.amount = amount;
    }
}
