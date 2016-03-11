package pl.put.miasi.bank;

import pl.put.miasi.bank.bankProducts.BankAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bartosz Skotarek
 */
public class Client {
    private String firstName;
    private String lastName;
    private String pesel;
    private List<BankAccount> bankAccounts;

    public Client(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        bankAccounts = new ArrayList<BankAccount>();
    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

}
