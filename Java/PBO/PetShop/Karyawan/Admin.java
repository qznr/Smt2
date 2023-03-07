package PetShop.Karyawan;

import PetShop.Customer.Hewan;

public class Admin extends Karyawan{
    
    public Admin(){
    }

    public Admin(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji){
        super(nama,alamat,telepon,jenisKelamin,kategoriKaryawan, gaji);
    }

    public Karyawan inputDataKaryawan(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji){
        Karyawan karyawan = new Karyawan(nama,alamat,telepon,jenisKelamin,kategoriKaryawan,gaji);
        return karyawan;
    }

    public Hewan inputDataHewan(String noPelanggan, String namaHewan, String warnaHewan, int tahunKelahiran, String speciesHewan){
        Hewan hewan = new Hewan(noPelanggan,namaHewan,warnaHewan,tahunKelahiran,speciesHewan);
        return hewan;
    }

    public void cetakTagihan(Hewan hewan){
        hewan.cetakDataHewan();
    }
}