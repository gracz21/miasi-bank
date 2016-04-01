package pl.put.miasi.bank.bankOperations.creditOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.Credit;

import javax.naming.InsufficientResourcesException;
import java.security.InvalidParameterException;

/**
 * @author Kamil Walkowiak
 */
public abstract class CreditOperationUtil {
    public static Credit takeCredit(String description, BankAccount bankAccount, InterestMechanism interestMechanism, double creditAmount) {
        if(creditAmount <= 0) {
            throw new InvalidParameterException("Credit amount is negative");
        }

        Credit credit = new Credit(creditAmount);
        credit.setInterestMechanism(interestMechanism);
        bankAccount.updateBalance(creditAmount);

        CreditTaking creditTaking = new CreditTaking(description, credit);
        bankAccount.addBankOperation(creditTaking);

        return credit;
    }

    /**
     * Rata kredytu
     * @param description
     * @param credit
     */
    public static void creditInstallmentRepayment(String description, BankAccount bankAccount, Credit credit) throws InsufficientResourcesException {
        CreditInstallmentRepayment creditInstallmentRepayment = new CreditInstallmentRepayment(description, credit);

        double accountBalance = bankAccount.getBalance();

        double installment = credit.getInterestMechanism().calculateInterest(credit.getBalance());
        bankAccount.updateBalance(-installment);

        if(bankAccount.getBalance() < 0) {
            if(-bankAccount.getBalance() > bankAccount.getDebitMechanism().getMaxDebit()) {
                bankAccount.setBalance(accountBalance);
                throw new InsufficientResourcesException();
            }
        }

        bankAccount.addBankOperation(creditInstallmentRepayment);
    }
}
