package pl.put.miasi.bank.bankProducts;

import pl.put.miasi.bank.bankMechanisms.InterestMechanism;

/**
 * @author Bartosz Skotarek
 */
public class Credit extends BankProduct {
    private BankAccount bankAccount;

    public Credit(InterestMechanism interestMechanism, BankAccount bankAccount, double balance) {
        super(interestMechanism);
        this.bankAccount = bankAccount;
        this.balance = balance;
    }

    public double calculateInstallment() {
        return balance + interestMechanism.calculateInterest(this.balance);
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
