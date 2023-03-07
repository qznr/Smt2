import java.util.ArrayList;
import java.util.Scanner;

public class Perpustakaan {
    private String kategori;
    private String judul;
    private String[] penulis;

    Perpustakaan(String kategori, String judul, String[] penulis){
        this.kategori = kategori;
        this.judul = judul;
        this.penulis = penulis;
    }

    public void print(){
        System.out.printf("Kategori = %s\nJudul = %s\n",kategori, judul);
        System.out.println("Penulis : ");
        for (int i = 0; i < penulis.length; i++) {
            System.out.printf("%d. %s\n",i+1,penulis[i]);
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int jumlahKategori = in.nextInt();
        ArrayList<Perpustakaan> perpus = new ArrayList<Perpustakaan>();
        for (int i = 0; i < jumlahKategori; i++) {
            String kategori = in.next();
            int jumlahBuku = in.nextInt(); in.nextLine();
            for (int j = 0; j < jumlahBuku; j++) {
                String judul = in.nextLine();
                String penulis = in.nextLine();
                String[] listPenulis = penulis.split("_");
                Perpustakaan buku = new Perpustakaan(kategori, judul, listPenulis);
                perpus.add(buku);
            }
        }
        for (int i = 0; i < perpus.size(); i++) {
            perpus.get(i).print();
        }
    }
}