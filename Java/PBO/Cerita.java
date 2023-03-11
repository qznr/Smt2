import java.util.Scanner;

public class Cerita {
    private String sinopsis;
    private double harga;

    public Cerita(){
    }

    public Cerita(String sinopsis, int jumlahKata, int harga){
        this.sinopsis = sinopsis.toLowerCase();
        this.harga = harga;
    }

    public String getSinopsis(){
        return sinopsis;
    }

    public String getHarga(){
        String stringHarga =  
    }

    public void perbaikiSinopsis(){
        String[] kalimat = sinopsis.split("(?<=[.!?:])\\s");
        sinopsis = "";
        for (String s : kalimat){
            if (!s.isEmpty()){
                sinopsis += Character.toUpperCase(s.charAt(0)) + s.substring(1);
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
    }
}