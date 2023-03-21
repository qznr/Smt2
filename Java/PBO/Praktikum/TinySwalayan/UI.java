package Praktikum.TinySwalayan;
import java.util.Scanner;

public class UI {
    private static Scanner in = new Scanner(System.in);

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
        String[] details = new String[4];
        System.out.print("Masukkan nama anda: ");
        details[0] = in.nextLine();
        System.out.print("Masukkan PIN: ");
        details[1] = in.nextLine();
        System.out.print("Konfirmasi PIN: ");
        details[2] = in.nextLine();
        displayRegistrationAccountType();
        System.out.print("Pilih jenis akun: ");
        details[3] = in.nextLine();
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
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Beli barang");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Ganti nama");
        System.out.println("9. Logout");
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
