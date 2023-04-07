package Praktikum.BrawijayaKRS;

public abstract class CivitasAkademik {
    private String nama;
    private String prodi;
    private String fakultas;
    private String alamat;

    public CivitasAkademik(String nama, String prodi, String fakultas, String alamat){
        this.nama = nama;
        this.prodi = prodi;
        this.fakultas = fakultas;
        this.alamat = alamat;
    }

    public abstract void tampilkanData();

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}