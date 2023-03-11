import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Buku {
    private String sinopsis;
    private double harga;
    private DecimalFormat df = new DecimalFormat("###,###.00");

    public Buku(){
    }

    public Buku(String sinopsis, double harga){
        this.sinopsis = sinopsis.toLowerCase();
        this.harga = harga;
    }

    public String getSinopsis(){
        return sinopsis;
    }

    public String getHarga(){
        String stringHarga = df.format(harga);
        return stringHarga;
    }

    public void perbaikiSinopsis(){
        String[] kalimat = sinopsis.split("(?<=[.!?:])\\s");
        sinopsis = "";
        for (String s : kalimat){
            if (!s.isEmpty()){
                sinopsis += Character.toUpperCase(s.charAt(0)) + s.substring(1) + " ";
            }
        }
    }

    public int jumlahKata(){
        String[] kata = sinopsis.split("[ .,!?]+");
        return kata.length;
    }

    public double jumlahRoyalti(double penjualan){
        double royalti = penjualan * harga / 10;
        return royalti;
    }

    public double jumlahRoyalti(double penjualan, double persentase){
        if (persentase>1) persentase /= 100;
        double royalti = penjualan * harga * persentase;
        return royalti;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <Buku> kumpulanBuku = new ArrayList<Buku>();
        int jumlahBuku = in.nextInt(); in.nextLine();
        for (int i = 0; i < jumlahBuku; i++) {
            String sinopsis = in.nextLine();
            double harga = in.nextDouble();
            Buku buku = new Buku(sinopsis, harga);
            kumpulanBuku.add(buku);
        }
        for (int i = 0; i < kumpulanBuku.size(); i++) {
            Buku buku = kumpulanBuku.get(i);
            buku.perbaikiSinopsis();
            System.out.printf("Sinopsis\t: %s\n",buku.getSinopsis());
            System.out.printf("Harga\t\t: Rp.%s\n",buku.getHarga());
            System.out.printf("Jumlah Kata\t: %d\n",buku.jumlahKata());
        }

    }
}