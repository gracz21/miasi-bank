package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;

/**
 * @author Bartosz Skotarek
 */
public class Credit extends BankProduct {
    public Credit(InterestMechanism interestMechanism) {
        super(interestMechanism);
    }
}
