package pl.put.miasi.bank.operacjaBankowa;

import pl.put.miasi.bank.rachunekBankowy.RachunekBankowy;

/**
 * @author Bartosz Skotarek
 */
public abstract class OperacjeBankoweRachunki extends OperacjaBankowa {
    protected RachunekBankowy rachunekBankowy;

    public OperacjeBankoweRachunki(String identyfikator, RachunekBankowy rachunekBankowy) {
        super(identyfikator);
        this.rachunekBankowy = rachunekBankowy;
    }
}
