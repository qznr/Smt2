package Praktikum.TinySwalayan;
import java.util.Scanner;
import java.text.DecimalFormat;

public class UI {
    private static Scanner in = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("###,###.00");

    public static void displayMenu() {
        System.out.println("Selamat datang di Tiny Swalayan!");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
    }

    public static int getChoice() {
        System.out.print("Pilihan anda : ");
        int pilihan = in.nextInt(); in.nextLine();
        return pilihan;
    }

    public static String[] getRegistrationDetails() {
        String[] details = new String[5];
        System.out.print("\nMasukkan nama anda: ");
        details[0] = in.nextLine();
        System.out.print("Masukkan PIN: ");
        details[1] = in.nextLine();
        System.out.print("Konfirmasi PIN: ");
        details[2] = in.nextLine();
        displayRegistrationAccountType();
        System.out.print("Pilih jenis akun: ");
        details[3] = in.nextLine();
        System.out.println("Masukkan saldo awal(minimal Rp.10,000) :");
        details[4] = in.nextLine();
        return details;
    }

    public static void displayRegistrationAccountType(){
        System.out.println("Jenis akun :");
        System.out.println("1. Silver");
        System.out.println("2. Gold");
        System.out.println("3. Platinum");
    }

    public static String[] getLoginDetails() {
        String[] details = new String[2];
        System.out.print("Masukkan ID anda : ");
        details[0] = in.nextLine();
        System.out.print("Masukkan PIN anda: ");
        details[1] = in.nextLine();
        return details;
    }

    public static void displayCustomerMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Cek profil");
        System.out.println("2. Beli barang");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Ganti nama");
        System.out.println("6. Ganti pin");
        System.out.println("7. Histori transaksi");
        System.out.println("9. Logout");
    }

    public static void buyUI(Account account) {
        boolean isValid = false;
        do {
            System.out.println("=== Beli Barang ===");
            System.out.println("Silakan pilih barang yang ingin dibeli:");
            System.out.println("1. Smartphone");
            int choice = getChoice();
    
            switch (choice) {
                case 1:
                    displaySmartphoneList();
                    System.out.print("Pilih smartphone [masukkan nomor barang]: ");
                    int smartphoneIndex = in.nextInt() - 1;
                    in.nextLine(); // consume the newline character
                    System.out.print("Jumlah yang ingin dibeli: ");
                    int quantity = in.nextInt();
                    in.nextLine(); // consume the newline character
                    Smartphone smartphoneToBuy = Smartphone.getSmartphones().get(smartphoneIndex);
                    Transaction.buy(account, smartphoneToBuy, quantity);
                    isValid = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (!isValid);
    }
    
    public static void displaySmartphoneList() {
        System.out.println("=== Daftar Smartphone ===");
        System.out.println("No.\tNama Smartphone\t\t\tMerk\t\tQty\tHarga");
        for (int i = 0; i < Smartphone.getSmartphones().size(); i++) {
            Smartphone smartphone = Smartphone.getSmartphones().get(i);
            System.out.printf("%d.\t%-30s\t%s\t\t%d\tRp.%s\n", i + 1, smartphone.getItemName(), smartphone.getBrand(), smartphone.getQuantity(), df.format(smartphone.getPrice()));
        }
    }    

    public static String getNewName() {
        System.out.print("Masukkan nama baru : ");
        return in.nextLine();
    }

    public static double getDepositAmount() {
        System.out.print("Masukkan jumlah yang ingin dideposit: ");
        return in.nextDouble();
    }

    public static double getWithdrawalAmount() {
        System.out.print("Masukkan jumlah yang ingin diwithdraw: ");
        return in.nextDouble();
    }
}