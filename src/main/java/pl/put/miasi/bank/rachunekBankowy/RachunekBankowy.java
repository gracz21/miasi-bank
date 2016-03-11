package pl.put.miasi.bank.rachunekBankowy;

import pl.put.miasi.bank.Debet;
import pl.put.miasi.bank.Historia;
import pl.put.miasi.bank.Odsetki;
import pl.put.miasi.bank.operacjaBankowa.OperacjeBankowe;
import pl.put.miasi.bank.operacjaBankowa.Przelew;
import pl.put.miasi.bank.operacjaBankowa.Wplata;

/**
 * @author Bartosz Skotarek
 */
public class RachunekBankowy {
    private Odsetki odsetki;
    private Debet debet;
    private Historia historia;

    public void wplata(double kwota) {
        Wplata wplata = new Wplata(this);
        wplata.wplac(kwota);

        historia.dodajOperacjeBankowa(wplata);
    }

    public void przelew(RachunekBankowy obcyRachunekBankowy, double kwota) {
        historia.dodajOperacjeBankowa(OperacjeBankowe.wplac(this, 500));
    }
}
