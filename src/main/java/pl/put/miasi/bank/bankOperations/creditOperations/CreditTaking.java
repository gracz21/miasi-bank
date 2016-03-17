package pl.put.miasi.bank.bankOperations.creditOperations;

import pl.put.miasi.bank.bankProducts.Credit;

/**
 * Wziecie kredyty
 */
public class CreditTaking extends CreditOperation {
    protected CreditTaking(String description, Credit credit) {
        super(description, credit);
    }
}
