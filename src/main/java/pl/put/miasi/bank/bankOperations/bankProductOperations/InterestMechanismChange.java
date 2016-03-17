package pl.put.miasi.bank.bankOperations.bankProductOperations;

import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * Zmiana mechanizmu oblicania odsetek
 */
public class InterestMechanismChange extends BankProductOperation {
    protected InterestMechanismChange(String description, BankProduct bankProduct) {
        super(description, bankProduct);
    }
}
