package pl.put.miasi.bank.banks;

import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.banks.exceptions.BankNotFoundException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by inf109714 on 2016-04-22.
 */
class BankMediator {
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

    void deliverInterbankOperation(long bankId, List<BankOperation> interbankOperations) throws Exception {
        if(banks.stream().filter(bank -> bank.getBankId() == bankId).findFirst().isPresent()) {
            banks.stream().filter(bank -> bank.getBankId() == bankId).findFirst().get()
                    .handleInterbankOperations(interbankOperations);
        } else {
            throw new BankNotFoundException("Bank with given id not fond");
        }
    }
}
