package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * Operacje na rachunkach bankowych
 */
public abstract class BankAccountOperation extends BankOperation {
    protected double amount;

    protected BankAccountOperation(String description, BankProduct bankProduct, double amount) {
        super(description, bankProduct);
        this.amount = amount;
    }
}
