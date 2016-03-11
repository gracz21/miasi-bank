package pl.put.miasi.bank;

import javafx.collections.transformation.SortedList;
import pl.put.miasi.bank.operacjaBankowa.OperacjaBankowa;

import java.util.List;

/**
 * @author Bartosz Skotarek
 */
public class Historia {
    private SortedList<OperacjaBankowa> operacjeBankowe;

    public void dodajOperacjeBankowa(OperacjaBankowa operacjaBankowa) {
        operacjeBankowe.add(operacjaBankowa);
    }
}
