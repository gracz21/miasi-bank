package pl.put.miasi.bank.bankMechanisms;

/**
 * @author Bartosz Skotarek
 */
public class ExampleDebitMechanism implements DebitMechanism {
    public double getMaxDebit() {
        return 50;
    }
}
