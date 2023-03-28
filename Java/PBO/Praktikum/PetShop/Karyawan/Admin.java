package Praktikum.PetShop.Karyawan;
import java.text.DecimalFormat;

import Praktikum.PetShop.Customer.Hewan;

public class Admin extends Karyawan{
    private int terlayani;
    DecimalFormat decimalFormat = new DecimalFormat("###,###.00");

    public Admin(){
    }

    public Admin(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji, int terlayani){
        super(nama,alamat,telepon,jenisKelamin,kategoriKaryawan, gaji);
        this.terlayani = terlayani;
    }

    public int getTerlayani(){
        return this.terlayani;
    }

    public Karyawan inputDataKaryawan(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji){
        Karyawan karyawan = new Karyawan(nama,alamat,telepon,jenisKelamin,kategoriKaryawan,gaji);
        return karyawan;
    }

    public Hewan inputDataHewan(String noPelanggan, String namaHewan, String warnaHewan, int tahunKelahiran, String speciesHewan){
        Hewan hewan = new Hewan(noPelanggan,namaHewan,warnaHewan,tahunKelahiran,speciesHewan);
        return hewan;
    }

    public void cetakTagihan(Hewan hewan, float tagihanPeriksa, float tagihanMerawat, float biayaPeriksa, float biayaMerawat){
        this.terlayani++;
        System.out.printf("\n%16s\n","Resi");
        System.out.println("==============================");
        hewan.cetakDataHewan();
        float tagihanAdmin = 0;
        System.out.println("==============================");
        if (tagihanPeriksa!=0){
            System.out.printf("Biaya Periksa\tRp.%s\n",decimalFormat.format(tagihanPeriksa-biayaPeriksa));
            tagihanAdmin += biayaPeriksa;
        }
        if (tagihanMerawat!=0){
            System.out.printf("Biaya Merawat\tRp.%s\n",decimalFormat.format(tagihanMerawat-biayaMerawat));
            tagihanAdmin += biayaMerawat;
        }
        float totalBiaya = tagihanPeriksa+tagihanMerawat;
        if (tagihanAdmin!=0) System.out.printf("Biaya Admin\tRp.%s\n",decimalFormat.format(tagihanAdmin));
        System.out.printf("Total Biaya\tRp.%s\n",decimalFormat.format(totalBiaya));
    }
}