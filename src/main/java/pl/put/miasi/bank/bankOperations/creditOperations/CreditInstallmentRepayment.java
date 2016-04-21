package pl.put.miasi.bank.bankOperations.creditOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.Credit;

/**
 * Spłata raty kredytu
 */
public class CreditInstallmentRepayment extends BankOperation {
    private Credit credit;
    private BankAccount bankAccount;

    public CreditInstallmentRepayment(String description, BankAccount bankAccount, Credit credit) {
        super(description);
        this.credit = credit;
        this.bankAccount = bankAccount;
    }

    @Override
    public String getOperationName() {
        return "Credit installment repayment";
    }

    @Override
    public void execute() throws Exception {
        double installment = credit.calculateInstallment();
        bankAccount.updateBalance(-installment);
        credit.setBalance(0.0);
    }
}
