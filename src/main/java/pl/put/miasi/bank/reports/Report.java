package pl.put.miasi.bank.reports;

import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;

/**
 * @author Bartosz Skotarek
 */
public interface Report {
    BankProduct visit(BankAccount bankAccountImpl);
    BankProduct visit(Credit credit);
    BankProduct visit(Deposit deposit);
}
