package pl.put.miasi.bank.bankOperations.bankProductOperations;

import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * Obliczanie odsetek
 */
public class InterestCalculation extends BankProductOperation {
    protected InterestCalculation(String description, BankProduct bankProduct) {
        super(description, bankProduct);
    }
}
