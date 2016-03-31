package pl.put.miasi.bank.reports;

import pl.put.miasi.bank.bankProducts.BankProduct;

import java.util.List;

/**
 * @author Kamil Walkowiak
 */
public class BalanceValueHigherThanReport extends Report {
    private double balanceValue;

    public BalanceValueHigherThanReport(double balanceValue) {
        super();
        this.balanceValue = balanceValue;
    }

    @Override
    public void generateReport(List<BankProduct> analyzedBankProductList) {
        for(BankProduct bankProduct: analyzedBankProductList) {
            if(bankProduct.getBalance() > balanceValue) {
                bankProducts.add(bankProduct);
            }
        }
    }
}
