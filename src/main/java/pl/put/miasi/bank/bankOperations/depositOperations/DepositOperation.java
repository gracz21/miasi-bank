package pl.put.miasi.bank.bankOperations.depositOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Deposit;

/**
 * @author Kamil Walkowiak
 */
public abstract class DepositOperation extends BankOperation {
    protected DepositOperation(String description, Deposit deposit) {
        super(description, deposit);
    }
}
