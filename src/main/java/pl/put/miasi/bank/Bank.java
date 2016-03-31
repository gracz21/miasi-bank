package pl.put.miasi.bank;

import pl.put.miasi.bank.reports.Report;

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
}
