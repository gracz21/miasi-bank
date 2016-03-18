package pl.put.miasi.bank.bankOperations.bankProductOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * Zmiana mechanizmu oblicania odsetek
 */
public class InterestMechanismChange extends BankProductOperation {
    private InterestMechanism interestMechanism;

    protected InterestMechanismChange(String description, InterestMechanism interestMechanism, BankProduct bankProduct) {
        super(description, bankProduct);
        this.interestMechanism = interestMechanism;
    }
}
