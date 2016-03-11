package pl.put.miasi.bank.operacjaBankowa;

import pl.put.miasi.bank.rachunekBankowy.RachunekBankowy;

/**
 * @author Bartosz Skotarek
 */
public class Przelew extends OperacjaBankowa {
    private RachunekBankowy obcyRachunekBankowy;

    public Przelew(RachunekBankowy rachunekBankowy, RachunekBankowy obcyRachunekBankowy) {
        super("wplata", rachunekBankowy);
        this.obcyRachunekBankowy = obcyRachunekBankowy;
    }

    public void przelej(double kwota) {

    }
}
