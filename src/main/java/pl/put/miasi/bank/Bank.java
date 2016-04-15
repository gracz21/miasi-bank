package pl.put.miasi.bank;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.Payment;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.Transfer;
import pl.put.miasi.bank.bankOperations.bankAccountOperations.Withdrawal;
import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.reports.Report;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bartosz Skotarek
 */
public class Bank {
    private List<Client> clients;
    private List<Report> reports;

    public void addClient(Client client) {
        clients.add(client);
    }
    public List<BankOperation> collectGlobalHistory() {
        List<BankOperation> globalHistory = new LinkedList<BankOperation>();
        for (Client client: clients)
            for (BankProduct bankProduct: client.getBankProducts())
                globalHistory.addAll(bankProduct.getHistory().getBankOperations().stream().collect(Collectors.toList()));

        Collections.sort(globalHistory);
        return globalHistory;
    }

    public void payment(BankAccount bankAccount, double amount, String description) throws Exception {
        bankAccount.doOperation(new Payment(description, bankAccount, amount));
    }

    public void withdrawal(BankAccount bankAccount, double amount, String description) throws Exception {
        bankAccount.doOperation(new Withdrawal(description, bankAccount, amount));
    }

    public void transfer(BankAccount sourceBankAccount, BankAccount targetBankAccount, double amount, String description) throws Exception {
        Transfer transfer = new Transfer(description, sourceBankAccount, targetBankAccount, amount);
        sourceBankAccount.doOperation(transfer);
        targetBankAccount.doOperation(transfer);
    }
}
