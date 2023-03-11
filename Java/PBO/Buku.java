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
        // ArrayList<Buku> kumpulanBuku = new ArrayList<Buku>();
        int jumlahBuku = in.nextInt(); in.nextLine();
        Buku[] kumpulanBuku = new Buku[jumlahBuku];
        double[] penjualan = new double[jumlahBuku];
        double[] persentase = new double[jumlahBuku];
        for (int i = 0; i < jumlahBuku; i++) {
            String sinopsis = in.nextLine();
            double harga = in.nextDouble(); in.nextLine();
            String input = in.nextLine();
            String[] params = input.split(" ");
            penjualan[i]  = Double.parseDouble(params[0]);
            persentase[i] = 0;
            if (params.length > 1) {
                persentase[i] = Double.parseDouble(params[1]);
            }
            kumpulanBuku[i] = new Buku(sinopsis, harga);
        }
        for (int i = 0; i < kumpulanBuku.length; i++) {
            Buku buku = kumpulanBuku[i];
            buku.perbaikiSinopsis();
            System.out.printf("\nBuku %d : \n",i+1);
            System.out.printf("Sinopsis\t: %s\n",buku.getSinopsis());
            System.out.printf("Jumlah Kata\t: %d\n",buku.jumlahKata());
            System.out.printf("Harga\t\t: Rp.%s\n",buku.getHarga());
            System.out.printf("Terjual\t\t: %.0f Unit\n",penjualan[i]);
            if (persentase[i]!=0){
                System.out.printf("Royalti %.0f%%\t: Rp.%s\n",persentase[i],buku.jumlahRoyalti(penjualan[i],persentase[i]));
            } else {
                System.out.printf("Royalti 10%%\t: Rp.%s\n",buku.jumlahRoyalti(penjualan[i]));
            }
        }
        System.out.println();
    }
}