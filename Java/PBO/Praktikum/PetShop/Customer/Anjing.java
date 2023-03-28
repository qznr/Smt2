package Praktikum.PetShop.Customer;

public class Anjing extends Hewan{
    private String rasAnjing;

    public Anjing(){
    }

    public Anjing(String noPelanggan, String namaHewan, String warnaHewan, int tahunKelahiran, String speciesHewan, String rasAnjing){
        super(noPelanggan,namaHewan,warnaHewan,tahunKelahiran,speciesHewan);
        this.rasAnjing = rasAnjing;
    }

    public String getRasAnjing(){
        return rasAnjing;
    }
}
