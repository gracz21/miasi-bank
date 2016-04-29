package pl.put.miasi.bank.bankOperations.depositOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

import java.security.InvalidParameterException;

/**
 * Zalozenie lokaty
 */
public class DepositAssumption extends BankOperation {
    private double depositAmount;
    private BankAccountDecorator bankAccountDecorator;
    private InterestMechanism interestMechanism;

    public DepositAssumption(String description, BankAccountDecorator bankAccountDecorator, double depositAmount, InterestMechanism interestMechanism) {
        super(description);
        this.bankAccountDecorator = bankAccountDecorator;
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

        super.execute();
        Deposit deposit = new Deposit(depositAmount);
        bankAccountDecorator.withdraw(depositAmount);
        deposit.setInterestMechanism(interestMechanism);
        bankAccountDecorator.addDeposit(deposit);
    }
}
