package PetShop.Customer;

public class Hewan {
    private String noPelanggan;
    private String namaHewan;
    private String warnaHewan;
    private int tahunKelahiran;
    private String speciesHewan;

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

    public String getNamaHewan(){
        return this.namaHewan;
    }

    public String getSpeciesHewan(){
        return this.speciesHewan;
    }

    public void cetakDataHewan(){
        System.out.println("No\t\t= " + noPelanggan);
        System.out.println("Nama\t\t= " + namaHewan);
        System.out.println("Warna\t\t= " + warnaHewan);
        System.out.println("Kelahiran\t= " + tahunKelahiran);
        System.out.println("Hewan\t\t= " + speciesHewan);
    }

}
