package Maret;
public class Pegawai {
    public String nama;
    public double gaji;

    public Pegawai(){
    }

    public Pegawai(String nama, double gaji){
        this.nama = nama;
        this.gaji = gaji;
    }

    public void print(){
        System.out.println("Nama : " + nama);
        System.out.println("Gaji : " + gaji);
    }
    
}

