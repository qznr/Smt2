package Praktikum.PetShop.Karyawan;

import Praktikum.PetShop.Customer.Anjing;
import Praktikum.PetShop.Customer.Hewan;
import Praktikum.PetShop.Customer.Kelinci;
import Praktikum.PetShop.Customer.Kucing;

public class Groomer extends Karyawan{
    private float biayaPerawatan;
    private float tagihanPerawatan;

    public Groomer(){
    } 

    public Groomer(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji, float biayaPerawatan){
        super(nama,alamat,telepon,jenisKelamin,kategoriKaryawan,gaji);
        this.biayaPerawatan = biayaPerawatan;
    }

    public float getBiayaPerawatan(){
        return this.biayaPerawatan;
    }

    public float merawat(Hewan hewan){
        // System.out.printf("%s telah dirawat.\nBiaya : Rp.%d.00",hewan.namaHewan,biayaPerawatan);
        float multiplier = 1;
        if (hewan instanceof Anjing) multiplier = 1.5f;
        if (hewan instanceof Kucing) multiplier = 1f;
        if (hewan instanceof Kelinci) multiplier = 2f;
        tagihanPerawatan = biayaPerawatan*multiplier;
        return tagihanPerawatan;
    }
}