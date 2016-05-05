package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.banks.Bank;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

import java.security.InvalidParameterException;

/**
 * @author Kamil Walkowiak
 */
public class UnsuccessfulInterbankTransfer extends BankOperation {
    private BankAccountDecorator bankAccount;
    private Bank bank;
    private double amount;

    public UnsuccessfulInterbankTransfer(String description, BankAccountDecorator bankAccount, double amount) {
        super(description);
        this.bankAccount = bankAccount;
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
            bankAccount.payment(amount);
        } else {
            throw new InvalidParameterException("Amount is negative");
        }
    }
}
