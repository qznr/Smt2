package Praktikum.TinySwalayan;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        Customer customer = new Customer();
        UI.displayMenu();
        int choice = UI.getChoice();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    customer.register();
                    do {
                        UI.displayMenu();
                        choice = UI.getChoice();
                    } while (choice < 0 || choice > 2);
                    continue;
                case 2:
                    String[] loginDetails = UI.getLoginDetails();
                    // Implementasi login di sini
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    do {
                        UI.displayMenu();
                        choice = UI.getChoice();
                    } while (choice < 0 || choice > 2);
                    continue;
            }
            UI.displayMenu();
            choice = UI.getChoice();
        }
        System.out.println("Terima kasih telah menggunakan Tiny Swalayan!");
    }
}
