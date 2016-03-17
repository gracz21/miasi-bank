package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * Przelew
 */
public class Transfer extends BankAccountOperation {
    private BankProduct targetBankProduct;

    public Transfer(String description, BankAccount bankAccount, BankAccount targetBankProduct, double amount) {
        super(description, bankAccount, amount);
        this.targetBankProduct = targetBankProduct;
    }

    @Override
    public String getOperationName() {
        return "Transfer";
    }
}
