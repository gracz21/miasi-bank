package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.BankOperation;

/**
 * @author Kamil Walkowiak
 */
public class UnsuccessfulTransfer extends BankOperation {
    protected UnsuccessfulTransfer(String description) {
        super(description);
    }

    @Override
    public String getOperationName() {
        return null;
    }

    @Override
    public void execute() throws Exception {
        super.execute();
    }
}
