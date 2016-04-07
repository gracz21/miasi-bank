package pl.put.miasi.bank;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.reports.Report;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
                for (BankOperation bankOperation: bankProduct.getHistory().getBankOperations())
                    globalHistory.add(bankOperation);

        Collections.sort(globalHistory);
        return globalHistory;
    }
}
