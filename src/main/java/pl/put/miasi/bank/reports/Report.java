package pl.put.miasi.bank.reports;

import pl.put.miasi.bank.bankProducts.BankProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bartosz Skotarek
 */
public abstract class Report {
    protected List<BankProduct> bankProducts;

    public Report() {
        bankProducts = new ArrayList<BankProduct>();
    }

    public void generateReport(List<BankProduct> analyzedBankProductList) {
        throw new UnsupportedOperationException();
    }
}
