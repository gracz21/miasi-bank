package pl.put.miasi.bank.bankOperations.creditOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

/**
 * Spłata raty kredytu
 */
public class CreditInstallmentRepayment extends BankOperation {
    private Credit credit;
    private BankAccountDecorator bankAccountDecorator;

    public CreditInstallmentRepayment(String description, BankAccountDecorator bankAccountDecorator, Credit credit) {
        super(description);
        this.credit = credit;
        this.bankAccountDecorator = bankAccountDecorator;
    }

    @Override
    public String getOperationName() {
        return "Credit installment repayment";
    }

    @Override
    public void execute() throws Exception {
        super.execute();
        double installment = credit.calculateInstallment();
        bankAccountDecorator.withdraw(installment);
        credit.setBalance(0.0);
    }
}
