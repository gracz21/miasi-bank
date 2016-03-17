package pl.put.miasi.bank.bankOperations.creditOperations;

import pl.put.miasi.bank.bankProducts.Credit;

/**
 * Spłata raty kredytu
 */
public class CreditInstallmentRepayment extends CreditOperation {
    public CreditInstallmentRepayment(String description, Credit credit) {
        super(description, credit);
    }

    @Override
    public String getOperationName() {
        return "Installment repayment";
    }
}
