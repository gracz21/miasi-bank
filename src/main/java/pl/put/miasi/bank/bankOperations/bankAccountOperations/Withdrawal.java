package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;

import java.security.InvalidParameterException;

/**
 * Wyplata
 */
public class Withdrawal extends BankOperation {
    private BankAccount bankAccount;
    private double amount;
    private boolean executed;

    public Withdrawal(String description, BankAccount bankAccount, double amount) {
        super(description);
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.executed = false;
    }

    @Override
    public String getOperationName() {
        return "Withdrawal";
    }

    @Override
    public void execute() throws Exception {
//        if(this.amount < 0) {
//            throw new InvalidParameterException("Amount is negative");
//        }
//
//        if(!this.executed) {
//            bankAccount.updateBalance(-this.amount);
//            bankAccount.addBankOperation(this);
//            this.executed = true;
//        } else {
//            throw new UnsupportedOperationException("Operation already executed");
//        }
    }
}
