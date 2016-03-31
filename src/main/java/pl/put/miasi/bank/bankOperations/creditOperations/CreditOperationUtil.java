package pl.put.miasi.bank.bankOperations.creditOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.Credit;

import java.security.InvalidParameterException;

/**
 * @author Kamil Walkowiak
 */
public abstract class CreditOperationUtil {
    public static void creditTaking(String description, BankAccount bankAccount, InterestMechanism interestMechanism, double creditAmount) {
        if(creditAmount < 0) {
            throw new InvalidParameterException("Credit amount is negative");
        }

        Credit credit = new Credit(interestMechanism, bankAccount, creditAmount);
        CreditTaking creditTaking = new CreditTaking(description, credit);
        bankAccount.updateBalance(creditAmount);
        bankAccount.addBankOperation(creditTaking);
    }

    public static void creditInstallmentRepayment(String description, Credit credit) {
        CreditInstallmentRepayment creditInstallmentRepayment = new CreditInstallmentRepayment(description, credit);
        BankAccount bankAccount = credit.getBankAccount();
        bankAccount.updateBalance(-credit.calculateInstallment());
        credit.payCredit();
        bankAccount.addBankOperation(creditInstallmentRepayment);
    }
}
