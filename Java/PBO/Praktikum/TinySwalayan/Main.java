package Praktikum.TinySwalayan;
import java.text.DecimalFormat;

public class Main {
    private static DecimalFormat df = new DecimalFormat("###,###.00");
    private static void registerCustomer() {
        Customer.register();
    }

    private static void loginCustomer() {
        Account customerAccount = Customer.login();
        if (customerAccount != null) {
            int customerChoice;
            do {
                UI.displayCustomerMenu();
                customerChoice = UI.getChoice();
                switch (customerChoice) {
                    case 1:
                        displayAccountDetails(customerAccount);
                        break;
                    case 2:
                        performTransaction(customerAccount);
                        break;
                    case 3:
                        depositAmount(customerAccount);
                        break;
                    case 4:
                        withdrawAmount(customerAccount);
                        break;
                    case 5:
                        changeCustomerName(customerAccount);
                        break;
                    case 6:
                        changeCustomerPin(customerAccount);
                        break;
                    case 7:
                        customerTransactionHistory(customerAccount);
                    case 9:
                        customerAccount.getCustomer().logout();
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                        break;
                }
            } while (customerChoice != 9);

        } else {
            System.out.println("Login gagal!");
        }
    }

    private static void displayAccountDetails(Account account) {
        String[] details = account.getCustomer().getCustomerDetails(account);
        System.out.println("\nID Akun\t\t: " + details[0]);
        System.out.println("Tipe Akun\t: " + details[1]);
        System.out.println("Saldo Akun\t: " + details[2]);
        System.out.println("Nama\t\t: " + details[3] + "\n");
    }

    private static void performTransaction(Account account) {
        UI.buyUI(account);
    }

    private static void depositAmount(Account account) {
        Double depositAmount = UI.getDepositAmount();
        Double prevBalance = account.getBalance();
        account.addBalance(depositAmount);
        System.out.println("Saldo awal\t: Rp." + df.format(prevBalance));
        System.out.println("Saldo akhir\t: Rp." + df.format(account.getBalance()));
    }

    private static void withdrawAmount(Account account) {
        Double withdrawAmount = UI.getWithdrawalAmount();
        Double prevBalance = account.getBalance();
        account.addBalance(-withdrawAmount);
        System.out.println("Saldo awal\t: Rp." + df.format(prevBalance));
        System.out.println("Saldo akhir\t: Rp." + df.format(account.getBalance()));
    }

    private static void changeCustomerName(Account account) {
        String newName = UI.getNewName();
        account.getCustomer().changeName(newName);
    }

    private static void changeCustomerPin(Account account){
        //TODO : Implement change customer pin
        System.out.println("Coming soon!");
    }

    private static void customerTransactionHistory(Account account){
        //TODO : Implement customer transaction history
        System.out.println("Coming soon");
    }

    public static void main(String[] args) {
        Customer.addCustomer("Gustav Platinum", "123", "Platinum", 500000000.0);
        Customer.addCustomer("Gustav Gold", "123", "Gold", 150000000.0);
        Customer.addCustomer("Gustav Silver", "123", "Silver", 1000000.0);
        Items.addSmartphone(new Smartphone("0001", "Samsung Note 69", 15000000, "Smartphone", 20, "Samsung"));
        Items.addSmartphone(new Smartphone("0002", "Oppo Reno ZX", 7500000, "Smartphone", 12, "Oppo"));
        Items.addSmartphone(new Smartphone("0003", "Xiaomi Redmi Bobrok",1000000, "Smartphone", 20, "Xiaomi"));
        int choice;
        do {
            UI.displayMenu();
            choice = UI.getChoice();
            switch (choice) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    loginCustomer();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (choice != 0);
        System.out.println("Terima kasih telah menggunakan Tiny Swalayan!");
    }
}