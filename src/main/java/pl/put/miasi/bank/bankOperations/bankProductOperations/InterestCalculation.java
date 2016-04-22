package pl.put.miasi.bank.bankOperations.bankProductOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * Obliczanie odsetek
 */
public class InterestCalculation extends BankOperation {
    private BankProduct bankProduct;

    public InterestCalculation(String description, BankProduct bankProduct) {
        super(description);
        this.bankProduct = bankProduct;
    }


    @Override
    public String getOperationName() {
        return "Interest calculation";
    }

    @Override
    public void execute() throws Exception {
//        InterestMechanism currentInterestMechanism = bankProduct.getInterestMechanism();
//        bankProduct.updateBalance(currentInterestMechanism.calculateInterest(bankProduct.getBalance()));
//        bankProduct.addBankOperation(this);
    }
}
