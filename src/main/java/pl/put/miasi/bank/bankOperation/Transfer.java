package pl.put.miasi.bank.bankOperation;

import pl.put.miasi.bank.bankProducts.BankAccount;

/**
 * @author Bartosz Skotarek
 */
public class Transfer extends BankOperation {
    private BankAccount obcyBankAccount;


    public Transfer(BankAccount bankAccount, BankAccount obcyBankAccount) {
        super("wplata", bankAccount);
        this.obcyBankAccount = obcyBankAccount;
    }

    public void przelej(double kwota) {

    }
}
