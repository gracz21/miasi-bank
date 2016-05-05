package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.banks.Bank;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

/**
 * @author Kamil Walkowiak
 */
public class InterbankTransfer extends BankOperation implements InterbankOperation {
    private BankAccountDecorator sourceBankAccount;
    private BankAccountDecorator targetBankAccount;
    private double amount;

    public InterbankTransfer(String description, BankAccountDecorator sourceBankAccount, BankAccountDecorator targetBankAccount, double amount) {
        super(description);
        this.sourceBankAccount = sourceBankAccount;
        this.targetBankAccount = targetBankAccount;
        this.amount = amount;
    }


    @Override
    public String getOperationName() {
        return "Interbank transfer";
    }

    @Override
    public void execute() throws Exception {
        super.execute();

        if(amount < 0) {
            sourceBankAccount.withdraw(amount);
        } else {
            targetBankAccount.payment(amount);
        }
    }
}
