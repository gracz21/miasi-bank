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
        //TODO wyjatek przy ujemnym balance ???
        this.balance = balance;
    }

    public double calculateInstallment() {
        return balance + interestMechanism.calculateInterest(this.balance);
    }

    public void payCredit() {
        balance = 0.0;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
