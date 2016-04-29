package pl.put.miasi.bank.reports;

import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;

/**
 * Created by inf109714 on 2016-04-29.
 */
public class Over1000Report implements Report {
    private double limit = 1000;

    @Override
    public BankProduct visit(BankAccount bankAccountImpl) {
        if(bankAccountImpl.getBalance() > limit) {
            return bankAccountImpl;
        } else {
            return null;
        }
    }

    @Override
    public BankProduct visit(Credit credit) {
        if(credit.getBalance() > limit && credit.isActive()) {
            return credit;
        } else {
            return null;
        }
    }

    @Override
    public BankProduct visit(Deposit deposit) {
        if(deposit.getBalance() > limit && deposit.isActive()) {
            return deposit;
        } else {
            return null;
        }
    }
}
