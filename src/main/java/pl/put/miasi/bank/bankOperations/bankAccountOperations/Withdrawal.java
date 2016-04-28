package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountInterface;

import java.security.InvalidParameterException;

/**
 * Wyplata
 */
public class Withdrawal extends BankOperation {
    private BankAccountInterface bankAccount;
    private double amount;

    public Withdrawal(String description, BankAccountInterface bankAccount, double amount) {
        super(description);
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.executed = false;
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
        bankAccount.withdraw(this.amount);

    }
}
