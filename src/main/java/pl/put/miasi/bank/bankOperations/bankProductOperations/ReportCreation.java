package pl.put.miasi.bank.bankOperations.bankProductOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.reports.Report;

import java.util.ArrayList;
import java.util.List;

/**
 * Tworzenie raportu
 */
public class ReportCreation extends BankOperation {
    private List<BankProduct> bankProducts;
    private List<BankProduct> results;
    private Report report;

    public ReportCreation(String description, List<BankProduct> bankProducts, Report report) {
        super(description);
        this.bankProducts = bankProducts;
        this.results = new ArrayList<>();
        this.report = report;
    }

    public List<BankProduct> getResults() {
        return results;
    }

    @Override
    public String getOperationName() {
        return "Report creation";
    }

    @Override
    public void execute() throws Exception {
        super.execute();
        bankProducts.forEach(bankProduct -> results.add(bankProduct.accept(report)));
    }
}
