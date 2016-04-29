package pl.put.miasi.bank.bankProducts.bankAccount;

import pl.put.miasi.bank.bankMechanisms.DebitMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;
import pl.put.miasi.bank.reports.Report;

import java.security.InvalidParameterException;

/**
 * Created by inf109714 on 2016-04-22.
 */
public class BankAccountDecoratorDebit extends BankAccountDecorator {
    private DebitMechanism debitMechanism;
    private BankAccount bankAccount;
    private double debitValue;

    public BankAccountDecoratorDebit(DebitMechanism debitMechanism, BankAccount bankAccount) {
        super(0);
        this.debitMechanism = debitMechanism;
        this.bankAccount = bankAccount;
    }


    public DebitMechanism getDebitMechanism() {
        return debitMechanism;
    }

    public void setDebitMechanism(DebitMechanism debitMechanism) {
        this.debitMechanism = debitMechanism;
    }

    @Override
    public void withdraw(double amount) throws BalanceException {
        double balance = bankAccount.getBalance();
        if(balance + (this.debitMechanism.getMaxDebit() - debitValue) >= amount && amount >= 0) {
            if(balance >= amount) {
                bankAccount.withdraw(amount);
            } else {
                bankAccount.withdraw(balance);
                debitValue += amount - balance;
            }
        } else {
            throw new BalanceException("Insufficient balance");
        }
    }

    @Override
    public void payment(double amount) throws BalanceException {
        if(amount > 0) {
            if (debitValue > 0) {
                double rest = amount - debitValue;
                if (rest > 0) {
                    bankAccount.payment(rest);
                    debitValue = 0;
                } else {
                    debitValue -= amount;
                }
            } else {
                bankAccount.payment(amount);
            }
        } else {
            throw new InvalidParameterException("Negative amount");
        }
    }

    @Override
    public void addDeposit(Deposit deposit) {
        bankAccount.addDeposit(deposit);
    }

    @Override
    public void removeDeposit(Deposit deposit) {
        bankAccount.removeDeposit(deposit);
    }

    @Override
    public void addCredit(Credit credit) {
        bankAccount.addCredit(credit);
    }

    @Override
    public void removeCredit(Credit credit) {
        bankAccount.removeCredit(credit);
    }

    public double getDebitValue() {
        return debitValue;
    }

    @Override
    public void doOperation(BankOperation bankOperation) throws Exception {
        bankAccount.doOperation(bankOperation);
    }

    @Override
    public BankProduct accept(Report report) {
        return bankAccount.accept(report);
    }
}
