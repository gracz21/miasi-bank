package pl.put.miasi.bank;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by inf109714 on 2016-04-22.
 */
public class BankMediator {
    private List<Bank> banks;

    public BankMediator() {
        banks = new LinkedList<Bank>();
    }

    public BankMediator addBank(Bank bank) {
        banks.add(bank);
        return this;
    }

    public void removeBank(Bank bank) {
        banks.remove(bank);
    }

//    public BankOperation makeOperation(BankAccountDecorator targetBankAccount) {
//        boolean exists = false;
//        List<BankAccountDecorator> bankAccounts;
//        for(Bank bank: banks) {
//            for(Client client: bank.getClients()) {
//                client.getBankAccounts().stream().filter(bankAccount -> bankAccount == targetBankAccount).forEach(bankAccount -> {
//                    exists = true;
//                    return;
//                });
//            }
//        }
//        return null;
//    }
}
