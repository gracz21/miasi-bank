package pl.put.miasi.bank.bankProducts;

import org.joda.time.DateTime;
import pl.put.miasi.bank.Client;
import pl.put.miasi.bank.History;
import pl.put.miasi.bank.bankMechanisms.DebitMechanism;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Bartosz Skotarek
 */
public class BankAccount extends BankProduct implements BankAccountInterface {
    private DateTime dateOfCreation = new DateTime();
    private List<Deposit> deposits;

    public BankAccount() {
        super(0);
        this.deposits = new ArrayList<Deposit>();
    }

    public DateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void addDeposit(Deposit deposit) {
        this.deposits.add(deposit);
    }

    public void removeDeposit(Deposit deposit) {
        this.deposits.remove(deposit);
    }

    @Override
    public void withdraw(double amount) throws BalanceException {
        if(balance >= amount && amount >= 0) {
            balance -= amount;
        } else {
            throw new BalanceException("Insufficient balance");
        }
    }

    @Override
    public void payment(double amount) throws BalanceException {
        if(amount > 0) {
            balance += amount;
        } else {
            throw new InvalidParameterException("Negative amount");
        }
    }
}
