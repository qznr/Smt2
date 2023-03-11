package PetShop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import PetShop.Customer.*;
import PetShop.Karyawan.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Boolean[] layanan = new Boolean[2];
    static ArrayList <Hewan> daftarCustomer = new ArrayList<Hewan>();
    static ArrayList <Karyawan> daftarKaryawan = new ArrayList<Karyawan>();
    static DecimalFormat decimalFormat = new DecimalFormat("###,###.00");

    static void inputInvalid(){
        System.out.println("Tolong berikan input yang valid!"); in.nextLine();
    }

    // static void inputKaryawan(String jenis){
    //     System.out.print("Nama\t\t: "); String nama = in.nextLine();
    //     System.out.print("Alamat\t\t: "); String alamat = in.nextLine();
    //     System.out.print("Telepon\t\t: "); String telepon = in.nextLine();
    //     System.out.print("Jenis Kelamin\t: "); String jenisKelamin = in.nextLine();
    //     int gaji = 0;
    //     try {
    //         System.out.print("Gaji\t\t: "); gaji = in.nextInt(); in.nextLine();
    //     } catch (Exception e) {
    //         inputInvalid();
    //         inputKaryawan(jenis);
    //     }
    //     switch (jenis){
    //         case "Admin":
    //             int menangani = 0;
    //             try {
    //                 System.out.print("Terlayani\t: "); menangani = in.nextInt();
    //             } catch (Exception e) {
    //                 inputInvalid();
    //                 inputKaryawan(jenis);
    //                 break;
    //             }
    //             Karyawan admin = new Admin(nama,alamat,telepon,jenisKelamin,jenis,gaji,menangani);
    //             daftarKaryawan.add(admin);
    //             break;
    //         case "Dokter Hewan":
    //             float biayaPeriksa = 0;
    //             try {
    //                 System.out.print("Biaya Periksa\t: "); biayaPeriksa = in.nextFloat();
    //             } catch (Exception e) {
    //                 inputInvalid();
    //                 inputKaryawan(jenis);
    //                 break;
    //             }
    //             Karyawan dokterHewan = new DokterHewan(nama,alamat,telepon,jenisKelamin,jenis,gaji,biayaPeriksa);
    //             daftarKaryawan.add(dokterHewan);
    //             break;
    //         case "Groomer":
    //             float biayaPerawatan = 0;
    //             try {
    //                 System.out.print("Biaya Perawatan\t:"); biayaPerawatan = in.nextFloat();
    //             } catch (Exception e) {
    //                 inputInvalid();
    //                 inputKaryawan(jenis);
    //                 break;
    //             }
    //             Karyawan groomer = new Groomer(nama,alamat,telepon,jenisKelamin,jenis,gaji,biayaPerawatan);
    //             daftarKaryawan.add(groomer);
    //             break;
    //     }
    // }

    static void inputKaryawan(String jenis){
        try {
            System.out.print("Nama\t\t: "); String nama = in.nextLine();
            System.out.print("Alamat\t\t: "); String alamat = in.nextLine();
            System.out.print("Telepon\t\t: "); String telepon = in.nextLine();
            System.out.print("Jenis Kelamin\t: "); String jenisKelamin = in.nextLine();
            int gaji = 0;
            System.out.print("Gaji\t\t: "); gaji = in.nextInt(); in.nextLine();
            switch (jenis){
                case "Admin":
                    int menangani = 0;
                    System.out.print("Terlayani\t: "); menangani = in.nextInt();
                    Karyawan admin = new Admin(nama,alamat,telepon,jenisKelamin,jenis,gaji,menangani);
                    daftarKaryawan.add(admin);
                    break;
                case "Dokter Hewan":
                    float biayaPeriksa = 0;
                    System.out.print("Biaya Periksa\t: "); biayaPeriksa = in.nextFloat();
                    Karyawan dokterHewan = new DokterHewan(nama,alamat,telepon,jenisKelamin,jenis,gaji,biayaPeriksa);
                    daftarKaryawan.add(dokterHewan);
                    break;
                case "Groomer":
                    float biayaPerawatan = 0;
                    System.out.print("Biaya Perawatan\t: "); biayaPerawatan = in.nextFloat();
                    Karyawan groomer = new Groomer(nama,alamat,telepon,jenisKelamin,jenis,gaji,biayaPerawatan);
                    daftarKaryawan.add(groomer);
                    break;
            }
        } catch (Exception e) {
            inputInvalid();
            inputKaryawan(jenis);
        }
        
    }

    static void inputHewan(String jenis){
        try {
            System.out.print("No\t\t: "); String noPelanggan = in.nextLine();
            System.out.print("Nama Hewan\t: "); String namaHewan = in.nextLine();
            System.out.print("Warna Hewan\t: "); String warnaHewan = in.nextLine();
            int tahunKelahiran = 0;
            System.out.print("Tahun Kelahiran\t: "); tahunKelahiran = in.nextInt(); in.nextLine();
                
            
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
                case "Kelinci":
                    System.out.print("Ras\t\t: "); String rasKelinci = in.nextLine();
                    Hewan kelinci = new Kelinci(noPelanggan,namaHewan,warnaHewan,tahunKelahiran,jenis,rasKelinci);
                    daftarCustomer.add(kelinci);
                    break;
            }
        } catch (Exception e) {
            inputInvalid();
            inputHewan(jenis);
        }
    }

    static void output(String jenis){
        switch (jenis){
            case "Admin":
                for (int i=0;i<daftarKaryawan.size();i++){
                    if (daftarKaryawan.get(i) instanceof Admin){
                        daftarKaryawan.get(i).print();
                        System.out.printf("Terlayani\t= %d\n\n",((Admin)daftarKaryawan.get(i)).getTerlayani());
                    }
                }
                break;
            case "Dokter Hewan":
                for (int i=0;i<daftarKaryawan.size();i++){
                    if (daftarKaryawan.get(i) instanceof DokterHewan){
                        daftarKaryawan.get(i).print();
                        float biaya = ((DokterHewan)daftarKaryawan.get(i)).getBiayaPeriksa();
                        System.out.printf("Biaya Periksa\t= %s\n\n",decimalFormat.format(biaya));
                    }
                }
                break;
            case "Groomer":
                for (int i=0;i<daftarKaryawan.size();i++){
                    if (daftarKaryawan.get(i) instanceof Groomer){
                        daftarKaryawan.get(i).print();
                        float biaya = ((Groomer)daftarKaryawan.get(i)).getBiayaPerawatan();
                        System.out.printf("Biaya Perawatan\t= Rp.%s\n\n",decimalFormat.format(biaya));
                    }
                }
                break;
            case "Anjing":
                for(int i=0;i<daftarCustomer.size();i++){
                    if(daftarCustomer.get(i) instanceof Anjing){
                        daftarCustomer.get(i).cetakDataHewan();
                        String ras = ((Anjing)daftarCustomer.get(i)).getRasAnjing();
                        System.out.printf("Ras\t\t= %s\n\n",ras);
                    }
                }
                break;
            case "Kucing":
                for(int i=0;i<daftarCustomer.size();i++){
                    if(daftarCustomer.get(i) instanceof Kucing){
                        daftarCustomer.get(i).cetakDataHewan();
                        String ras = ((Kucing)daftarCustomer.get(i)).getRasKucing();
                        System.out.printf("Ras\t\t= %s\n\n",ras);
                    }
                }
                break;
            case "Kelinci":
                for(int i=0;i<daftarCustomer.size();i++){
                    if(daftarCustomer.get(i) instanceof Kelinci){
                        daftarCustomer.get(i).cetakDataHewan();
                        String ras = ((Kelinci)daftarCustomer.get(i)).getRasKelinci();
                        System.out.printf("Ras\t\t= %s\n\n",ras);
                    }
                }
                break;
        }
    }

    static void inputAtauOutput(String jenis, String mode){
        System.out.println("1. Input\n2. Output\n0. Back");
        System.out.print("Pilihan anda : ");
        int pilihanMode = in.nextInt();
        in.nextLine();
        if (pilihanMode==1){
            if (mode.equals("Karyawan")) inputKaryawan(jenis);
            if (mode.equals("Hewan")) inputHewan(jenis);
        } else if (pilihanMode==2){
            output(jenis);
        } else if (pilihanMode==0){
            pilihKaryawan();
        } else {
            inputInvalid();
            inputAtauOutput(jenis, mode);
        }
    }

    static void pilihKaryawan(){
        System.out.println("1. Admin\n2. Dokter Hewan\n3. Groomer\n0. Back");
        System.out.print("Pilihan anda : ");
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
            case 0:
                ui();
                break;
            default:
                System.out.println("Tolong berikan input yang valid!");
                pilihKaryawan();
        }
    }

    static void speciesHewan(){
        System.out.println("1. Anjing\n2. Kucing\n3. Kelinci\n0. Back");
        System.out.print("Pilihan anda : ");
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
            case 0:
                ui();
                break;
            default:
                System.out.println("Tolong berikan input yang valid!");
                pilihHewan();
        }
    }

    static void pilihHewan(){
        System.out.println("1. Kelola Hewan\n2. Proses Layanan\n0. Back");
        System.out.print("Pilihan Anda : ");
        int pilihanMode = in.nextInt();
        switch (pilihanMode){
            case 1:
                speciesHewan();
                break;
            case 2:
                layanan();
                break;
            case 0:
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
            System.out.printf("%d. %s hewan %s\n",i+1,namaHewan,speciesHewan);
        }
    }

    static void listDokter(){
        for (int i=0;i<daftarKaryawan.size();i++){
            if (daftarKaryawan.get(i) instanceof DokterHewan){
                DokterHewan dokterHewan = (DokterHewan)daftarKaryawan.get(i);
                String namaDokter = dokterHewan.getNama();
                float biayaPeriksa = dokterHewan.getBiayaPeriksa();
                System.out.printf("%d. Dokter %s Biaya Rp.%s\n",i+1,namaDokter,decimalFormat.format(biayaPeriksa));
            }
        }
    }

    static void listGroomer(){
        for (int i=0;i<daftarKaryawan.size();i++){
            if (daftarKaryawan.get(i) instanceof Groomer){
                Groomer groomer = (Groomer)daftarKaryawan.get(i);
                String namaGroomer = groomer.getNama();
                float biayaMerawat = groomer.getBiayaPerawatan();
                System.out.printf("%d. Groomer %s Biaya %s\n",i+1,namaGroomer,decimalFormat.format(biayaMerawat));
            }
        }
    }

    static void listAdmin(){
        for (int i=0;i<daftarKaryawan.size();i++){
            if (daftarKaryawan.get(i) instanceof Admin){
                String namaAdmin = daftarKaryawan.get(i).getNama();
                System.out.printf("%d. Admin %s\n",i+1,namaAdmin);
            }
        }
    }

    static Hewan ambilHewan(){
        System.out.print("Pilihan Anda : ");
        int pilihHewan = 0;
        try {
            pilihHewan = in.nextInt();
        } catch (Exception e) {
            inputInvalid();
            return ambilHewan();
        }
        if (pilihHewan>daftarCustomer.size()){
            inputInvalid();
            return ambilHewan();
        }
        return daftarCustomer.get(pilihHewan-1);
    }
    

    static Karyawan ambilDokter(){
        System.out.print("Pilihan Anda : ");
        int pilihDokter = 0;
        try {
            pilihDokter = in.nextInt();
        } catch (Exception e) {
            inputInvalid();
            return ambilDokter();
        }
        return daftarKaryawan.get(pilihDokter-1);
    }

    static Karyawan ambilGroomer(){
        System.out.print("Pilihan Anda : ");
        int pilihGroomer = 0;
        try {
            pilihGroomer = in.nextInt();
        } catch (Exception e) {
            inputInvalid();
            return ambilGroomer();
        }
        return daftarKaryawan.get(pilihGroomer-1);
    }

    static Karyawan ambilAdmin(){
        System.out.print("Pilihan Anda : ");
        int pilihAdmin = 0;
        try {
            pilihAdmin = in.nextInt();
        } catch (Exception e) {
            inputInvalid();
            return ambilAdmin();
        }
        return daftarKaryawan.get(pilihAdmin-1);
    }

    static void layanan(){
        System.out.println("Layanan :\n1. Periksa\n2. Perawatan\n3. Proses\n0. Back");
        System.out.print("Pilihan Anda : ");
        int pilihanMode = in.nextInt();
        switch (pilihanMode){
            case 1:
                if (layanan[0]){
                    layanan[0]=false;
                    System.out.println("Tidak Jadi Periksa");
                } else {
                    layanan[0]=true;
                    System.out.println("Terpilih Periksa");
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
                Admin admin = new Admin();
                // Admin admin = (Admin) ambilAdmin();
                try {
                    admin = (Admin) ambilAdmin();
                } catch (Exception e) {
                    inputInvalid();
                    layanan();
                }
                float tagihanPeriksa = 0;
                float tagihanMerawat = 0;
                float biayaPeriksa = 0;
                float biayaMerawat = 0;
                if (layanan[0]){
                    listDokter();
                    DokterHewan dokter = new DokterHewan();
                    try {
                        dokter = (DokterHewan) ambilDokter();
                    } catch (Exception e) {
                        inputInvalid();
                        layanan();
                    }
                    tagihanPeriksa = dokter.periksa(hewanTerpilih);
                    biayaPeriksa = dokter.getBiayaPeriksa();
                } 
                if (layanan[1]){
                    listGroomer();
                    Groomer groomer = new Groomer();
                    try {
                        groomer = (Groomer) ambilGroomer();
                    } catch (Exception e) {
                        inputInvalid();
                        layanan();
                    }
                    tagihanMerawat = groomer.merawat(hewanTerpilih);
                    biayaMerawat = groomer.getBiayaPerawatan();
                }
                layanan[0] = false;
                layanan[1] = false;
                admin.cetakTagihan(hewanTerpilih,tagihanPeriksa,tagihanMerawat,biayaPeriksa,biayaMerawat);
                break;
            case 0:
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
        System.out.println("1. Karyawan\n2. Customer (Hewan)\n9. Exit");
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
            case 9:
                System.out.println("Menghentikan Program...");
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
        Karyawan groomerHadi = new Groomer("Hadi","Jakarta","0808","L","Groomer",0,200000);
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