package Praktikum.TinySwalayan;

public class Main {

    public static void main(String[] args) {
        int choice;
        do {
            UI.displayMenu();
            choice = UI.getChoice();
            switch (choice) {
                case 1:
                    Customer.register();
                    break;
                case 2:
                Account customerAccount = Customer.login();
                if (customerAccount!=null) {
                    int customerChoise;
                    do {
                        UI.displayCustomerMenu();
                        customerChoise = UI.getChoice();
                        switch(customerChoise){
                            case 1:
                                String[] details = customerAccount.getCustomer().getCustomerDetails();
                                System.out.println("\nID Akun\t\t: " + details[0]);
                                System.out.println("Tipe Akun\t: " + details[1]);
                                System.out.println("Saldo Akun\t: " + details[2]);
                                System.out.println("Nama\t\t: " + details[3] + "\n");
                                break;
                            case 9:
                                break;
                        }
                    } while (customerChoise!=9);
                    
                } else {
                    System.out.println("Login gagal!");
                    // perform actions after unsuccessful login
                }
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