package pl.put.miasi.bank.bankOperations.bankAccountOperations;

import pl.put.miasi.bank.bankOperations.bankAccountOperations.Transfer;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * @author Bartosz Skotarek
 */
public class BankAccountOperationUtil {
    public static void transfer(BankAccount sourceBankAccount, BankAccount targetBankAccount, String description, double amount) {
        Transfer sourceTransfer = new Transfer(description, sourceBankAccount, targetBankAccount, -amount);
        sourceBankAccount.addBankOperation(sourceTransfer);
        sourceBankAccount.updateBalance(-amount);

        Transfer targetTransfer = new Transfer(description, sourceBankAccount, targetBankAccount, amount);
        targetBankAccount.addBankOperation(targetTransfer);
        targetBankAccount.updateBalance(amount);
    }
}
