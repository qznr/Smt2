package Praktikum.Labkomdas;

public class MainMenu extends Labkomdas {
    MenuBeli labkomdasBeli;
    MenuCheckOut labkomdasCheckOut;
    public MainMenu() {
        super("Selamat datang di Labkomdas!");
        labkomdasBeli = new MenuBeli();
        labkomdasCheckOut = new MenuCheckOut();
        addChild(labkomdasBeli);
        addChild(labkomdasCheckOut);
    }

    @Override
    public void display() {
        System.out.println("===== " + getTitle() + " =====");
        System.out.println("List Barang :");
        System.out.println("Jaket A : " + df.format(hargaJaketA));
        System.out.println("Jaket B : " + df.format(hargaJaketB));
        System.out.println("Jaket C : " + df.format(hargaJaketC));
        System.out.println("Keranjang : ");
        if (jumlahJaket[0] == 0 && jumlahJaket[1] == 0 && jumlahJaket[2] == 0) {
            System.out.print("Kosong\n");
        }
        if (jumlahJaket[0] != 0) {
            System.out.println("Jaket A : " + jumlahJaket[0]);
        }
        if (jumlahJaket[1] != 0) {
            System.out.println("Jaket B : " + jumlahJaket[1]);
        }
        if (jumlahJaket[2] != 0) {
            System.out.println("Jaket C : " + jumlahJaket[2]);
        }
        System.out.println("==========================");
        System.out.println("1. Beli Barang");
        System.out.println("2. Check Out");
        System.out.println("9. Exit");
    }

    @Override
    public void execute() {
        int pilihan = 0;
        while (pilihan != 9 && pilihan != 2) {
            display();
            pilihan = getUserInput();
            if (pilihan > 0 && pilihan < 3)
            getChild(pilihan-1).execute();
        }
    }
}