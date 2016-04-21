package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;

import java.security.InvalidParameterException;

/**
 * Przelew
 */
public class Transfer extends BankOperation {
    private BankAccount sourceBankAccount;
    private BankAccount targetBankAccount;
    private double amount;
    private boolean executed;

    public Transfer(String description, BankAccount sourceBankAccount, BankAccount targetBankAccount, double amount) {
        super(description);
        this.sourceBankAccount = sourceBankAccount;
        this.targetBankAccount = targetBankAccount;
        this.amount = amount;
        this.executed = false;
    }

    @Override
    public String getOperationName() {
        return "Transfer";
    }

    @Override
    public void execute() throws Exception {
        if(this.amount < 0) {
            throw new InvalidParameterException("Amount is negative");
        }

        if(!this.executed) {
            sourceBankAccount.updateBalance(-this.amount);
            targetBankAccount.updateBalance(this.amount);

            sourceBankAccount.addBankOperation(this);
            targetBankAccount.addBankOperation(this);

            this.executed = true;
        } else {
            throw new UnsupportedOperationException("Operation already executed");
        }
    }
}
