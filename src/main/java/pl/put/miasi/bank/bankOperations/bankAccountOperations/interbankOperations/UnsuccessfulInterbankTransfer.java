package pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations;

import pl.put.miasi.bank.banks.Bank;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

import java.security.InvalidParameterException;

/**
 * @author Kamil Walkowiak
 */
public class UnsuccessfulInterbankTransfer extends InterbankOperation {
    private double amount;

    public UnsuccessfulInterbankTransfer(String description, double amount) {
        super(description);
        this.amount = amount;
    }

    @Override
    public String getOperationName() {
        return "Unsuccessful interbank transfer";
    }

    @Override
    public void execute() throws Exception {
        super.execute();

        if(amount >0) {
            executingBankAccount.payment(amount);
        } else {
            throw new InvalidParameterException("Amount is negative");
        }
    }
}
