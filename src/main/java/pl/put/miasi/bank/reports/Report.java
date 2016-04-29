package pl.put.miasi.bank.reports;

import pl.put.miasi.bank.bankProducts.BankProduct;
import pl.put.miasi.bank.bankProducts.Credit;
import pl.put.miasi.bank.bankProducts.Deposit;
import pl.put.miasi.bank.bankProducts.bankAccount.BankAccount;

/**
 * @author Bartosz Skotarek
 */
public interface Report {
    BankProduct visit(BankAccount bankAccountImpl);
    BankProduct visit(Credit credit);
    BankProduct visit(Deposit deposit);
//    protected List<BankProduct> bankProducts;
//
//    public Report() {
//        bankProducts = new ArrayList<BankProduct>();
//    }
//
//    public List<BankProduct> generateValueHigherThanLimit(List<BankProduct> analyzedBankProductList, double limit) {
//        bankProducts.clear();
//        for(BankProduct bankProduct: analyzedBankProductList) {
//            if(bankProduct.getBalance() > limit) {
//                bankProducts.add(bankProduct);
//            }
//        }
//        return bankProducts;
//    }
//
//    public List<BankProduct> generateValueLowerThanLimit(List<BankProduct> analyzedBankProductList, double limit) {
//        bankProducts.clear();
//        for(BankProduct bankProduct: analyzedBankProductList) {
//            if(bankProduct.getBalance() < limit) {
//                bankProducts.add(bankProduct);
//            }
//        }
//        return bankProducts;
//    }
//
//    public double calculateSummaryBalance(List<BankProduct> analyzedBankProductList) {
//        double summaryBalance = 0.0;
//        for(BankProduct bankProduct: analyzedBankProductList) {
//            summaryBalance += bankProduct.getBalance();
//        }
//        return summaryBalance;
//    }
}
