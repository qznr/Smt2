import java.util.Scanner;

public class KartuRencanaMahasiswa {
    private Scanner in = new Scanner(System.in);
    private int jumlahMataKuliah;
    private String[] mataKuliah;

    private void tambahMataKuliah(){
        System.out.print("Masukkan jumlah mata kuliah yang ingin diambil : ");
        jumlahMataKuliah = in.nextInt();
        in.nextLine();
        mataKuliah = new String[jumlahMataKuliah];
        System.out.println("Masukkan nama mata kuliah yang ingin diambil : ");
        for (int i = 0; i < mataKuliah.length; i++) {
            mataKuliah[i] = in.nextLine();
        }
    }
    private void print(){
        if(jumlahMataKuliah>5){
            System.out.println("\nError : KRS sudah penuh\nDaftar Mata Kuliah:");
            for (int i = 0; i < 5; i++) {
                System.out.println(mataKuliah[i]);
            }
        } else{
            System.out.println("\nDaftar Mata Kuliah:");
            for (int i = 0; i < mataKuliah.length; i++) {
                System.out.println(mataKuliah[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa yang mau isi krs : ");
        int jumlahMahasiswa = in.nextInt();
        KartuRencanaMahasiswa[] daftarMahasiswa = new KartuRencanaMahasiswa[jumlahMahasiswa];
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.printf("\nData mahasiswa ke-%d : \n",i+1);
            KartuRencanaMahasiswa mahasiswa = new KartuRencanaMahasiswa();
            mahasiswa.tambahMataKuliah();
            daftarMahasiswa[i] = mahasiswa;
        }
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.printf("\nData mahasiswa ke-%d :",i+1);
            daftarMahasiswa[i].print();
        }
    }
}