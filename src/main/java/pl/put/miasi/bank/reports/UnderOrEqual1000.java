package pl.put.miasi.bank.reports;

import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;

/**
 * Created by inf109760 on 2016-04-29.
 */
public class UnderOrEqual1000 implements Report {
    private int limit = 1000;

    @Override
    public BankProduct visit(BankAccount bankAccount) {
        if (bankAccount.getBalance() <= 1000) return bankAccount;
        return null;
    }

    @Override
    public BankProduct visit(Credit credit) {
        if (credit.isActive() && (credit.getBalance() <= 1000)) return credit;
        return null;
    }

    @Override
    public BankProduct visit(Deposit deposit) {
        if (deposit.isActive() && deposit.getBalance() <= 1000) return deposit;
        return null;
    }
}
