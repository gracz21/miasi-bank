package pl.put.miasi.bank;

import javafx.collections.transformation.SortedList;
import pl.put.miasi.bank.bankOperations.BankOperation;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Bartosz Skotarek
 */
public class History {
    private List<BankOperation> bankOperations = new LinkedList<BankOperation>();

    public void addBankOperation(BankOperation bankOperation) {
        bankOperations.add(bankOperation);
    }
}
