package pl.put.miasi.bank.operacjaBankowa;

import pl.put.miasi.bank.rachunekBankowy.RachunekBankowy;

/**
 * @author Bartosz Skotarek
 */
public abstract class OperacjaBankowa {
    protected String identyfikator;
    protected RachunekBankowy rachunekBankowy;

    public OperacjaBankowa(String identyfikator, RachunekBankowy rachunekBankowy) {
        this.identyfikator = identyfikator;
        this.rachunekBankowy = rachunekBankowy;
    }

    public String getIdentyfikator() {
        return identyfikator;
    }
}
