package pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations;

import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

import java.security.InvalidParameterException;

/**
 * @author Kamil Walkowiak
 */
public class InterbankTransfer extends InterbankOperation {
    private long sourceBankAccountId;
    private long targetBankAccountId;
    private TransferDirection direction;

    public InterbankTransfer(String description, long sourceBankAccountId, long targetBankAccountId, double amount, TransferDirection direction) {
        super(description);
        this.sourceBankAccountId = sourceBankAccountId;
        this.targetBankAccountId = targetBankAccountId;
        this.amount = amount;
        this.direction = direction;
    }

    public long getSourceBankAccountId() {
        return sourceBankAccountId;
    }

    public long getTargetBankAccountId() {
        return targetBankAccountId;
    }

    @Override
    public String getOperationName() {
        return "Interbank transfer";
    }

    @Override
    public void execute() throws Exception {
        if(executingBankAccount == null) {
            throw new NullPointerException("Executor has not been set");
        }
        if(amount <= 0) {
            throw new InvalidParameterException("Amount is negative or is equal to 0");
        }

        super.execute();

        if(direction == TransferDirection.IN) {
            executingBankAccount.payment(amount);
        } else {
            executingBankAccount.withdraw(amount);
        }
    }
}
