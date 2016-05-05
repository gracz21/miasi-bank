package pl.put.miasi.bank.reports;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

/**
 * @author Bartosz Skotarek
 */
public class Over1000ReportTest extends EasyMockSupport {
    private BankAccount bankAccount;
    private Credit credit;


    @Before
    public void before() {
        bankAccount = mock(BankAccount.class);
        credit = mock(Credit.class);
    }

    @Test
    public void visitBankAccountAboveLimit() throws Exception {
        expect(bankAccount.getBalance()).andReturn(500.0);

        replayAll();

        Over1000Report over1000Report = new Over1000Report();
        BankProduct visit = over1000Report.visit(bankAccount);

        assertNull(visit);

        verifyAll();
    }

    @Test
    public void visitBankAccountBelowLimit() throws Exception {
        expect(bankAccount.getBalance()).andReturn(1500.0);

        replayAll();

        Over1000Report over1000Report = new Over1000Report();
        BankProduct visit = over1000Report.visit(bankAccount);

        assertNotNull(visit);

        verifyAll();
    }

    @Test
    public void visitCreditAboveLimit() throws Exception {
        expect(credit.getBalance()).andReturn(500.0);
        expect(credit.isActive()).andReturn(true);

        replayAll();

        Over1000Report over1000Report = new Over1000Report();
        BankProduct visit = over1000Report.visit(credit);

        assertNull(visit);

        verifyAll();
    }

    @Test
    public void visitCreditBelowLimit() throws Exception {
        expect(credit.getBalance()).andReturn(1500.0);
        expect(credit.isActive()).andReturn(true);

        replayAll();

        Over1000Report over1000Report = new Over1000Report();
        BankProduct visit = over1000Report.visit(credit);

        assertNotNull(visit);

        verifyAll();
    }

    @Test
    public void visitCreditIsDisactive() throws Exception {
        expect(credit.isActive()).andReturn(false);

        replayAll();

        Over1000Report over1000Report = new Over1000Report();
        BankProduct visit = over1000Report.visit(credit);

        assertNull(visit);

        verifyAll();
    }
}