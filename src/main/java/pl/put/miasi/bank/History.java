package pl.put.miasi.bank;

import javafx.collections.transformation.SortedList;
import pl.put.miasi.bank.bankOperations.BankOperation;

/**
 * @author Bartosz Skotarek
 */
public class History {
    private SortedList<BankOperation> bankOperations;

    public History() {
        //bankOperations = new SortedList<BankOperation>();
    }

    public void addBankOperations(BankOperation bankOperation) {
        bankOperations.add(bankOperation);
    }
}
