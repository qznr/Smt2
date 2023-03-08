package PetShop.Customer;

public class Kucing extends Hewan{
    private String rasKucing;
    
    public Kucing(){
    }

    public Kucing(String noPelanggan, String namaHewan, String warnaHewan, int tahunKelahiran, String speciesHewan, String rasKucing){
        super(noPelanggan,namaHewan,warnaHewan,tahunKelahiran,speciesHewan);
        this.rasKucing = rasKucing;
    }

    public String getRasKucing(){
        return rasKucing;
    }
}
