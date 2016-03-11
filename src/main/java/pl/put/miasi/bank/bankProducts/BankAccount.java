package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.Debit;
import pl.put.miasi.bank.History;
import pl.put.miasi.bank.Interest;
import pl.put.miasi.bank.bankOperation.BankOperations;
import pl.put.miasi.bank.bankOperation.Payment;

/**
 * @author Bartosz Skotarek
 */
public class BankAccount {
    private Interest interest;
    private Debit debit;
    private History history;

    public void wplata(double kwota) {
        Payment payment = new Payment(this, kwota);
        payment.wplac(kwota);

        history.dodajOperacjeBankowa(payment);
    }

    public void przelew(BankAccount obcyBankAccount, double kwota) {
        history.dodajOperacjeBankowa(BankOperations.wplac(this, 500));
    }
}
