package Praktikum.BrawijayaKRS;

public class Dosen extends CivitasAkademik{
    private String nidn;
    private String gaji;

    public Dosen(String nama, String prodi, String fakultas, String alamat, String nidn, String gaji) {
        super(nama, prodi, fakultas, alamat);
        this.nidn = nidn;
        this.gaji = gaji;
    }

    public void tampilkanData() {
        System.out.println("Data Dosen");
        System.out.println("Nama: " + getNama());
        System.out.println("Prodi: " + getProdi());
        System.out.println("Fakultas: " + getFakultas());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("NIDN: " + nidn);
        System.out.println("Gaji: " + gaji);
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    

    
}
