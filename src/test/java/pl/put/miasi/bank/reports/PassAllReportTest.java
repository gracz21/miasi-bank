package pl.put.miasi.bank.reports;

import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankMechanisms.InterestMechanism;
import pl.put.miasi.bank.bankMechanisms.exception.InterestRateException;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;
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
    public void before() throws InterestRateException, BalanceException {
        passAllReport = mock(PassAllReport.class);
    }

    @Test
    public void visitBankAccount() throws Exception {
        expect(passAllReport.visit(isA(BankAccount.class))).andReturn(isA(BankProduct.class));
    }

    @Test
    public void visitCredit() throws Exception {
        expect(passAllReport.visit(isA(Credit.class))).andReturn(isA(BankProduct.class));

    }

    @Test
    public void visitDeposit() throws Exception {
        expect(passAllReport.visit(isA(Deposit.class))).andReturn(isA(BankProduct.class));
    }

}