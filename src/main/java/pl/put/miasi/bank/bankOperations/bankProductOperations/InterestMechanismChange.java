package pl.put.miasi.bank.bankOperations.bankProductOperations;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankOperations.BankOperation;
import pl.put.miasi.bank.bankProducts.BankProduct;

/**
 * Zmiana mechanizmu oblicania odsetek
 */
public class InterestMechanismChange extends BankOperation {
    private InterestMechanism interestMechanism;
    private BankProduct bankProduct;

    public InterestMechanismChange(String description, InterestMechanism interestMechanism, BankProduct bankProduct) {
        super(description);
        this.interestMechanism = interestMechanism;
        this.bankProduct = bankProduct;
    }

    @Override
    public String getOperationName() {
        return "Interest mechanism change";
    }

    @Override
    public void execute() throws Exception {
        if(interestMechanism != null) {
            bankProduct.setInterestMechanism(interestMechanism);
        }
    }
}
