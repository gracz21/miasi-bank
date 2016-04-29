package pl.put.miasi.bank;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.Payment;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.Transfer;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.Withdrawal;
import pl.put.miasi.bank.bankOperations.bankProductOperations.InterestCalculation;
import pl.put.miasi.bank.bankOperations.bankProductOperations.InterestMechanismChange;
import pl.put.miasi.bank.bankOperations.creditOperations.CreditInstallmentRepayment;
import pl.put.miasi.bank.bankOperations.creditOperations.CreditTaking;
import pl.put.miasi.bank.bankOperations.depositOperations.DepositAssumption;
import pl.put.miasi.bank.bankOperations.depositOperations.DepositBroke;
import pl.put.miasi.bank.bankProducts.*;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountInterface;
import pl.put.miasi.bank.reports.Report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Bartosz Skotarek
 */
public class Bank {
    private BankMediator bankMediator;
    private List<BankProduct> bankProducts;
    private List<Report> reports;

    public Bank() {
        bankMediator = BankMediator.getInstance();
        bankMediator.addBank(this);
    }

    public void addBankProduct(BankProduct bankProduct) {
        bankProducts.add(bankProduct);
    }

    public List<BankOperation> collectGlobalHistory() {
        List<BankOperation> globalHistory = new LinkedList<BankOperation>();
        for (BankProduct bankProduct: bankProducts)
            globalHistory.addAll(bankProduct.getHistory().getBankOperations());

        Collections.sort(globalHistory);
        return globalHistory;
    }

    public List<BankProduct> getBankProducts() {
        return Collections.unmodifiableList(bankProducts);
    }

    public void payment(BankAccountInterface bankAccount, double amount, String description) throws Exception {
        bankAccount.doOperation(new Payment(description, bankAccount, amount));
    }

    public void withdrawal(BankAccountInterface bankAccount, double amount, String description) throws Exception {
        bankAccount.doOperation(new Withdrawal(description, bankAccount, amount));
    }

    public void transfer(BankAccountInterface sourceBankAccount, BankAccountInterface targetBankAccount, double amount, String description) throws Exception {
        Transfer sourceTransfer = new Transfer(description, sourceBankAccount, targetBankAccount, -amount);
        Transfer targetTransfer = new Transfer(description, sourceBankAccount, targetBankAccount, amount);
        sourceBankAccount.doOperation(sourceTransfer);
        targetBankAccount.doOperation(targetTransfer);
    }

    public void interestCalculation(BankProduct bankProduct, String description) throws Exception {
        bankProduct.doOperation(new InterestCalculation(description, bankProduct));
    }

    public void interestMechanismChange(InterestMechanism interestMechanism, BankProduct bankProduct, String description) throws Exception {
        bankProduct.doOperation(new InterestMechanismChange(description, interestMechanism, bankProduct));
    }

    public void creditInstallmentRepayment(BankAccount bankAccount, Credit credit, String description) throws Exception {
        bankAccount.doOperation(new CreditInstallmentRepayment(description, bankAccount, credit));
    }

    public void creditTaking(double amount, BankAccountInterface bankAccount, InterestMechanism interestMechanism, String description) throws Exception {
        bankAccount.doOperation(new CreditTaking(description, amount, bankAccount, interestMechanism));
    }

    public void depositAssumption(BankAccount bankAccount, double depositAmount, InterestMechanism interestMechanism, String description) throws Exception {
        bankAccount.doOperation(new DepositAssumption(description, bankAccount, depositAmount, interestMechanism));
    }

    public void depositBroke(BankAccount bankAccount, Deposit deposit, String description) throws Exception {
        bankAccount.doOperation(new DepositBroke(description, bankAccount, deposit));
    }

    public List<BankProduct> doReport(Report report) {
        List<BankProduct> result = new ArrayList<>();
        bankProducts.forEach(bankProduct -> result.add(bankProduct.accept(report)));
        return result;
    }
}
