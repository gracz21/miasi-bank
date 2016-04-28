package pl.put.miasi.bank.bankOperations.bankProductOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * Tworzenie raportu
 */
public class ReportCreation extends BankOperation {
    public ReportCreation(String description) {
        super(description);
    }

    @Override
    public String getOperationName() {
        return "Report creation";
    }

    @Override
    public void execute() throws Exception {
        super.execute();
    }
}
