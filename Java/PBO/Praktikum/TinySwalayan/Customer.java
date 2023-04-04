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
            System.out.println("PIN yang dimasukkan tidak sama.");
            details = UI.getRegistrationDetails();
        }
        while (balance<10000){
            System.out.println("Deposit awal kurang dari Rp.10.000");
            details = UI.getRegistrationDetails();
            balance = Double.parseDouble(details[4]);
        }
        Customer customer = new Customer(details[0], details[1]);
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
            Customer customer = account.getCustomer();
            boolean isBlocked = customer.getIsBlocked();
            if (isBlocked) {
                System.out.println("Akun Anda telah diblokir!");
                return null;
            }
            customer.addAttemptCount();
            String pin = customer.getPin();
            int attemptCount = customer.getAttemptCount();
            String customerName = customer.getCustomerName();
            if (account.getAccountID().equals(details[0]) && !pin.equals(details[1])) {
                if (attemptCount > 2) {
                    customer.setIsBlocked(true);
                    System.out.println("Anda memasukkan PIN salah 3 kali. Akun anda telah terblokir.");
                    return null;
                } else {
                    System.out.println("PIN salah. Tolong ulangi lagi.");
                }
            } else {
                customer.resetAttemptCount();
                System.out.println("\nLogin berhasil!");
                System.out.println("Selamat datang, " + customerName + "!");
                return account;
            }
        }
    }    

    public void logout() {
        System.out.println("Selamat tinggal " + account.getCustomer().getCustomerName() + "!");
    }
    
    public void changeName(String name) {
        String prevName = customerName;
        this.customerName = name;
        System.out.println("Nama anda sebelumnya\t\t: " + prevName);
        System.out.println("Nama anda telah diganti menjadi\t: " + this.customerName);
    }
    
    public void deposit(double amount) {
        account.addBalance(amount);
    }
    
    public void withdraw(double amount) {
        account.addBalance(-amount);
    }
    
    public String[] getCustomerDetails(Account account){
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

    public static void addCustomer(String[] details, Double balance){
        Customer customer = new Customer(details[0], details[1]);
        customer.setAccount(details[3],customer,balance);
        Account.addAccount(details[3], customer, balance);
    }

    public static void addCustomer(String namaCustomer, String pin, String accountType, Double balance){
        Customer customer = new Customer(namaCustomer, pin);
        customer.setAccount(accountType,customer,balance);
        Account.addAccount(accountType, customer, balance);
    }

    public void resetAttemptCount(){
        this.attemptCount = 0;
    }

    public void setAccount(String tipeAkun, Customer customer, Double balance){
        this.account = new Account(tipeAkun, customer, balance);
    }

    public void setIsBlocked(boolean isBlocked){
        this.isBlocked = isBlocked;
    }
}