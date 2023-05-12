package Praktikum.Labkomdas;

public class Labkomdas extends Menu {
    protected final double hargaJaketA = 100000.0;
    protected final double hargaJaketB = 125000.0;
    protected final double hargaJaketC = 175000.0;
    static protected double[] jumlahJaket = new double[3];
    static protected double[] harga = new double[3];
    static protected double totalHarga;

    public Labkomdas(String title) {
        super(title);
    }

    @Override
    public void display() {
    }

    @Override
    public void execute() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.execute();
    }

    public void kalkulasi() {
        if (jumlahJaket[0] >= 100) {
            harga[0] = Kalkulator.perkalian(hargaJaketA, jumlahJaket[0]) - Kalkulator.perkalian(5000, jumlahJaket[0]);
            totalHarga += Kalkulator.perkalian(hargaJaketA, jumlahJaket[0]) - Kalkulator.perkalian(5000, jumlahJaket[0]);
        } else {
            harga[0] = Kalkulator.perkalian(hargaJaketA, jumlahJaket[0]);
            totalHarga += Kalkulator.perkalian(hargaJaketA, jumlahJaket[0]);
        }

        if (jumlahJaket[1] >= 100) {
            harga[1] = Kalkulator.perkalian(hargaJaketB, jumlahJaket[1]) - Kalkulator.perkalian(5000, jumlahJaket[1]);
            totalHarga += Kalkulator.perkalian(hargaJaketB, jumlahJaket[1]) - Kalkulator.perkalian(5000, jumlahJaket[1]);
        } else {
            harga[1] = Kalkulator.perkalian(hargaJaketB, jumlahJaket[1]);
            totalHarga += Kalkulator.perkalian(hargaJaketB, jumlahJaket[1]);
        }

        if (jumlahJaket[2] >= 100) {
            harga[2] = Kalkulator.perkalian(hargaJaketC, jumlahJaket[2]) - Kalkulator.perkalian(15000, jumlahJaket[2]);
            totalHarga += Kalkulator.perkalian(hargaJaketC, jumlahJaket[2]) - Kalkulator.perkalian(15000, jumlahJaket[2]);
        } else {
            harga[2] = Kalkulator.perkalian(hargaJaketC, jumlahJaket[2]);
            totalHarga += Kalkulator.perkalian(hargaJaketC, jumlahJaket[2]);
        }
    }
}