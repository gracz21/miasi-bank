package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountInterface;

/**
 * Przelew
 */
public class Transfer extends BankOperation {
    private BankAccountInterface sourceBankAccount;
    private BankAccountInterface targetBankAccount;
    private double amount;

    public Transfer(String description, BankAccountInterface sourceBankAccount, BankAccountInterface targetBankAccount,
                    double amount) {
        super(description);
        this.sourceBankAccount = sourceBankAccount;
        this.targetBankAccount = targetBankAccount;
        this.amount = amount;
        this.executed = false;
    }

    @Override
    public String getOperationName() {
        return "Transfer";
    }

    @Override
    public void execute() throws Exception {
        super.execute();

        if(this.amount < 0) {
            sourceBankAccount.withdraw(-this.amount);
        } else {
            targetBankAccount.payment(this.amount);
        }
    }
}
