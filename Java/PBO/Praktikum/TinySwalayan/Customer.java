package Praktikum.TinySwalayan;
import java.text.DecimalFormat;

public class Customer {
    private String customerName;
    private String pin;
    private int attemptCount;
    private boolean isBlocked;
    private Account account;
    private DecimalFormat df = new DecimalFormat("###,###.00");

    public Customer(){
    }
    
    public Customer(String customerName, String pin) {
        this.customerName = customerName;
        this.pin = pin;
        this.attemptCount = 0;
        this.isBlocked = false;
    }
    
    public static void register() {
        String[] details = UI.getRegistrationDetails();
        Double balance = Double.parseDouble(details[4]);
        while (!details[1].equals(details[2])) {
            System.out.println("PIN yang dimasukkan tidak sama.\n");
            details = UI.getRegistrationDetails();
        }
        while (balance<10000){
            System.out.println("Deposit awal kurang dari Rp.10.000\n");
            details = UI.getRegistrationDetails();
        }
        Customer customer = new Customer(details[0], details[1]);
        // account = new Account(details[3], customer, balance);
        customer.setAccount(details[3],customer,balance);
        Account.addAccount(details[3], customer, balance);
        System.out.println("Pendaftaran berhasil.");
        System.out.println("ID pelanggan anda adalah " + Account.getAccounts().get(Account.getAccounts().size() - 1).getAccountID() + ".");
        System.out.println("Silahkan login untuk menggunakan layanan kami.\n");
    }
    
    public static Account login() {
        String[] details;
        while (true) {
            details = UI.getLoginDetails();
            Account account = Account.findAccount(details[0]);
            if (account == null) {
                System.out.println("Akun tidak ditemukan!\n");
                return null;
            }
            boolean isBlocked = account.getCustomer().getIsBlocked();
            String pin = account.getCustomer().getPin();
            int attemptCount = account.getCustomer().getAttemptCount();
            String customerName = account.getCustomer().getCustomerName();
            if (isBlocked) {
                System.out.println("Akun Anda telah diblokir!");
                return null;
            }
            if (account.getAccountID().equals(details[0]) && !pin.equals(details[1])) {
                account.getCustomer().addAttemptCount();
                if (attemptCount == 3) {
                    isBlocked = true;
                    System.out.println("Anda memasukkan PIN salah 3 kali. Akun anda telah terblokir.");
                    return null;
                } else {
                    System.out.println("PIN salah. Tolong ulangi lagi.");
                }
            } else {
                account.getCustomer().resetAttemptCount();
                System.out.println("\nLogin berhasil!");
                System.out.println("Selamat datang, " + customerName + "!");
                return account;
            }
        }
    }
    
    public String[] getCustomerDetails(){
        String[] details = new String[4];
        details[0] = account.getAccountID();
        details[1] = account.getAccountType();
        details[2] = "Rp." + df.format(account.getBalance());
        details[3] = account.getCustomer().getCustomerName();
        return details;
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getPin(){
        return pin;
    }

    public int getAttemptCount(){
        return attemptCount;
    }

    public boolean getIsBlocked(){
        return isBlocked;
    }

    public void addAttemptCount(){
        this.attemptCount++;
    }

    public void resetAttemptCount(){
        this.attemptCount = 0;
    }

    public void setAccount(String tipeAkun, Customer customer, Double balance){
        this.account = new Account(tipeAkun, customer, balance);
    }

    
    
    public void logout() {
        // TODO: Implement logout logic
    }
    
    public void changeName(String name) {
        this.customerName = name;
        System.out.println("Your name has been changed to " + this.customerName);
    }
    
    public void deposit(double amount) {
        account.addBalance(amount);
    }
    
    public void withdraw(double amount) {
        // TODO: Implement withdrawal logic
    }
}