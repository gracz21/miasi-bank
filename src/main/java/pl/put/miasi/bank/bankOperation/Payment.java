package pl.put.miasi.bank.bankOperation;

import pl.put.miasi.bank.bankProducts.BankAccount;

/**
 * @author Bartosz Skotarek
 */
public class Payment extends BankOperationsAccounts {
    double kwota;

    public Payment(BankAccount bankAccount, double kwota) {
        super("wplata", bankAccount);
    }
}
