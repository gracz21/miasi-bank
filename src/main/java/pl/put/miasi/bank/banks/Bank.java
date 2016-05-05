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
import pl.put.miasi.bank.banks.exceptions.NoOperationsExceptions;
import pl.put.miasi.bank.reports.Report;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Bartosz Skotarek
 */
public class Bank {
    private static AtomicLong idCounter = new AtomicLong();

    private long bankId;
    private BankMediator bankMediator;
    private List<BankProduct> bankProducts;
    private Map<Long, Map<Long, BankOperation>> interbankOperationsMap;

    public Bank() {
        this.bankId = idCounter.incrementAndGet();
        this.bankProducts = new LinkedList<>();
        this.interbankOperationsMap = new HashMap<>();
    }

    long getBankId() {
        return bankId;
    }

    public void addBankProduct(BankProduct bankProduct) {
        bankProducts.add(bankProduct);
    }

    public void setBankMediator(BankMediator bankMediator) {
        this.bankMediator = bankMediator;
    }

    public List<BankOperation> collectGlobalHistory() {
        List<BankOperation> globalHistory = new LinkedList<>();

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
        Transfer transfer = new Transfer(description, sourceBankAccountDecorator, targetBankAccountDecorator, -amount);
        sourceBankAccountDecorator.doOperation(transfer);
        targetBankAccountDecorator.getHistory().addBankOperation(transfer);
    }

    public void interestCalculation(BankProduct bankProduct, String description) throws Exception {
        bankProduct.doOperation(new InterestCalculation(description, bankProduct));
    }

    public void interestMechanismChange(InterestMechanism interestMechanism, BankProduct bankProduct, String description) throws Exception {
        bankProduct.doOperation(new InterestMechanismChange(description, interestMechanism, bankProduct));
    }

    public void creditTaking(double amount, BankAccountDecorator bankAccountDecorator, InterestMechanism interestMechanism, String description) throws Exception {
        bankAccountDecorator.doOperation(new CreditTaking(description, amount, bankAccountDecorator, interestMechanism, this));
    }

    public void creditInstallmentRepayment(BankAccountDecorator bankAccountDecorator, Credit credit, String description) throws Exception {
        credit.doOperation(new CreditInstallmentRepayment(description, bankAccountDecorator, credit));
    }

    public void depositAssumption(BankAccountDecorator bankAccountDecorator, double depositAmount, InterestMechanism interestMechanism, String description) throws Exception {
        bankAccountDecorator.doOperation(new DepositAssumption(description, bankAccountDecorator, depositAmount, interestMechanism, this));
    }

    public void depositBroke(Deposit deposit, String description) throws Exception {
        deposit.doOperation(new DepositBroke(description, deposit));
    }

    public void interbankTransfer(BankAccountDecorator sourceBankAccount, long targetBankAccountId,
                                  long targetBankId, double amount, String description) throws Exception {
        Transfer sourceTransfer = new Transfer(description, sourceBankAccount, targetBankAccount, -amount);
        Transfer targetTransfer = new Transfer(description, sourceBankAccount, targetBankAccount, amount);
        sourceBankAccount.doOperation(sourceTransfer);

        if(!interbankOperationsMap.containsKey(targetBankId)) {
            interbankOperationsMap.put(targetBankId, new HashMap<>());
        }
        interbankOperationsMap.get(targetBankId).put(targetBankAccountId, targetTransfer);
    }

    void handleInterbankOperations(List<BankOperation> interbankOperations) throws Exception {
        for(BankOperation interbankOperation: interbankOperations) {
            BankAccountDecorator bankAccountDecorator = interbankOperation.getTargetBankAccountDecorator();
            if(bankProducts.contains(bankAccountDecorator)) {
                bankAccountDecorator.doOperation(interbankOperation);
            } else {
                //TODO send payment back
            }
        }
    }

    public void sendInterbankTransferPackage(long bankId) throws Exception {
        if(interbankOperationsMap.containsKey(bankId)) {
            bankMediator.deliverInterbankOperation(bankId, interbankOperationsMap.get(bankId));
            interbankOperationsMap.remove(bankId);
        } else {
            throw new NoOperationsExceptions("No operations stored for this bank");
        }
    }

    public List<BankProduct> doReport(Report report) {
        List<BankProduct> result = new ArrayList<>();
        bankProducts.forEach(bankProduct -> result.add(bankProduct.accept(report)));
        return result;
    }
}