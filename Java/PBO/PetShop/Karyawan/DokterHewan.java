package PetShop.Karyawan;

import PetShop.Customer.Hewan;
import PetShop.Customer.Kelinci;
import PetShop.Customer.Kucing;
import PetShop.Customer.Anjing;

public class DokterHewan extends Karyawan{
    private float biayaPeriksa;
    private float tagihanPeriksa;

    public DokterHewan(){
    }

    public DokterHewan(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji, float biayaPeriksa){
        super(nama,alamat,telepon,jenisKelamin,kategoriKaryawan,gaji);
        this.biayaPeriksa = biayaPeriksa;
    }

    public float getBiayaPeriksa(){
        return biayaPeriksa;
    }

    public float periksa(Hewan hewan){
        // System.out.printf("%s telah diperiksa.\nBiaya : Rp.%d.00",hewan.namaHewan,biayaPeriksa);
        float multiplier = 1;
        if (hewan instanceof Anjing) multiplier = 1.5f;
        if (hewan instanceof Kucing) multiplier = 1f;
        if (hewan instanceof Kelinci) multiplier = 2f;
        tagihanPeriksa = biayaPeriksa*multiplier;
        return tagihanPeriksa;
    }
}