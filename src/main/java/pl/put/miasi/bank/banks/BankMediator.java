package pl.put.miasi.bank.banks;

import pl.put.miasi.bank.bankOperations.bankAccountOperations.interbankOperations.InterbankOperation;
import pl.put.miasi.bank.banks.exceptions.BankNotFoundException;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by inf109714 on 2016-04-22.
 */
class BankMediator {
    private List<Bank> banks;

    public BankMediator() {
        banks = new LinkedList<Bank>();
    }

    BankMediator addBank(Bank bank) {
        banks.add(bank);
        return this;
    }

    public void removeBank(Bank bank) {
        banks.remove(bank);
    }

    void deliverInterbankOperation(long sourceBankId, long targetBankId, Map<Long, InterbankOperation> interbankOperations) throws Exception {
        if(banks.stream().filter(bank -> bank.getBankId() == targetBankId).findFirst().isPresent()) {
            banks.stream().filter(bank -> bank.getBankId() == targetBankId).findFirst().get()
                    .handleInterbankOperations(sourceBankId, interbankOperations);
        } else {
            throw new BankNotFoundException("Bank with given id not fond");
        }
    }
}
