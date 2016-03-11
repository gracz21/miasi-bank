package pl.put.miasi.bank;

import javafx.collections.transformation.SortedList;
import pl.put.miasi.bank.bankOperation.BankOperation;

/**
 * @author Bartosz Skotarek
 */
public class History {
    private SortedList<BankOperation> bankOperations;

    public void dodajOperacjeBankowa(BankOperation operacjaBankowa) {
        bankOperations.add(operacjaBankowa);
    }
}
