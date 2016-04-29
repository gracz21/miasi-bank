package pl.put.miasi.bank.reports;

import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;

/**
 * Created by inf109714 on 2016-04-29.
 */
public class PassAllReport implements Report {
    @Override
    public BankProduct visit(BankAccount bankAccount) {
        return bankAccount;
    }

    @Override
    public BankProduct visit(Credit credit) {
        return credit;
    }

    @Override
    public BankProduct visit(Deposit deposit) {
        return deposit;
    }
}
