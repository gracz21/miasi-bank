package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.History;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;

/**
 * @author Kamil Walkowiak
 */
public abstract class BankProduct {
    protected String id;
    protected History history;
    protected InterestMechanism interestMechanism;
}
