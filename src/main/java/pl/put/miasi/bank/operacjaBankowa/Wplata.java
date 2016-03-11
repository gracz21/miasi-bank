package pl.put.miasi.bank.operacjaBankowa;

import pl.put.miasi.bank.rachunekBankowy.RachunekBankowy;

/**
 * @author Bartosz Skotarek
 */
public class Wplata extends OperacjeBankoweRachunki {
    double kwota;

    public Wplata(RachunekBankowy rachunekBankowy, double kwota) {
        super("wplata", rachunekBankowy);
    }
}
