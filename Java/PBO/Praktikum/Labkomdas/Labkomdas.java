package Java.PBO.Praktikum.Labkomdas;

public class Labkomdas {
    private final double hargaJaketA = 100000.0
    private final double hargaJaketB = 125000.0
    private final double hargaJaketC = 175000.0
    

    static double getHarga(int jenisJaket) {
        switch (jenisJaket) {
            case 1: return hargaJaketA;
            case 2: return hargaJaketB;
            case 3: return hargaJaketC;
            default: return 0.0;
        }
    }
}
