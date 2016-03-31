package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;

/**
 * @author Bartosz Skotarek
 */
public class Deposit extends BankProduct {
    private BankAccount bankAccount;

    public Deposit(InterestMechanism interestMechanism, BankAccount bankAccount, double balance) {
        super(interestMechanism);
        this.bankAccount = bankAccount;
        //TODO wyjatek przy ujemnym balance ???
        this.balance = balance;
    }

    public void brokeDeposit() {
        this.balance = 0.0;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
