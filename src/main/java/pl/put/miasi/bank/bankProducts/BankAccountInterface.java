package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankProducts.exception.BalanceException;

/**
 * Created by inf109714 on 2016-04-22.
 */
public interface BankAccountInterface {
    void withdraw(double amount) throws BalanceException;
    void payment(double amount) throws BalanceException;
}
