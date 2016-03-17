package pl.put.miasi.bank.bankOperations.bankProductOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * Operacja na produktach bankowych
 */
public abstract class BankProductOperation extends BankOperation {
    protected BankProductOperation(String description, BankProduct bankProduct) {
        super(description, bankProduct);
    }
}
