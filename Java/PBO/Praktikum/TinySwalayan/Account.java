package Praktikum.TinySwalayan;
import java.util.ArrayList;

public class Account {
    private String accountID;
    private String accountType;
    private static ArrayList<Account> accounts;

    public Account(String accountType) {
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
    }

    public String getAccountType(){
        return accountType;
    }

    public String getAccountID() {
        return accountID;
    }

    public static ArrayList<Account> getAccounts(){
        return accounts;
    }

    public static void addAccount(String accountType){
        Account account = new Account(accountType);
        accounts.add(account);
    }
}
