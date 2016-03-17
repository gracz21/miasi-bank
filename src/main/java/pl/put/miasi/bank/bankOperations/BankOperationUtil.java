package pl.put.miasi.bank.bankOperations;

import pl.put.miasi.bank.bankOperations.bankAccountOperations.Transfer;
import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * @author Bartosz Skotarek
 */
public class BankOperationUtil {
    public static void transfer(BankProduct sourceBankProduct, BankProduct targetBankProduct, double amount) {
        //
        Transfer sourceTransfer = new Transfer("Przelew do docelowego konta", sourceBankProduct, targetBankProduct, -amount);
        sourceBankProduct.addBankOperation(sourceTransfer);
        sourceBankProduct.updateBalance(-amount);

        //
        Transfer targetTransfer = new Transfer("Przelew od zrodlowego konta", sourceBankProduct, targetBankProduct, amount);
        targetBankProduct.addBankOperation(targetTransfer);
        targetBankProduct.updateBalance(amount);
    }
}
