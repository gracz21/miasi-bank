package pl.put.miasi.bank.reports;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.ExampleDebitMechanism;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccountDebitDecorator;
import pl.put.miasi.bank.bankProducts.exception.BalanceException;
import pl.put.miasi.bank.banks.Bank;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * @author Bartosz Skotarek
 */
public class PassAllReportTest {
    private PassAllReport passAllReport;


    @Before
    public void before() {
        passAllReport = new PassAllReport();
    }

    @Test
    public void visitBankAccount() throws Exception {
        BankAccount bankAccount = new BankAccount();
        BankProduct visit = passAllReport.visit(bankAccount);

        assertEquals(bankAccount, visit);
    }

    @Test
    public void visitBankCredit() throws Exception {
        Credit credit = new Credit(100,
                new BankAccountDebitDecorator(new ExampleDebitMechanism(), new BankAccount())
        );
        BankProduct visit = passAllReport.visit(credit);

        assertEquals(credit, visit);
    }

    @Test
    public void visitBankDeposit() throws Exception {
        Deposit deposit = new Deposit(100,
                new BankAccountDebitDecorator(new ExampleDebitMechanism(), new BankAccount())
        );
        BankProduct visit = passAllReport.visit(deposit);

        assertEquals(deposit, visit);
    }
}