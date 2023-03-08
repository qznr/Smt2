package PetShop;

import java.util.ArrayList;
import java.util.Scanner;
import PetShop.Customer.*;
import PetShop.Karyawan.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Boolean[] layanan = new Boolean[2];
    static ArrayList <Hewan> daftarCustomer = new ArrayList<Hewan>();
    static ArrayList <Karyawan> daftarKaryawan = new ArrayList<Karyawan>();

    static void inputKaryawan(String jenis){
        System.out.print("Nama\t\t: "); String nama = in.nextLine();
        System.out.print("Alamat\t\t: "); String alamat = in.nextLine();
        System.out.print("Telepon\t\t: "); String telepon = in.nextLine();
        System.out.print("Jenis Kelamin\t\t: "); String jenisKelamin = in.nextLine();
        System.out.println("Gaji\t\t: "); int gaji = in.nextInt(); in.nextLine();
        switch (jenis){
            case "Admin":
            System.out.print("Menangani\t\t: "); int menangani = in.nextInt();
                Karyawan admin = new Admin(nama,alamat,telepon,jenisKelamin,jenis,gaji,menangani);
                daftarKaryawan.add(admin);
                break;
            case "Dokter Hewan":
                System.out.print("Biaya Periksa\t\t: "); float biayaPeriksa = in.nextFloat();
                Karyawan dokterHewan = new DokterHewan(nama,alamat,telepon,jenisKelamin,jenis,gaji,biayaPeriksa);
                daftarKaryawan.add(dokterHewan);
                break;
            case "Groomer":
                System.out.print("Biaya Perawatan\t\t:"); float biayaPerawatan = in.nextFloat();
                Karyawan groomer = new Groomer(nama,alamat,telepon,jenisKelamin,jenis,gaji,biayaPerawatan);
                daftarKaryawan.add(groomer);
                break;
        }
    }

    static void inputHewan(String jenis){
        System.out.print("No\t\t: "); String noPelanggan = in.nextLine();
        System.out.print("Nama Hewan\t\t: "); String namaHewan = in.nextLine();
        System.out.print("Warna Hewan\t\t: "); String warnaHewan = in.nextLine();
        System.out.print("Tahun Kelahiran\t\t: "); int tahunKelahiran = in.nextInt();
        switch (jenis){
            case "Anjing":
                System.out.print("Ras\t\t: "); String rasAnjing = in.nextLine();
                Hewan anjing = new Anjing(noPelanggan,namaHewan,warnaHewan,tahunKelahiran,jenis,rasAnjing);
                daftarCustomer.add(anjing);
                break;
            case "Kucing":
                System.out.print("Ras\t\t: "); String rasKucing = in.nextLine();
                Hewan kucing = new Kucing(noPelanggan,namaHewan,warnaHewan,tahunKelahiran,jenis,rasKucing);
                daftarCustomer.add(kucing);
                break;
            case "Groomer":
                System.out.print("Ras\t\t: "); String rasKelinci = in.nextLine();
                Hewan kelinci = new Kelinci(noPelanggan,namaHewan,warnaHewan,tahunKelahiran,jenis,rasKelinci);
                daftarCustomer.add(kelinci);
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
                        System.out.printf("Biaya Periksa\t\t= %.0f\n\n",biaya);
                    }
                }
                break;
            case "Groomer":
                for (int i=0;i<daftarKaryawan.size();i++){
                    if (daftarKaryawan.get(i) instanceof Groomer){
                        daftarKaryawan.get(i).print();
                        float biaya = ((Groomer)daftarKaryawan.get(i)).getBiayaPerawatan();
                        System.out.printf("Biaya Perawatan\t\t= %.0f\n\n",biaya);
                    }
                }
                break;
            case "Anjing":
                for(int i=0;i<daftarCustomer.size();i++){
                    if(daftarCustomer.get(i) instanceof Anjing){
                        daftarCustomer.get(i).cetakDataHewan();
                        String ras = ((Anjing)daftarCustomer.get(i)).getRasAnjing();
                        System.out.printf("Ras\t\t= %s",ras);
                    }
                }
                break;
            case "Kucing":
                for(int i=0;i<daftarCustomer.size();i++){
                    if(daftarCustomer.get(i) instanceof Kucing){
                        daftarCustomer.get(i).cetakDataHewan();
                        String ras = ((Kucing)daftarCustomer.get(i)).getRasKucing();
                        System.out.printf("Ras\t\t= %s",ras);
                    }
                }
                break;
            case "Kelinci":
                for(int i=0;i<daftarCustomer.size();i++){
                    if(daftarCustomer.get(i) instanceof Kelinci){
                        daftarCustomer.get(i).cetakDataHewan();
                        String ras = ((Kelinci)daftarCustomer.get(i)).getRasKelinci();
                        System.out.printf("Ras\t\t= %s",ras);
                    }
                }
                break;
        }
    }

    static void inputAtauOutput(String jenis, String mode){
        System.out.println("1. Input\n2. Output\n3. Back");
        System.out.println("Pilihan anda : ");
        int pilihanMode = in.nextInt();
        if (pilihanMode==1){
            if (mode.equals("Karyawan")) inputKaryawan(jenis);
            if (mode.equals("Hewan")) inputHewan(jenis);
        } else if (pilihanMode==2){
            output(jenis);
        } else if (pilihanMode==3){
            pilihKaryawan();
        } else {
            System.out.println("Tolong berikan input yang valid!");
            inputAtauOutput(jenis, mode);
        }
    }

    static void pilihKaryawan(){
        System.out.println("1. Admin\n2. Dokter Hewan\n3. Groomer\n4. Back");
        System.out.print("Pilihan anda :");
        int pilihanMode = in.nextInt();
        switch (pilihanMode){
            case 1:
                inputAtauOutput("Admin", "Karyawan");
                break;
            case 2:
                inputAtauOutput("Dokter Hewan","Karyawan");
                break;
            case 3:
                inputAtauOutput("Groomer","Karyawan");
                break;
            case 4:
                ui();
                break;
            default:
                System.out.println("Tolong berikan input yang valid!");
                pilihKaryawan();
        }
    }

    static void speciesHewan(){
        System.out.println("1. Anjing\n2. Kucing\n3. Kelinci\n4. Back");
        System.out.print("Pilihan anda :");
        int pilihanMode = in.nextInt();
        switch (pilihanMode){
            case 1:
                inputAtauOutput("Anjing","Hewan");
                break;
            case 2:
                inputAtauOutput("Kucing","Hewan");
                break;
            case 3:
                inputAtauOutput("Kelinci","Hewan");
                break;
            case 4:
                ui();
                break;
            default:
                System.out.println("Tolong berikan input yang valid!");
                pilihHewan();
        }
    }

    static void pilihHewan(){
        System.out.println("1. Kelola Hewan\n2. Proses Layanan\n3. Back");
        System.out.print("Pilihan Anda : ");
        int pilihanMode = in.nextInt();
        switch (pilihanMode){
            case 1:
                speciesHewan();
                break;
            case 2:
                layanan();
                break;
            case 3:
                ui();
                break;
            default:
                System.out.println("Tolong berikan input yang valid!");
                pilihHewan();
                break;
                
        }
    }

    static void listHewan(){
        for (int i=0;i<daftarCustomer.size();i++){
            String namaHewan = daftarCustomer.get(i).getNamaHewan();
            String speciesHewan = daftarCustomer.get(i).getSpeciesHewan();
            System.out.printf("%d. %s hewan %s",i+1,namaHewan,speciesHewan);
        }
    }

    static void listDokter(){
        for (int i=0;i<daftarKaryawan.size();i++){
            if (daftarKaryawan.get(i) instanceof DokterHewan){
                String namaDokter = daftarKaryawan.get(i).getNama();
                System.out.printf("%d. Dokter %s",i+1,namaDokter);
            }
        }
    }

    static void listGroomer(){
        for (int i=0;i<daftarKaryawan.size();i++){
            if (daftarKaryawan.get(i) instanceof Groomer){
                String namaGroomer = daftarKaryawan.get(i).getNama();
                System.out.printf("%d. Groomer %s",i+1,namaGroomer);
            }
        }
    }

    static void listAdmin(){
        for (int i=0;i<daftarKaryawan.size();i++){
            if (daftarKaryawan.get(i) instanceof Admin){
                String namaAdmin = daftarKaryawan.get(i).getNama();
                System.out.printf("%d. Admin %s",i+1,namaAdmin);
            }
        }
    }

    static Hewan ambilHewan(){
        System.out.print("Pilihan Anda : ");
        int pilihHewan = in.nextInt();
        return daftarCustomer.get(pilihHewan-1);
    }

    static Karyawan ambilDokter(){
        System.out.print("Pilihan Anda : ");
        int pilihDokter = in.nextInt();
        return daftarKaryawan.get(pilihDokter-1);
    }

    static Karyawan ambilGroomer(){
        System.out.print("Pilihan Anda : ");
        int pilihGroomer = in.nextInt();
        return daftarKaryawan.get(pilihGroomer-1);
    }

    static Karyawan ambilAdmin(){
        System.out.print("Pilihan Anda : ");
        int pilihAdmin = in.nextInt();
        return daftarKaryawan.get(pilihAdmin-1);
    }

    static void layanan(){
        System.out.println("Layanan :\n1. Periksa\n2. Perawatan\n3. Proses\n4. Back");
        System.out.print("Pilihan Anda : ");
        int pilihanMode = in.nextInt();
        switch (pilihanMode){
            case 1:
                if (layanan[0]){
                    layanan[0]=false;
                    System.out.println("Tidak Jadi Periksa");
                } else {
                    layanan[0]=true;
                    System.out.println("Terpilih Perawatan");
                }
                layanan();
                break;
            case 2:
                if (layanan[1]){
                    layanan[1]=false;
                    System.out.println("Tidak Jadi Perawatan");
                } else {
                    layanan[1]=true;
                    System.out.println("Terpilih Perawatan");
                }
                layanan();
                break;
            case 3:
                listHewan();
                Hewan hewanTerpilih  = ambilHewan();
                listAdmin();
                Admin admin = (Admin) ambilAdmin();
                float biayaPeriksa = 0;
                float biayaMerawat = 0;
                if (layanan[0]){
                    listDokter();
                    DokterHewan dokter = (DokterHewan) ambilDokter();
                    biayaPeriksa = dokter.periksa(hewanTerpilih);
                } else if (layanan[1]){
                    listGroomer();
                    Groomer groomer = (Groomer) ambilGroomer();
                    biayaMerawat = groomer.merawat(hewanTerpilih);
                }
                admin.cetakTagihan(hewanTerpilih,biayaPeriksa,biayaMerawat);
                break;
            case 4:
                pilihHewan();
                break;
            default:
                System.out.println("Tolong berikan input yang valid!");
                layanan();
                break;
        }
    }

    static void ui(){
        System.out.println("\nInterface Admin :");
        System.out.println("1. Karyawan\n2. Customer (Hewan)\n3. Exit");
        System.out.print("Pilihan anda : ");
        int pilihanMode = in.nextInt();
        switch (pilihanMode){
            case 1:
                pilihKaryawan();
                ui();
                break;
            case 2:
                pilihHewan();
                ui();
                break;
            case 3:
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
        Karyawan adminFarel = new Admin("Farel","Rembang","0808","L","Admin",9999999,0);
        Karyawan groomerHadi = new DokterHewan("Hadi","Jakarta","0808","L","Groomer",0,200000);
        Hewan anjingJaved = new Anjing("001","Javed","Hitam",0,"Anjing","Anjing Jahannam");
        daftarKaryawan.add(dokterGustav);
        daftarKaryawan.add(dokterApriliano);
        daftarKaryawan.add(adminFarel);
        daftarKaryawan.add(groomerHadi);
        daftarCustomer.add(anjingJaved);
        layanan[0]=false;
        layanan[1]=false;
        ui();
    }
}