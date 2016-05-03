package pl.put.miasi.bank.bankOperations.depositOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;

/**
 * Zerwanie lokaty
 */
public class DepositBroke extends BankOperation {
    private Deposit deposit;

    public DepositBroke(String description, Deposit deposit) {
        super(description);
        this.deposit = deposit;
    }

    @Override
    public String getOperationName() {
        return "Deposit broke";
    }

    @Override
    public void execute() throws Exception {
        super.execute();
        deposit.getBankAccountDecorator().payment(deposit.getBalance());
        deposit.deactivate();
    }
}
