package pl.put.miasi.bank.bankOperations.bankProductOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankProducts.BankProduct;

public abstract class BankProductOperationUtil {
    public static void calculateInterest(String description, BankProduct bankProduct) {
        InterestCalculation interestCalculation = new InterestCalculation(description, bankProduct);
        InterestMechanism currentInterestMechanism = bankProduct.getInterestMechanism();
        bankProduct.updateBalance(currentInterestMechanism.calculateInterest(bankProduct.getBalance()));
        bankProduct.addBankOperation(interestCalculation);
    }

    public static void changeInterestMechanism(String description, BankProduct bankProduct, InterestMechanism interestMechanism) {
        InterestMechanismChange interestMechanismChange = new InterestMechanismChange(description, interestMechanism, bankProduct);
        bankProduct.setInterestMechanism(interestMechanism);
        bankProduct.addBankOperation(interestMechanismChange);
    }

    public static void reportCreation() {
        //TODO
    }
}