package pl.put.miasi.bank.bankOperations.creditOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Credit;

/**
 * Operacje na kredytach
 */
public abstract class CreditOperation extends BankOperation {
    protected CreditOperation(String description, Credit credit) {
        super(description, credit);
    }
}
