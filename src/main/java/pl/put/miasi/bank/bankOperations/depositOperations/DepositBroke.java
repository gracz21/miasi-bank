package pl.put.miasi.bank.bankOperations.depositOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountInterface;

/**
 * Zerwanie lokaty
 */
public class DepositBroke extends BankOperation {
    private BankAccountInterface bankAccount;
    private Deposit deposit;

    public DepositBroke(String description, BankAccountInterface bankAccount, Deposit deposit) {
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
        super.execute();
        bankAccount.payment(deposit.getBalance());
        bankAccount.removeDeposit(deposit);
    }
}
