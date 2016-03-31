package pl.put.miasi.bank.bankProducts;

import org.joda.time.DateTime;
import pl.put.miasi.bank.Client;
import pl.put.miasi.bank.History;
import pl.put.miasi.bank.bankMechanisms.DebitMechanism;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;

import java.util.Date;

/**
 * @author Bartosz Skotarek
 */
public class BankAccount extends BankProduct {
    private DateTime dateOfCreation = new DateTime();
    private DebitMechanism debitMechanism;
    private Client client;

    public BankAccount(InterestMechanism interestMechanism, Client client) {
        super(interestMechanism);
        this.client = client;
        this.balance = 0.0;
    }

    public BankAccount(InterestMechanism interestMechanism, Client client, DebitMechanism debitMechanism) {
        super(interestMechanism);
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setDebitMechanism(DebitMechanism debitMechanism) {
        this.debitMechanism = debitMechanism;
    }
}
