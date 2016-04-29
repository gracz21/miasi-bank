package pl.put.miasi.bank.bankOperations.bankProductOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountInterface;

/**
 * Obliczanie odsetek
 */
public class InterestCalculation extends BankOperation {
    private BankProduct bankProduct;
    private double calculatedInterest;

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
        super.execute();
        InterestMechanism currentInterestMechanism = bankProduct.getInterestMechanism();
        calculatedInterest = currentInterestMechanism.calculateInterest(bankProduct.getBalance());
    }

    public double getCalculatedInterest() {
        return calculatedInterest;
    }
}
