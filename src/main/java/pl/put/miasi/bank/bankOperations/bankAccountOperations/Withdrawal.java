package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * Wyplata
 */
public class Withdrawal extends BankAccountOperation {
    public Withdrawal(String description, BankAccount bankAccount, double amount) {
        super(description, bankAccount, amount);
    }

    @Override
    public String getOperationName() {
        return "Withdrawal";
    }
}
