package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankProducts.BankAccount;

/**
 * @author Bartosz Skotarek
 */
public class Transfer extends BankAccountOperation {
    private BankAccount sourceAccount;


    public Transfer(BankAccount bankAccount, BankAccount sourceAccount, String description, double amount) {
        super("Transfer", description, bankAccount, amount);
        this.sourceAccount = sourceAccount;
    }

    @Override
    public void realise() {
        this.bankAccount.updateBalance(this.amount);
        this.sourceAccount.updateBalance(this.amount*(-1));
    }
}
