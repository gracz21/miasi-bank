package pl.put.miasi.bank.bankOperations.depositOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;

import java.security.InvalidParameterException;

/**
 * @author Kamil Walkowiak
 */
public abstract class DepositOperationUtil {
    /**
     * Zalozenie konta debetowego
     *
     * @param description
     * @param bankAccount
     * @param interestMechanism
     * @param depositAmount
     */
    public static void depositAssumption(String description, BankAccount bankAccount, InterestMechanism interestMechanism, double depositAmount) throws BalanceException {
        if (depositAmount < 0) {
            throw new InvalidParameterException("Deposit amount is negative");
        }

        Deposit deposit = new Deposit(depositAmount);
        bankAccount.updateBalance(-depositAmount);
        deposit.setInterestMechanism(interestMechanism);

        DepositAssumption depositAssumption = new DepositAssumption(description, deposit);
        bankAccount.addBankOperation(depositAssumption);
    }

    /**
     * Zamkniecie konta debetowego
     *
     * @param description
     * @param deposit
     */
    public static void depositBroke(String description, BankAccount bankAccount, Deposit deposit) throws BalanceException {
        DepositBroke depositBroke = new DepositBroke(description, deposit);
        bankAccount.updateBalance(deposit.getBalance());
        deposit.brokeDeposit();
        bankAccount.addBankOperation(depositBroke);
    }
}
