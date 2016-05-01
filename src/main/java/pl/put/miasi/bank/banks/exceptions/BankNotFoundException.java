package pl.put.miasi.bank.banks.exceptions;

/**
 * @author Kamil Walkowiak
 */
public class BankNotFoundException extends Exception {
    public BankNotFoundException(String message) {
        super(message);
    }
}
