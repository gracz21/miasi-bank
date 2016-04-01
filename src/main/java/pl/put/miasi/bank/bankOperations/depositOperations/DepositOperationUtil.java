package pl.put.miasi.bank.bankOperations.depositOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.Deposit;

import java.security.InvalidParameterException;

/**
 * @author Kamil Walkowiak
 */
public abstract class DepositOperationUtil {
//    public static void depositAssumption(String description, BankAccount bankAccount, InterestMechanism interestMechanism, double depositAmount) {
//        if(depositAmount < 0) {
//            throw new InvalidParameterException("Deposit amount is negative");
//        }
//
//        Deposit deposit = new Deposit(interestMechanism, bankAccount, depositAmount);
//        DepositAssumption depositAssumption = new DepositAssumption(description, deposit);
//        bankAccount.updateBalance(-depositAmount);
//        bankAccount.addBankOperation(depositAssumption);
//    }
//
//    public static void depositBroke(String description, Deposit deposit) {
//        DepositBroke depositBroke = new DepositBroke(description, deposit);
//        BankAccount bankAccount = deposit.getBankAccount();
//        bankAccount.updateBalance(deposit.getBalance());
//        deposit.brokeDeposit();
//        bankAccount.addBankOperation(depositBroke);
//    }
}
