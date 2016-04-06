package pl.put.miasi.bank;

import pl.put.miasi.bank.bankProducts.BankAccount;
import pl.put.miasi.bank.bankProducts.BankProduct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Bartosz Skotarek
 */
public class Client {
    private String firstName;
    private String lastName;
    private String pesel;

    private List<BankProduct> bankProducts;

    public Client(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        bankProducts = new LinkedList<BankProduct>();
    }

    public void addBankProduct(BankProduct bankProduct) {
        bankProducts.add(bankProduct);
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

    public List<BankProduct> getBankProducts() {
        return bankProducts;
    }

}
