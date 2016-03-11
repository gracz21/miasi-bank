package pl.put.miasi.bank.operacjaBankowa;

import pl.put.miasi.bank.rachunekBankowy.RachunekBankowy;

/**
 * @author Bartosz Skotarek
 */
public class OperacjeBankowe {
    public static Wplata wplac(RachunekBankowy rachunekBankowy, double kwota) {
        return new Wplata(rachunekBankowy, kwota);
    }
}
