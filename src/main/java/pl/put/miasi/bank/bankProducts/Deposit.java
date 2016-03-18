package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;

/**
 * @author Bartosz Skotarek
 */
public class Deposit extends BankProduct {

    public Deposit(InterestMechanism interestMechanism) {
        super(interestMechanism);
    }
}
