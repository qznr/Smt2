import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Perpustakaan {
    private String kategori;
    private String judul;
    private String penulis;
    private String sinopsis;
    private double harga;
    private DecimalFormat df = new DecimalFormat("###,###.00");

    Perpustakaan(String kategori, String judul, String penulis, String sinopsis, double harga){
        this.kategori = kategori;
        this.judul = judul;
        this.penulis = penulis;
        this.sinopsis = sinopsis;
        this.harga = harga;
    }

    public String getKategori(){
        return kategori;
    }

    public String getJudul(){
        return judul;
    }

    public String getPenulis(){
        return penulis;
    }

    public String getSinopsis(){
        return sinopsis;
    }

    public String getHarga(){
        String stringHarga = df.format(harga);
        return stringHarga;
    }

    public void listPenulis(){
        String[] listPenulis = penulis.split("_");
        penulis = "";
        for (int i = 0; i < listPenulis.length; i++) {
            penulis += (i+1) + ". " + listPenulis[i] + "\n";
        }
    }

    public void perbaikiSinopsis(){
        String[] kalimat = sinopsis.split("(?<=[.!?:])\\s");
        sinopsis = "";
        for (String s : kalimat){
            if (!s.isEmpty()){
                s = s.trim();
                s = s.replaceAll("\\s+"," ");
                sinopsis += Character.toUpperCase(s.charAt(0)) + s.substring(1) + " ";
            }
        }
    }

    public int jumlahKata(){
        String[] kata = sinopsis.split("[ .,!?]+");
        return kata.length;
    }

    public String jumlahRoyalti(double penjualan){
        double royalti = penjualan * harga / 10;
        return df.format(royalti);
    }

    public String jumlahRoyalti(double penjualan, double persentase){
        if (persentase>1) persentase /= 100;
        double royalti = penjualan * harga * persentase;
        return df.format(royalti);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int jumlahKategori = in.nextInt();
        ArrayList<Perpustakaan> perpus = new ArrayList<Perpustakaan>();
        ArrayList<Double> penjualan = new ArrayList<Double>();
        ArrayList<Double> persentase = new ArrayList<Double>();
        for (int i = 0; i < jumlahKategori; i++) {
            String kategori = in.next();
            int jumlahBuku = in.nextInt(); in.nextLine();
            for (int j = 0; j < jumlahBuku; j++) {
                String judul = in.nextLine();
                String listPenulis = in.nextLine();
                String sinopsis = in.nextLine();
                double harga = in.nextDouble(); in.nextLine();
                String input = in.nextLine();
                String[] parameters = input.split(" ");
                penjualan.add(Double.parseDouble(parameters[0]));
                persentase.add(0.0);
                if (parameters.length > 1) {
                    persentase.set(persentase.size() - 1, Double.parseDouble(parameters[1]));
                }
                Perpustakaan buku = new Perpustakaan(kategori, judul, listPenulis, sinopsis, harga);
                perpus.add(buku);
            }
        }
        for (int i = 0; i < perpus.size(); i++) {
            Perpustakaan buku = perpus.get(i);
            buku.listPenulis();
            buku.perbaikiSinopsis();
            System.out.printf("\nBuku %d : \n",i+1);
            System.out.printf("Kategori\t: %s\nJudul\t\t: %s\n",buku.getKategori(), buku.getJudul());
            System.out.println("Penulis\t\t: ");
            System.out.print(buku.getPenulis());
            System.out.printf("Sinopsis\t: %s\n",buku.getSinopsis());
            System.out.printf("Jumlah Kata\t: %d\n",buku.jumlahKata());
            System.out.printf("Harga\t\t: Rp.%s\n",buku.getHarga());
            System.out.printf("Terjual\t\t: %.0f Unit\n",penjualan.get(i));
            if (persentase.get(i)!=0){
                System.out.printf("Royalti %.0f%%\t: Rp.%s\n",persentase.get(i),buku.jumlahRoyalti(penjualan.get(i),persentase.get(i)));
            } else {
                System.out.printf("Royalti 10%%\t: Rp.%s\n",buku.jumlahRoyalti(penjualan.get(i)));
            }
        }
        in.close();
    }
}