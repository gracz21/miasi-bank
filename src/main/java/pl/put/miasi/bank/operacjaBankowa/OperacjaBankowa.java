package pl.put.miasi.bank.operacjaBankowa;

import pl.put.miasi.bank.rachunekBankowy.RachunekBankowy;

/**
 * @author Bartosz Skotarek
 */
public abstract class OperacjaBankowa {
    protected String identyfikator;

    public OperacjaBankowa(String identyfikator) {
        this.identyfikator = identyfikator;
    }

    public String getIdentyfikator() {
        return identyfikator;
    }
}
