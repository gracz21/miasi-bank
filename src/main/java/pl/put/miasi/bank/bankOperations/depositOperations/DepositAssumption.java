package pl.put.miasi.bank.bankOperations.depositOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.Deposit;

import java.security.InvalidParameterException;

/**
 * Zalozenie lokaty
 */
public class DepositAssumption extends BankOperation {
    private double depositAmount;
    private BankAccount bankAccount;
    private InterestMechanism interestMechanism;

    protected DepositAssumption(String description, BankAccount bankAccount, double depositAmount, InterestMechanism interestMechanism) {
        super(description);
        this.bankAccount = bankAccount;
        this.depositAmount = depositAmount;
        this.interestMechanism = interestMechanism;
    }

    @Override
    public String getOperationName() {
        return "Deposit assumption";
    }

    @Override
    public void execute() throws Exception {
        if (depositAmount < 0) {
            throw new InvalidParameterException("Deposit amount is negative");
        }

        Deposit deposit = new Deposit(depositAmount);
        bankAccount.updateBalance(-depositAmount);
        deposit.setInterestMechanism(interestMechanism);
        bankAccount.addDeposit(deposit);
    }
}
