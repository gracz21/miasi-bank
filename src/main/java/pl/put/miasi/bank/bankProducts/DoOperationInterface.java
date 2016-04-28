package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankOperations.BankOperation;

/**
 * @author Kamil Walkowiak
 */
public interface DoOperationInterface {
    void doOperation(BankOperation bankOperation) throws Exception;
}
