package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankProducts.BankAccount;

/**
 * @author Bartosz Skotarek
 */
public class Payment extends BankAccountOperation {

    public Payment(String description, BankAccount bankAccount, double amount) {
        super("Payment", description, bankAccount, amount);
    }

    @Override
    public void realise() {
        this.bankAccount.updateBalance(this.amount);
    }
}
