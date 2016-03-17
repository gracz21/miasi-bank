package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.bankAccountOperations.Transfer;
import pl.put.miasi.bank.bankOperations.exception.BalanceException;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;

import java.security.InvalidParameterException;

/**
 * @author Bartosz Skotarek
 */
public class BankAccountOperationUtil {
    public static void transfer(BankAccount sourceBankAccount, BankAccount targetBankAccount, String description, double amount) throws BalanceException, InvalidParameterException {
        if(amount < 0) {
            throw new InvalidParameterException("Amount is negative");
        } else if(sourceBankAccount.getBalance() + sourceBankAccount.getMaxDebit() < amount) {
            throw new BalanceException("Insufficient balance");
        }

        Transfer sourceTransfer = new Transfer(description, sourceBankAccount, targetBankAccount, -amount);
        sourceBankAccount.addBankOperation(sourceTransfer);
        sourceBankAccount.updateBalance(-amount);

        Transfer targetTransfer = new Transfer(description, sourceBankAccount, targetBankAccount, amount);
        targetBankAccount.addBankOperation(targetTransfer);
        targetBankAccount.updateBalance(amount);
    }

    public static void payment(BankAccount bankAccount, String description, double amount) throws InvalidParameterException {
        if(amount < 0) {
            throw new InvalidParameterException("Amount is negative");
        }

        Payment payment = new Payment(description, bankAccount, amount);
        bankAccount.addBankOperation(payment);
        bankAccount.updateBalance(amount);
    }

    public static void withdraw(BankAccount bankAccount, String description, double amount) throws InvalidParameterException, BalanceException {
        if(amount < 0) {
            throw new InvalidParameterException("Amount is negative");
        } else if(bankAccount.getBalance() + bankAccount.getMaxDebit() < amount) {
            throw new BalanceException("Insufficient balance");
        }

        Withdrawal withdrawal = new Withdrawal(description, bankAccount, -amount);
        bankAccount.addBankOperation(withdrawal);
        bankAccount.updateBalance(-amount);
    }
}
