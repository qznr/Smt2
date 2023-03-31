package Praktikum.TinySwalayan;
import java.util.ArrayList;

public class Account {
    private String accountID;
    private String accountType;
    private double balance;
    private Customer customer; // reference to the corresponding Customer object
    private static ArrayList<Account> accounts = new ArrayList<Account>();

    public Account(){
    }

    public Account(String accountType, Customer customer, double balance) {
        this.customer = customer;
        if(accountType.equals("1") || accountType.equalsIgnoreCase("silver")){
            this.accountID = "38" + String.format("%08d",accounts.size());
            this.accountType = "Silver";
        }
        if(accountType.equals("2") || accountType.equalsIgnoreCase("gold")){
            this.accountID = "56" + String.format("%08d",accounts.size());
            this.accountType = "Gold";
        }
        if(accountType.equals("3") || accountType.equalsIgnoreCase("platinum")){
            this.accountID = "74" + String.format("%08d",accounts.size());
            this.accountType = "Platinum";
        }
        this.balance = balance;
    }

    public void addBalance(double balance){
        this.balance += balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getAccountType(){
        return accountType;
    }

    public String getAccountID() {
        return accountID;
    }

    public Double getBalance(){
        return balance;
    }

    public static ArrayList<Account> getAccounts(){
        return accounts;
    }

    public static Account findAccount(String id){
        for (Account account : Account.getAccounts()){
            if(account.getAccountID().equals(id)){
                return account;
            }
        }
        return null;
    }

    public static void addAccount(String accountType, Customer customer, double balance){
        Account account = new Account(accountType, customer, balance);
        accounts.add(account);
    }
}