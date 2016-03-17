package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankProducts.BankAccount;

import java.util.Date;

/**
 * @author Bartosz Skotarek
 */
public class Payment extends BankAccountOperation {

    public Payment(String description, BankAccount bankAccount, double amount) {
        super("Payment", description, bankAccount, amount);
        this.realise();
    }

    @Override
    protected void realise() {
        this.bankAccount.updateBalance(this.amount);
        this.realisationDate = new Date();
    }
}
