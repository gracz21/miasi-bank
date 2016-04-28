package pl.put.miasi.bank.bankOperations.creditOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountInterface;

import java.security.InvalidParameterException;

/**
 * Wziecie kredyty
 */
public class CreditTaking extends BankOperation {
    private double amount;
    private BankAccountInterface bankAccount;
    private InterestMechanism interestMechanism;

    public CreditTaking(String description, double amount, BankAccountInterface bankAccount, InterestMechanism interestMechanism) {
        super(description);
        this.amount = amount;
        this.bankAccount = bankAccount;
        this.interestMechanism = interestMechanism;
    }

    @Override
    public String getOperationName() {
        return "Credit taking";
    }

    @Override
    public void execute() throws Exception {
        if(this.amount <= 0) {
            throw new InvalidParameterException("Credit amount is negative");
        }

        Credit credit = new Credit(amount);
        bankAccount.payment(amount);
        credit.setInterestMechanism(interestMechanism);
    }
}
