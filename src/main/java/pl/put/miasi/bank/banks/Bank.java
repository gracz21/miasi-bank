package pl.put.miasi.bank.banks;

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
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDecorator;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
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

    public void addBankProduct(BankProduct bankProduct) {
        bankProducts.add(bankProduct);
    }

    public void setBankMediator(BankMediator bankMediator) {
        this.bankMediator = bankMediator;
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

    public void payment(BankAccountDecorator bankAccountDecorator, double amount, String description) throws Exception {
        bankAccountDecorator.doOperation(new Payment(description, bankAccountDecorator, amount));
    }

    public void withdrawal(BankAccountDecorator bankAccountDecorator, double amount, String description) throws Exception {
        bankAccountDecorator.doOperation(new Withdrawal(description, bankAccountDecorator, amount));
    }

    public void transfer(BankAccountDecorator sourceBankAccountDecorator, BankAccountDecorator targetBankAccountDecorator, double amount, String description) throws Exception {
        Transfer sourceTransfer = new Transfer(description, sourceBankAccountDecorator, targetBankAccountDecorator, -amount);
        Transfer targetTransfer = new Transfer(description, sourceBankAccountDecorator, targetBankAccountDecorator, amount);
        sourceBankAccountDecorator.doOperation(sourceTransfer);
        targetBankAccountDecorator.doOperation(targetTransfer);
    }

    public void interestCalculation(BankProduct bankProduct, String description) throws Exception {
        bankProduct.doOperation(new InterestCalculation(description, bankProduct));
    }

    public void interestMechanismChange(InterestMechanism interestMechanism, BankProduct bankProduct, String description) throws Exception {
        bankProduct.doOperation(new InterestMechanismChange(description, interestMechanism, bankProduct));
    }

    public void creditTaking(double amount, BankAccountDecorator bankAccountDecorator, InterestMechanism interestMechanism, String description) throws Exception {
        bankAccountDecorator.doOperation(new CreditTaking(description, amount, bankAccountDecorator, interestMechanism));
    }

    public void creditInstallmentRepayment(BankAccount bankAccountImpl, Credit credit, String description) throws Exception {
        bankAccountImpl.doOperation(new CreditInstallmentRepayment(description, bankAccountImpl, credit));
    }

    public void depositAssumption(BankAccount bankAccountImpl, double depositAmount, InterestMechanism interestMechanism, String description) throws Exception {
        bankAccountImpl.doOperation(new DepositAssumption(description, bankAccountImpl, depositAmount, interestMechanism));
    }

    public void depositBroke(BankAccount bankAccountImpl, Deposit deposit, String description) throws Exception {
        bankAccountImpl.doOperation(new DepositBroke(description, bankAccountImpl, deposit));
    }

    public List<BankProduct> doReport(Report report) {
        List<BankProduct> result = new ArrayList<>();
        bankProducts.forEach(bankProduct -> result.add(bankProduct.accept(report)));
        return result;
    }
}