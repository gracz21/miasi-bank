package pl.put.miasi.bank.bankProducts.bankAccount;

import org.joda.time.DateTime;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;
import pl.put.miasi.bank.reports.Report;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bartosz Skotarek
 */
public class BankAccount extends BankAccountDecorator {
    private DateTime dateOfCreation = new DateTime();

    public BankAccount() {
        super(0);
    }

    public DateTime getDateOfCreation() {
        return dateOfCreation;
    }

    @Override
    public void withdraw(double amount) throws BalanceException, InvalidParameterException {
        if(amount <= 0) {
            throw new InvalidParameterException("Amount is negative or equals to 0");
        }
        if(balance >= amount) {
            balance -= amount;
        } else {
            throw new BalanceException("Insufficient balance");
        }
    }

    @Override
    public void payment(double amount) {
        if(amount > 0) {
            balance += amount;
        } else {
            throw new InvalidParameterException("Amount is negative or equals to 0");
        }
    }

    @Override
    public BankProduct accept(Report report) {
        return report.visit(this);
    }
}
