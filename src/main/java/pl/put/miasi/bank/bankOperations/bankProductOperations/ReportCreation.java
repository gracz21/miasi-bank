package pl.put.miasi.bank.bankOperations.bankProductOperations;

import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * Tworzenie raportu
 */
public class ReportCreation extends BankProductOperation {
    protected ReportCreation(String description, BankProduct bankProduct) {
        super(description, bankProduct);
    }
}
