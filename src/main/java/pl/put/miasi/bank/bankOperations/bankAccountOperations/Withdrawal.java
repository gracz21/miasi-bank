package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankProducts.BankAccount;

/**
 * @author Bartosz Skotarek
 */
public class Withdrawal extends BankAccountOperation {
    public Withdrawal(String description, BankAccount bankAccount, double amount) {
        super("Withdrawal", description, bankAccount, amount);
    }

    @Override
    public void realise() {
        this.bankAccount.updateBalance(this.amount*(-1));
    }
}
