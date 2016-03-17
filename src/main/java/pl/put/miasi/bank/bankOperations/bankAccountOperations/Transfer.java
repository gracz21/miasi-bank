package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * @author Bartosz Skotarek
 */
public class Transfer extends BankAccountOperation {
    private BankProduct targetBankProduct;

    public Transfer(String description, BankProduct bankProduct, BankProduct targetBankProduct, double amount) {
        super(description, bankProduct, amount);
        this.targetBankProduct = targetBankProduct;
    }

    @Override
    public String toString() {
        return "Transfer";
    }
}
