package PetShop.Customer;

public class Hewan {
    public String noPelanggan;
    public String namaHewan;
    public String warnaHewan;
    public int tahunKelahiran;
    public String speciesHewan;

    public Hewan(){
    }

    public Hewan(String noPelanggan, String namaHewan, String warnaHewan, int tahunKelahiran, String speciesHewan){
        this.noPelanggan = noPelanggan;
        this.namaHewan = namaHewan;
        this.warnaHewan = warnaHewan;
        this.tahunKelahiran = tahunKelahiran;
        this.speciesHewan = speciesHewan;
    }

    // public void makan(){
    //     System.out.printf("%s telah makan.",namaHewan);
    // }

    // public void tidur(){
    //     System.out.printf("%s telah tidur",namaHewan);
    // }

    public void cetakDataHewan(){
        System.out.println(noPelanggan);
        System.out.println(namaHewan);
        System.out.println(warnaHewan);
        System.out.println(tahunKelahiran);
        System.out.println(speciesHewan);
    }

}
