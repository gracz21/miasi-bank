package pl.put.miasi.bank.bankOperations.depositOperations;

import pl.put.miasi.bank.bankProducts.Deposit;

/**
 * Zalozenie lokaty
 */
public class DepositAssumption extends DepositOperation {
    protected DepositAssumption(String description, Deposit deposit) {
        super(description, deposit);
    }
}
