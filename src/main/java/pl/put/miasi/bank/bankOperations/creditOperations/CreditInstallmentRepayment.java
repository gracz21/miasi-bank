package pl.put.miasi.bank.bankOperations.creditOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

/**
 * Spłata raty kredytu
 */
public class CreditInstallmentRepayment extends BankOperation {
    private Credit credit;

    public CreditInstallmentRepayment(String description, Credit credit) {
        super(description);
        this.credit = credit;
    }

    @Override
    public String getOperationName() {
        return "Credit installment repayment";
    }

    @Override
    public void execute() throws Exception {
        super.execute();
        double installment = credit.calculateInstallment();
        credit.getBankAccountDecorator().withdraw(installment);
        credit.deactivate();
    }
}
