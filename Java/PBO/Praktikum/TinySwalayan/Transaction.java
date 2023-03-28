package Praktikum.TinySwalayan;
import java.util.ArrayList;
import java.util.Date;
import java.text.DecimalFormat;

public class Transaction {
    private String transactionId;
    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private Account account;
    private double amount;
    private static DecimalFormat df = new DecimalFormat("###,###.00");
    
    public Transaction(Account account, double amount) {
        this.transactionId = Long.toString(new Date().getTime());
        this.account = account;
        this.amount = amount;
        transactions.add(this);
    }
    
    public static void buy(Account account, Items item, int quantity) {
        if (item.getQuantity() >= quantity) {
            double price = item.getPrice() * quantity;
            double balanceBefore = account.getBalance();
            double balanceAfter = balanceBefore - price;
    
            // validate minimum balance
            if (balanceAfter < 10000) {
                System.out.println("Pembelian gagal. Saldo tidak cukup!");
                return;
            }
    
            // proceed with the transaction
            if (account.getBalance() >= price) {
                account.addBalance(-1 * price);
                item.setQuantity(item.getQuantity() - quantity);
                System.out.println("Pembelian berhasil!");
                
                // calculate cashback
                double cashback = 0;
                if (price >= 1000000) {
                    if (account.getAccountType().equals("Silver")) {
                        cashback = price * 0.05;
                    } else if (account.getAccountType().equals("Gold")) {
                        cashback = price * 0.07;
                    } else if (account.getAccountType().equals("Platinum")) {
                        cashback = price * 0.1;
                    }
                } else {
                    if (account.getAccountType().equals("Gold")) {
                        cashback = price * 0.02;
                    } else if (account.getAccountType().equals("Platinum")) {
                        cashback = price * 0.05;
                    }
                }
                account.addBalance(cashback);
                System.out.println("Saldo awal\t: Rp." + df.format(balanceBefore));
                System.out.println("Harga barang\t: Rp." + df.format(price));
                System.out.println("Cashback\t: Rp." + df.format(cashback));
                System.out.println("Saldo sekarang\t: Rp." + df.format(account.getBalance()));
            } else {
                System.out.println("Pembelian gagal. Saldo tidak cukup!");
            }
        } else {
            System.out.println("Pembelian gagal. Barang tidak cukup dengan jumlah permintaan.");
        }
    }
    
    
    public static ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }
}