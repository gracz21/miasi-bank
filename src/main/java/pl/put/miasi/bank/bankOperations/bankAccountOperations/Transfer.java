package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

/**
 * Przelew
 */
public class Transfer extends BankOperation {
    private BankAccountDecorator sourceBankAccountDecorator;
    private BankAccountDecorator targetBankAccountDecorator;
    private double amount;

    public Transfer(String description, BankAccountDecorator sourceBankAccountDecorator, BankAccountDecorator targetBankAccountDecorator,
                    double amount) {
        super(description);
        this.sourceBankAccountDecorator = sourceBankAccountDecorator;
        this.targetBankAccountDecorator = targetBankAccountDecorator;
        this.amount = amount;
    }

    @Override
    public String getOperationName() {
        return "Transfer";
    }

    @Override
    public void execute() throws Exception {
        super.execute();

        if(this.amount < 0) {
            sourceBankAccountDecorator.withdraw(-this.amount);
        } else {
            targetBankAccountDecorator.payment(this.amount);
        }
    }
}
