package pl.put.miasi.bank.bankOperations.depositOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;
import pl.put.miasi.bank.banks.Bank;

import java.security.InvalidParameterException;

/**
 * Zalozenie lokaty
 */
public class DepositAssumption extends BankOperation {
    private double depositAmount;
    private BankAccountDecorator bankAccountDecorator;
    private InterestMechanism interestMechanism;
    private Bank bank;

    public DepositAssumption(String description, BankAccountDecorator bankAccountDecorator, double depositAmount, InterestMechanism interestMechanism, Bank bank) {
        super(description);
        this.bankAccountDecorator = bankAccountDecorator;
        this.depositAmount = depositAmount;
        this.interestMechanism = interestMechanism;
        this.bank = bank;
    }

    @Override
    public String getOperationName() {
        return "Deposit assumption";
    }

    @Override
    public void execute() throws Exception {
        if (depositAmount <= 0) {
            throw new InvalidParameterException("Deposit amount is negative or equals to 0");
        }

        super.execute();
        Deposit deposit = new Deposit(depositAmount, bankAccountDecorator);
        bankAccountDecorator.withdraw(depositAmount);
        deposit.setInterestMechanism(interestMechanism);
        bank.addBankProduct(deposit);
    }
}
