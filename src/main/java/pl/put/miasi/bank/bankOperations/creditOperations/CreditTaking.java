package pl.put.miasi.bank.bankOperations.creditOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

import java.security.InvalidParameterException;

/**
 * Wziecie kredyty
 */
public class CreditTaking extends BankOperation {
    private double amount;
    private BankAccountDecorator bankAccountDecorator;
    private InterestMechanism interestMechanism;

    public CreditTaking(String description, double amount, BankAccountDecorator bankAccountDecorator, InterestMechanism interestMechanism) {
        super(description);
        this.amount = amount;
        this.bankAccountDecorator = bankAccountDecorator;
        this.interestMechanism = interestMechanism;
    }

    @Override
    public String getOperationName() {
        return "Credit taking";
    }

    @Override
    public void execute() throws Exception {
        if(this.amount <= 0) {
            throw new InvalidParameterException("Credit amount is negative or equals to 0");
        }

        super.execute();
        Credit credit = new Credit(amount, bankAccountDecorator);
        bankAccountDecorator.payment(amount);
        credit.setInterestMechanism(interestMechanism);
    }
}
