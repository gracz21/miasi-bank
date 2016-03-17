package pl.put.miasi.bank.bankOperations.depositOperations;

import pl.put.miasi.bank.bankProducts.Deposit;

/**
 * Zerwanie lokaty
 */
public class DepositBroke extends DepositOperation {
    protected DepositBroke(String description, Deposit deposit) {
        super(description, deposit);
    }
}
