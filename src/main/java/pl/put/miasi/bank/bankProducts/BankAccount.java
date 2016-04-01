package pl.put.miasi.bank.bankProducts;

import org.joda.time.DateTime;
import pl.put.miasi.bank.Client;
import pl.put.miasi.bank.History;
import pl.put.miasi.bank.bankMechanisms.DebitMechanism;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Bartosz Skotarek
 */
public class BankAccount extends BankProduct {
    private DateTime dateOfCreation = new DateTime();
    private DebitMechanism debitMechanism;

    public BankAccount() {
        this.balance = 0.0;
    }

    public BankAccount(DebitMechanism debitMechanism) {
        this.debitMechanism = debitMechanism;
    }

    public double getMaxDebit() {
        if(debitMechanism == null) {
            return 0;
        } else {
            return debitMechanism.getMaxDebit();
        }
    }

    public DateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public DebitMechanism getDebitMechanism() {
        return debitMechanism;
    }

    public void setDebitMechanism(DebitMechanism debitMechanism) {
        this.debitMechanism = debitMechanism;
    }
}
