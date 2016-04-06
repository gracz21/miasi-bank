package pl.put.miasi.bank.bankOperations.creditOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import javax.naming.InsufficientResourcesException;
import java.security.InvalidParameterException;

/**
 * @author Kamil Walkowiak
 */
public abstract class CreditOperationUtil {
    public static Credit takeCredit(String description, BankAccount bankAccount, InterestMechanism interestMechanism, double creditAmount) throws BalanceException {
        if(creditAmount <= 0) {
            throw new InvalidParameterException("Credit amount is negative");
        }

        Credit credit = new Credit(creditAmount);
        bankAccount.updateBalance(creditAmount);
        credit.setInterestMechanism(interestMechanism);

        CreditTaking creditTaking = new CreditTaking(description, credit);
        bankAccount.addBankOperation(creditTaking);

        return credit;
    }

    /**
     * Rata kredytu
     * @param description
     * @param credit
     */
    public static void creditInstallmentRepayment(String description, BankAccount bankAccount, Credit credit) throws InsufficientResourcesException, BalanceException {
        CreditInstallmentRepayment creditInstallmentRepayment = new CreditInstallmentRepayment(description, credit);

        double installment = credit.calculateInstallment();
        bankAccount.updateBalance(-installment);
        credit.setBalance(0.0);

        bankAccount.addBankOperation(creditInstallmentRepayment);
    }
}
