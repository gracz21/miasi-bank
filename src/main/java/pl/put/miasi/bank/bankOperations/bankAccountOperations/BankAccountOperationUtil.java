package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankProducts.exception.BalanceException;
import pl.put.miasi.bank.bankProducts.BankAccount;

import java.security.InvalidParameterException;

/**
 * @author Bartosz Skotarek
 */
public abstract class BankAccountOperationUtil {
    public static void transfer(BankAccount sourceBankAccount, BankAccount targetBankAccount, String description, double amount) throws BalanceException, InvalidParameterException {
        if(amount < 0) {
            throw new InvalidParameterException("Amount is negative");
        }

        Transfer sourceTransfer = new Transfer(description, sourceBankAccount, targetBankAccount, -amount);
        Transfer targetTransfer = new Transfer(description, sourceBankAccount, targetBankAccount, amount);

        targetBankAccount.updateBalance(amount);
        sourceBankAccount.updateBalance(-amount);

        sourceBankAccount.addBankOperation(sourceTransfer);
        targetBankAccount.addBankOperation(targetTransfer);

    }

    public static void payment(BankAccount bankAccount, String description, double amount) throws InvalidParameterException, BalanceException {
        if(amount < 0) {
            throw new InvalidParameterException("Amount is negative");
        }

        Payment payment = new Payment(description, bankAccount, amount);
        bankAccount.updateBalance(amount);
        bankAccount.addBankOperation(payment);
    }

    public static void withdraw(BankAccount bankAccount, String description, double amount) throws InvalidParameterException, BalanceException {
        if(amount < 0) {
            throw new InvalidParameterException("Amount is negative");
        }

        Withdrawal withdrawal = new Withdrawal(description, bankAccount, -amount);
        bankAccount.updateBalance(-amount);
        bankAccount.addBankOperation(withdrawal);
    }
}
