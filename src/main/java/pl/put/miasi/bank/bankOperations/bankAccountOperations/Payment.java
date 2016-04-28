package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountInterface;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import java.security.InvalidParameterException;

/**
 * Wplata
 */
public class Payment extends BankOperation {
    private BankAccountInterface bankAccount;
    private double amount;

    public Payment(String description, BankAccountInterface bankAccount, double amount) {
        super(description);
        this.executed = false;
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    @Override
    public String getOperationName() {
        return "Payment";
    }

    @Override
    public void execute() throws Exception {
        if(this.amount < 0) {
            throw new InvalidParameterException("Amount is negative");
        }

        super.execute();
        bankAccount.payment(this.amount);
    }
}
