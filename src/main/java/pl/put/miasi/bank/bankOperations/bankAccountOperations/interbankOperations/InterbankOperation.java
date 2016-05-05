package pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

/**
 * @author Kamil Walkowiak
 */
public abstract class InterbankOperation extends BankOperation {
    protected BankAccountDecorator executingBankAccount;
    protected double amount;

    protected InterbankOperation(String description) {
        super(description);
    }

    public void setExecutorObject(BankAccountDecorator executingBankAccount) {
        this.executingBankAccount = executingBankAccount;
    }

    public double getAmount() {
        return amount;
    }
}
