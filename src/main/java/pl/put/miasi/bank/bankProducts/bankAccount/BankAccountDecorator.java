package pl.put.miasi.bank.bankProducts.bankAccount;

import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

/**
 * Created by inf109714 on 2016-04-22.
 */
public abstract class BankAccountDecorator extends BankProduct {
    public BankAccountDecorator(double balance) {
        super(balance);
    }

    public abstract void withdraw(double amount) throws BalanceException;
    public abstract void payment(double amount) throws BalanceException;
    public abstract void addDeposit(Deposit deposit);
    public abstract void removeDeposit(Deposit deposit);
    public abstract void addCredit(Credit credit);
    public abstract void removeCredit(Credit credit);
}
