package pl.put.miasi.bank.bankOperation;

import pl.put.miasi.bank.bankProducts.BankAccount;

/**
 * @author Bartosz Skotarek
 */
public class BankOperations {
    public static Payment wplac(BankAccount bankAccount, double kwota) {
        return new Payment(bankAccount, kwota);
    }
}
