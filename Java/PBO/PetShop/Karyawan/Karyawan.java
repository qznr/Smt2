package PetShop.Karyawan;

public class Karyawan {
    private String nama;
    private String alamat;
    private String telepon;
    private String jenisKelamin;
    private String kategoriKaryawan;
    private int gaji;

    public Karyawan(){
    }
    
    public Karyawan(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji){
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.jenisKelamin = jenisKelamin;
        this.kategoriKaryawan = kategoriKaryawan;
        this.gaji = gaji;
    }                              

    public void print(){
        System.out.println("Nama\t\t= " + nama);
        System.out.println("Alamat\t\t= " + alamat);
        System.out.println("Telepon\t\t= " + telepon);
        System.out.println("Jenis Kelamin\t= " + jenisKelamin);
        System.out.println("Kategori\t= " + kategoriKaryawan);
        System.out.println("Gaji\t\t= Rp." + gaji);
    }

    
}
