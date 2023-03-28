package Praktikum.PetShop.Customer;

public class Kelinci extends Hewan{
    private String rasKelinci;

    public Kelinci(){
    }

    public Kelinci(String noPelanggan, String namaHewan, String warnaHewan, int tahunKelahiran, String speciesHewan, String rasKelinci){
        super(noPelanggan,namaHewan,warnaHewan,tahunKelahiran,speciesHewan);
        this.rasKelinci = rasKelinci;
    }

    public String getRasKelinci(){
        return rasKelinci;
    }
}
