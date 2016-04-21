package pl.put.miasi.bank.bankOperations.depositOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.Deposit;

/**
 * Zerwanie lokaty
 */
public class DepositBroke extends BankOperation {
    private BankAccount bankAccount;
    private Deposit deposit;

    public DepositBroke(String description, BankAccount bankAccount, Deposit deposit) {
        super(description);
        this.bankAccount = bankAccount;
        this.deposit = deposit;
    }

    @Override
    public String getOperationName() {
        return "Deposit broke";
    }

    @Override
    public void execute() throws Exception {
        bankAccount.updateBalance(deposit.getBalance());
        bankAccount.removeDeposit(deposit);
    }
}
