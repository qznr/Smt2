package PetShop;

import java.util.ArrayList;
import java.util.Scanner;
import PetShop.Customer.*;
import PetShop.Karyawan.*;

public class Main {
    static ArrayList <Hewan> daftarCustomer = new ArrayList<Hewan>();
    static ArrayList <Karyawan> daftarKaryawan = new ArrayList<Karyawan>();

    static void input(String jenis){
        Scanner in = new Scanner(System.in);
        System.out.print("Nama\t: "); String nama = in.nextLine();
        System.out.print("Alamat\t: "); String alamat = in.nextLine();
        System.out.print("Telepon\t: "); String telepon = in.nextLine();
        System.out.print("Jenis Kelamin\t: "); String jenisKelamin = in.nextLine();
        System.out.println("Gaji\t: "); int gaji = in.nextInt(); in.nextLine();
        switch (jenis){
            case "Admin":
                System.out.println();
                Karyawan admin = new Admin(nama,alamat,telepon,jenisKelamin,jenis,gaji);
                daftarKaryawan.add(admin);
                break;
            case "Dokter Hewan":
                System.out.println("Biaya Periksa\t: "); float biayaPeriksa = in.nextFloat();
                Karyawan dokterHewan = new DokterHewan(nama,alamat,telepon,jenisKelamin,jenis,gaji,biayaPeriksa);
                daftarKaryawan.add(dokterHewan);
                break;
            case "Groomer":
                System.out.println("Biaya Perawatan\t:"); float biayaPerawatan = in.nextFloat();
                Karyawan groomer = new Groomer(nama,alamat,telepon,jenisKelamin,jenis,gaji,biayaPerawatan);
                daftarKaryawan.add(groomer);
                break;
        }
    }

    static void output(String jenis){
        switch (jenis){
            case "Admin":
                for (int i=0;i<daftarKaryawan.size();i++){
                    if (daftarKaryawan.get(i) instanceof Admin){
                        daftarKaryawan.get(i).print();
                    }
                }
                break;
            case "Dokter Hewan":
                for (int i=0;i<daftarKaryawan.size();i++){
                    if (daftarKaryawan.get(i) instanceof DokterHewan){
                        daftarKaryawan.get(i).print();
                        float biaya = ((DokterHewan)daftarKaryawan.get(i)).getBiayaPeriksa();
                        System.out.printf("Biaya Periksa\t= %.0f\n\n",biaya);
                    }
                }
                break;
            case "Groomer":
                for (int i=0;i<daftarKaryawan.size();i++){
                    if (daftarKaryawan.get(i) instanceof Groomer){
                        daftarKaryawan.get(i).print();
                        float biaya = ((Groomer)daftarKaryawan.get(i)).getBiayaPerawatan();
                        System.out.printf("Biaya Perawatan\t= %.0f\n\n",biaya);
                    }
                }
                break;
        }
    }

    static void inputAtauOutput(String jenis){
        Scanner in = new Scanner(System.in);
        System.out.println("1. Input\n2. Output\n3. Back");
        System.out.println("Pilihan anda : ");
        int pilihanMode = in.nextInt();
        if (pilihanMode==1){
            input(jenis);
        } else if (pilihanMode==2){
            output(jenis);
        } else if (pilihanMode==3){
            pilihKaryawan();
        } else {
            System.out.println("Tolong berikan input yang valid!");
            inputAtauOutput(jenis);
        }
    }

    static void pilihKaryawan(){
        Scanner in = new Scanner(System.in);
        System.out.println("1. Admin\n2. Dokter Hewan\n3. Groomer\n4. Back");
        System.out.print("Pilihan anda :");
        int pilihanMode = in.nextInt();
        switch (pilihanMode){
            case 1:
                inputAtauOutput("Admin");
                break;
            case 2:
                inputAtauOutput("Dokter Hewan");
                break;
            case 3:
                inputAtauOutput("Groomer");
                break;
            case 4:
                ui();
                break;
            default:
                System.out.println("Tolong berikan input yang valid!");
                pilihKaryawan();
        }
    }

    static void ui(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nInterface Admin :");
        System.out.println("1. Karyawan\n2. Customer (Hewan)");
        System.out.print("Pilihan anda : ");
        int pilihanMode = in.nextInt();
        switch (pilihanMode){
            case 1:
                pilihKaryawan();
                ui();
                break;
            case 2:
                ui();
                break;
            default:
                System.out.println("Tolong berikan input yang valid!");
                ui();
                break;

        }
    }

    public static void main(String[] args) {
        Karyawan dokterApriliano = new DokterHewan("Apriliano","Solo","0808","L","Dokter Hewan",999999,100000);
        Karyawan dokterGustav = new DokterHewan("Gustav","Nganjuk","0808","L","Dokter Hewan",9999999,150000);
        Karyawan groomerHadi = new Groomer("Hadi","Jakarta","0808","L","Groomer",0,200000);
        daftarKaryawan.add(dokterGustav);
        daftarKaryawan.add(dokterApriliano);
        daftarKaryawan.add(groomerHadi);
        ui();
        // for (int i = 0; i < daftarKaryawan.size(); i++) {
        //     System.out.println(daftarKaryawan.get(i) instanceof DokterHewan);
        // }
    }
}