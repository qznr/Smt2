package Praktikum.TinySwalayan;

public class Main {
    
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
                        performTransaction();
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
        String[] details = account.getCustomer().getCustomerDetails();
        System.out.println("\nID Akun\t\t: " + details[0]);
        System.out.println("Tipe Akun\t: " + details[1]);
        System.out.println("Saldo Akun\t: " + details[2]);
        System.out.println("Nama\t\t: " + details[3] + "\n");
    }

    private static void performTransaction() {
        //TODO : implement transaction logic
    }

    private static void depositAmount(Account account) {
        Double depositAmount = UI.getDepositAmount();
        account.getCustomer().deposit(depositAmount);
    }

    private static void withdrawAmount(Account account) {
        Double withdrawAmount = UI.getDepositAmount();
        account.getCustomer().withdraw(withdrawAmount);
    }

    private static void changeCustomerName(Account account) {
        String newName = UI.getNewName();
        account.getCustomer().changeName(newName);
    }

    public static void main(String[] args) {
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
