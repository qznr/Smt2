import java.util.Scanner;

public class KartuRencanaMahasiswa {
    private Scanner in = new Scanner(System.in);
    private int jumlah = in.nextInt();
    private String[] mataKuliah = new String[jumlah];

    void tambahMataKuliah(){
        in.nextLine();
        for (int i = 0; i < this.mataKuliah.length; i++) {
            this.mataKuliah[i] = in.nextLine();
        }
    }
    void print(){
        if(this.jumlah>5){
            System.out.println("\nError : KRS sudah penuh\nDaftar Mata Kuliah:");
            for (int i = 0; i < 5; i++) {
                System.out.println(this.mataKuliah[i]);
            }
        } else{
            System.out.println("\nDaftar Mata Kuliah:");
            for (int i = 0; i < this.mataKuliah.length; i++) {
                System.out.println(this.mataKuliah[i]);
            }
        }
    }
    public static void main(String[] args) {
        KartuRencanaMahasiswa Mhs1 = new KartuRencanaMahasiswa();
        Mhs1.tambahMataKuliah();
        Mhs1.print();
        KartuRencanaMahasiswa Mhs2 = new KartuRencanaMahasiswa();
        Mhs2.tambahMataKuliah();
        Mhs2.print();
    }
}