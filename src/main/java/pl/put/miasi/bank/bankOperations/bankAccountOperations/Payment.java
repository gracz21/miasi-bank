package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import java.security.InvalidParameterException;

/**
 * Wplata
 */
public class Payment extends BankOperation {
    private BankAccount bankAccount;
    private double amount;
    private boolean executed;

    public Payment(String description, BankAccount bankAccount, double amount) {
        super(description);
        this.executed = false;
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    @Override
    public String getOperationName() {
        return "Payment";
    }

    @Override
    public void execute() throws BalanceException {
        if(this.amount < 0) {
            throw new InvalidParameterException("Amount is negative");
        }

        if(!this.executed) {
            bankAccount.updateBalance(this.amount);
            this.executed = true;
        } else {
            throw new UnsupportedOperationException("Operation already executed");
        }
    }
}
