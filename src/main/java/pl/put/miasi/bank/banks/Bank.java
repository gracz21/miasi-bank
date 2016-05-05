package pl.put.miasi.bank.banks;

import pl.put.miasi.bank.History;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.Payment;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.Transfer;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.Withdrawal;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations.InterbankOperation;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations.InterbankTransfer;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations.TransferDirection;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations.UnsuccessfulInterbankTransfer;
import pl.put.miasi.bank.bankOperations.bankProductOperations.InterestCalculation;
import pl.put.miasi.bank.bankOperations.bankProductOperations.InterestMechanismChange;
import pl.put.miasi.bank.bankOperations.bankProductOperations.ReportCreation;
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
    private Map<Long, BankProduct> bankProducts;
    private Map<Long, Map<Long, InterbankOperation>> interbankOperationsMap;
    private History globalHistory;

    public Bank() {
        this.bankId = idCounter.incrementAndGet();
        this.bankProducts = new HashMap<>();
        this.interbankOperationsMap = new HashMap<>();
        this.globalHistory = new History();
    }

    long getBankId() {
        return bankId;
    }

    public void addBankProduct(BankProduct bankProduct) {
        bankProducts.put(bankProduct.getId(), bankProduct);
    }

    public void setBankMediator(BankMediator bankMediator) {
        this.bankMediator = bankMediator;
        bankMediator.addBank(this);
    }

    public void payment(BankAccountDecorator bankAccountDecorator, double amount, String description) throws Exception {
        Payment bankOperation = new Payment(description, bankAccountDecorator, amount);
        try {
            bankAccountDecorator.doOperation(bankOperation);
            globalHistory.addBankOperation(bankOperation);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void withdrawal(BankAccountDecorator bankAccountDecorator, double amount, String description) throws Exception {
        Withdrawal bankOperation = new Withdrawal(description, bankAccountDecorator, amount);
        try {
            bankAccountDecorator.doOperation(bankOperation);
            globalHistory.addBankOperation(bankOperation);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void transfer(BankAccountDecorator sourceBankAccountDecorator, BankAccountDecorator targetBankAccountDecorator, double amount, String description) throws Exception {
        Transfer transfer = new Transfer(description, sourceBankAccountDecorator, targetBankAccountDecorator, amount);
        try {
            sourceBankAccountDecorator.doOperation(transfer);
            targetBankAccountDecorator.getHistory().addBankOperation(transfer);
            globalHistory.addBankOperation(transfer);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void interestCalculation(BankProduct bankProduct, String description) throws Exception {
        InterestCalculation bankOperation = new InterestCalculation(description, bankProduct);
        try {
            bankProduct.doOperation(bankOperation);
            globalHistory.addBankOperation(bankOperation);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void interestMechanismChange(InterestMechanism interestMechanism, BankProduct bankProduct, String description) throws Exception {
        InterestMechanismChange bankOperation = new InterestMechanismChange(description, interestMechanism, bankProduct);
        try {
            bankProduct.doOperation(bankOperation);
            globalHistory.addBankOperation(bankOperation);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void creditTaking(double amount, BankAccountDecorator bankAccountDecorator, InterestMechanism interestMechanism, String description) throws Exception {
        CreditTaking bankOperation = new CreditTaking(description, amount, bankAccountDecorator, interestMechanism, this);
        try {
            bankAccountDecorator.doOperation(bankOperation);
            globalHistory.addBankOperation(bankOperation);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void creditInstallmentRepayment(BankAccountDecorator bankAccountDecorator, Credit credit, String description) throws Exception {
        CreditInstallmentRepayment bankOperation = new CreditInstallmentRepayment(description, credit);
        try {
            credit.doOperation(bankOperation);
            globalHistory.addBankOperation(bankOperation);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void depositAssumption(BankAccountDecorator bankAccountDecorator, double depositAmount, InterestMechanism interestMechanism, String description) throws Exception {
        DepositAssumption bankOperation = new DepositAssumption(description, bankAccountDecorator, depositAmount, interestMechanism, this);
        try {
            bankAccountDecorator.doOperation(bankOperation);
            globalHistory.addBankOperation(bankOperation);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void depositBroke(Deposit deposit, String description) throws Exception {
        DepositBroke bankOperation = new DepositBroke(description, deposit);
        try {
            deposit.doOperation(bankOperation);
            globalHistory.addBankOperation(bankOperation);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<BankProduct> doReport(Report report, String description) throws Exception {
        ReportCreation reportCreation = new ReportCreation(description, new ArrayList<BankProduct>(bankProducts.values()), report);
        List<BankProduct> result = null;
        try {
            reportCreation.execute();
            globalHistory.addBankOperation(reportCreation);
            result = reportCreation.getResults();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void interbankTransfer(BankAccountDecorator sourceBankAccount, long targetBankAccountId,
                                  long targetBankId, double amount, String description) throws Exception {
        InterbankTransfer sourceTransfer = new InterbankTransfer(description, sourceBankAccount.getId(),
                targetBankAccountId, amount, TransferDirection.OUT);
        sourceTransfer.setExecutorObject(sourceBankAccount);

        try {
            sourceBankAccount.doOperation(sourceTransfer);
            globalHistory.addBankOperation(sourceTransfer);

            InterbankTransfer targetTransfer = new InterbankTransfer(description, sourceBankAccount.getId(),
                    targetBankAccountId, amount, TransferDirection.IN);
            storeInterbankOperation(targetBankId, targetBankAccountId, targetTransfer);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void storeInterbankOperation(long bankId, long bankAccountId, InterbankOperation interbankOperation) {
        if(!interbankOperationsMap.containsKey(bankId)) {
            interbankOperationsMap.put(bankId, new HashMap<>());
        }
        interbankOperationsMap.get(bankId).put(bankAccountId, interbankOperation);
    }

    public void sendInterbankOperationsPackage(long bankId) throws Exception {
        if(interbankOperationsMap.containsKey(bankId)) {
            bankMediator.deliverInterbankOperation(this.bankId, bankId, interbankOperationsMap.get(bankId));
            interbankOperationsMap.remove(bankId);
        } else {
            throw new NoOperationsExceptions("No operations stored for this bank");
        }
    }

    void handleInterbankOperations(long sourceBankId, Map<Long, InterbankOperation> interbankOperations) throws Exception {
        for(Map.Entry<Long, InterbankOperation> interbankOperationEntry: interbankOperations.entrySet()) {
            BankProduct targetBankAccount = bankProducts.get(interbankOperationEntry.getKey());
            InterbankOperation interbankOperation = interbankOperationEntry.getValue();

            if(targetBankAccount != null && BankAccountDecorator.class.isInstance(targetBankAccount)) {
                interbankOperationEntry.getValue().setExecutorObject(((BankAccountDecorator)targetBankAccount));
                try {
                    targetBankAccount.doOperation(interbankOperation);
                    globalHistory.addBankOperation(interbankOperation);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            } else if(InterbankTransfer.class.isInstance(interbankOperation)) {
                handleWrongInterbankTransfer(sourceBankId, (InterbankTransfer) interbankOperation);
            }
        }
    }

    private void handleWrongInterbankTransfer(long sourceBankId, InterbankTransfer interbankTransfer) {
        UnsuccessfulInterbankTransfer unsuccessfulInterbankTransfer =
                new UnsuccessfulInterbankTransfer("Return for unsuccessful transfer " + interbankTransfer.getDescription(),
                        interbankTransfer.getAmount());
        storeInterbankOperation(sourceBankId, interbankTransfer.getSourceBankAccountId(), unsuccessfulInterbankTransfer);
    }
}