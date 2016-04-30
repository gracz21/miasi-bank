package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

import java.security.InvalidParameterException;

/**
 * Wyplata
 */
public class Withdrawal extends BankOperation {
    private BankAccountDecorator bankAccountDecorator;
    private double amount;

    public Withdrawal(String description, BankAccountDecorator bankAccountDecorator, double amount) {
        super(description);
        this.bankAccountDecorator = bankAccountDecorator;
        this.amount = amount;
    }

    @Override
    public String getOperationName() {
        return "Withdrawal";
    }

    @Override
    public void execute() throws Exception {
        if(this.amount < 0) {
            throw new InvalidParameterException("Amount is negative");
        }

        super.execute();
        bankAccountDecorator.withdraw(this.amount);

    }
}
