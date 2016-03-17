package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * Wplata
 */
public class Payment extends BankAccountOperation {

    public Payment(String description, BankProduct bankProduct, double amount) {
        super(description, bankProduct, amount);
    }

    @Override
    public String getOperationName() {
        return "Payment";
    }
}
