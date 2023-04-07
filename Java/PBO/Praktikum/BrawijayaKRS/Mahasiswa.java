package Praktikum.BrawijayaKRS;

public class Mahasiswa extends CivitasAkademik{
    private String nim;
    private String ukt;
    
    public Mahasiswa(String nama, String prodi, String fakultas, String alamat, String nim, String ukt){
        super(nama, prodi, fakultas, alamat);
        this.nim = nim;
        this.ukt = ukt;
    }

    public void tampilkanData() {
        System.out.println("Nama: " + getNama());
        System.out.println("Program Studi: " + getProdi());
        System.out.println("Fakultas: " + getFakultas());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("NIM: " + nim);
        System.out.println("UKT: " + ukt);
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getUkt() {
        return ukt;
    }

    public void setUkt(String ukt) {
        this.ukt = ukt;
    }
}
