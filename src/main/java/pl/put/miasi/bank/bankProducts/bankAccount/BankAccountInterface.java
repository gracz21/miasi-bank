package pl.put.miasi.bank.bankProducts.bankAccount;

import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.DoOperationInterface;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

/**
 * Created by inf109714 on 2016-04-22.
 */
public interface BankAccountInterface extends DoOperationInterface {
    void withdraw(double amount) throws BalanceException;
    void payment(double amount) throws BalanceException;
    void addDeposit(Deposit deposit);
    void removeDeposit(Deposit deposit);
}
