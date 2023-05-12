package Praktikum.Labkomdas;

public class MenuCheckOut extends Labkomdas {
    public MenuCheckOut() {
        super("Check Out");
    }

    @Override
    public void display() {
        System.out.println("===== " + getTitle() + " =====");
        if (jumlahJaket[0] > 0) {
            if (jumlahJaket[0] >= 100 ) {
                System.out.println("Jaket A : " + jumlahJaket[0] + " x " + df.format(hargaJaketA-5000) + "\t" + df.format(harga[0]));
            } else {
                System.out.println("Jaket A : " + jumlahJaket[0] + " x " + df.format(hargaJaketA) + "\t" + df.format(harga[0]));
            }
        }

        if (jumlahJaket[1] > 0) {
            if (jumlahJaket[1] >= 100 ) {
                System.out.println("Jaket B : " + jumlahJaket[1] + " x " + df.format(hargaJaketB-5000) + "\t" + df.format(harga[1]));
            } else {
                System.out.println("Jaket B : " + jumlahJaket[1] + " x " + df.format(hargaJaketB) + "\t" + df.format(harga[1]));
            }
        }

        if (jumlahJaket[2] > 0) {
            if (jumlahJaket[2] >= 100 ) {
                System.out.println("Jaket C : " + jumlahJaket[2] + " x " + df.format(hargaJaketC-15000) + "\t" + df.format(harga[2]));
            } else {
                System.out.println("Jaket C : " + jumlahJaket[2] + " x " + df.format(hargaJaketC) + "\t" + df.format(harga[2]));
            }
        }
        System.out.println("==========================");
        System.out.println("Total\t: " + df.format(totalHarga));
        System.out.println();
    }

    @Override
    public void execute() {
        kalkulasi();
        display();
    }
}
