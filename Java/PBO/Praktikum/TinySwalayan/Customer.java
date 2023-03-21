package Praktikum.TinySwalayan;


public class Customer {
    private String customerName;
    private String pin;
    private int attemptCount;
    private boolean isBlocked;
    
    public Customer(String customerName, String pin) {
        this.customerName = customerName;
        this.pin = pin;
        this.attemptCount = 0;
        this.isBlocked = false;
    }
    
    public void register() {
        String[] details = UI.getRegistrationDetails();
        while (!details[1].equals(details[2])) {
            System.out.println("PIN yang dimasukkan tidak sama.");
            details = UI.getRegistrationDetails();
        }
        this.customerName = details[0];
        this.pin = details[1];
        this.attemptCount = 0;
        this.isBlocked = false;
        Account.addAccount(details[3]);
        System.out.println("Pendaftaran berhasil.");
        System.out.println("ID pelanggan anda adalah " + Account.getAccounts().get(Account.getAccounts().size() - 1).getAccountID() + ".");
        System.out.println("Silahkan login untuk menggunakan layanan kami.");
    }
    
    public boolean login() {
        String[] details = UI.getRegistrationDetails();
        if (isBlocked) {
            System.out.println("Akun Anda telah diblokir!");
            return false;
        }
        Account account = findAccount(details[0]);
        if (account == null){
            System.out.println("Akun tidak ditemukan!\n");
            login();
        } else if (account.getAccountID().equals(details[0]) && !pin.equals(details[1])) {
            attemptCount++;
            if (attemptCount == 3) {
                isBlocked = true;
                System.out.println("Anda memasukkan PIN salah 3 kali. Akun anda telah terblokir.");
                return false;
            } else {
                System.out.println("PIN salah. Tolong ulangi lagi.");
                login();
            }
        }
        attemptCount = 0;
        System.out.println("Selamat datang, " + customerName + "!");
        return true;
    }

    public Account findAccount(String id){
        for (Account account : Account.getAccounts()){
            if(account.getAccountID().equals(id)){
                return account;
            }
        }
        return null;
    }
    
    public void logout() {
        // TODO: Implement logout logic
    }
    
    public void changeName(String name) {
        this.customerName = name;
        System.out.println("Your name has been changed to " + this.customerName);
    }
    
    public void deposit(double amount) {
        // TODO: Implement deposit logic
    }
    
    public void withdraw(double amount) {
        // TODO: Implement withdrawal logic
    }
}
