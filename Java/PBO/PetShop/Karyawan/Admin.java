package PetShop.Karyawan;
import PetShop.Customer.Hewan;
import java.text.DecimalFormat;

public class Admin extends Karyawan{
    private int menangani;
    DecimalFormat decimalFormat = new DecimalFormat("###,###.00");

    public Admin(){
    }

    public Admin(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji, int menangani){
        super(nama,alamat,telepon,jenisKelamin,kategoriKaryawan, gaji);
        this.menangani = menangani;
    }

    public Karyawan inputDataKaryawan(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji){
        Karyawan karyawan = new Karyawan(nama,alamat,telepon,jenisKelamin,kategoriKaryawan,gaji);
        return karyawan;
    }

    public Hewan inputDataHewan(String noPelanggan, String namaHewan, String warnaHewan, int tahunKelahiran, String speciesHewan){
        Hewan hewan = new Hewan(noPelanggan,namaHewan,warnaHewan,tahunKelahiran,speciesHewan);
        return hewan;
    }

    public void cetakTagihan(Hewan hewan, float biayaPeriksa, float biayaMerawat){
        this.menangani++;
        hewan.cetakDataHewan();
        System.out.println("==============");
        if (biayaPeriksa!=0){
            System.out.printf("Biaya Periksa\tRp.%s\n",decimalFormat.format(biayaPeriksa));
        }
        if (biayaMerawat!=0){
            System.out.printf("Biaya Merawat\tRp.%s\n",decimalFormat.format(biayaMerawat));
        }
        System.out.printf("Total Biaya\tRp.%s",decimalFormat.format(biayaPeriksa+biayaMerawat));
    }
}