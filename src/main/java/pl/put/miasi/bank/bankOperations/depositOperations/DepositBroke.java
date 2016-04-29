package pl.put.miasi.bank.bankOperations.depositOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

/**
 * Zerwanie lokaty
 */
public class DepositBroke extends BankOperation {
    private BankAccountDecorator bankAccountDecorator;
    private Deposit deposit;

    public DepositBroke(String description, BankAccountDecorator bankAccountDecorator, Deposit deposit) {
        super(description);
        this.bankAccountDecorator = bankAccountDecorator;
        this.deposit = deposit;
    }

    @Override
    public String getOperationName() {
        return "Deposit broke";
    }

    @Override
    public void execute() throws Exception {
        super.execute();
        bankAccountDecorator.payment(deposit.getBalance());
        bankAccountDecorator.removeDeposit(deposit);
    }
}
