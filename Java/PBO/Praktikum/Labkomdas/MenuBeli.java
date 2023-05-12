package Praktikum.Labkomdas;

public class MenuBeli extends Labkomdas {
    BeliJaketA beliJaketA;
    BeliJaketB beliJaketB;
    BeliJaketC beliJaketC;

    public MenuBeli() {
        super("Beli Barang");
        beliJaketA = new BeliJaketA();
        beliJaketB = new BeliJaketB();
        beliJaketC = new BeliJaketC();
        addChild(beliJaketA);
        addChild(beliJaketB);
        addChild(beliJaketC);
    }
    
    @Override
    public void display() {
        System.out.println("===== " + getTitle() + " =====");
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
        System.out.println();
        System.out.println("1. Beli Jaket A");
        System.out.println("2. Beli Jaket B");
        System.out.println("3. Beli Jaket C");
        System.out.println("4. Back");
    }

    @Override
    public void execute() {
        int pilihan = 0;
        while (pilihan != 4) {
            display();
            pilihan = getUserInput();
            if (pilihan > 0 && pilihan < 4) getChild(pilihan-1).execute();
        }
    }

    private class BeliJaketA extends Labkomdas {
        BeliJaketA() {
            super("Jaket A");
        }

        @Override
        public void display() {
            System.out.println("===== " + getTitle() + " =====");
            System.out.println("Jumlah Jaket A: " + jumlahJaket[0]);
            System.out.println("1. Tambah");
            System.out.println("2. Kurang");
            System.out.println("3. Back");
        }

        @Override
        public void execute() {
            int pilihan = 0;
            while (pilihan != 3) {
                display();
                pilihan = getUserInput();
                switch (pilihan) {
                    case 1:
                        jumlahJaket[0] += getDoubleInput("Tambah : ");
                        break;
                    case 2:
                        double kurang = getDoubleInput("Kurang : ");
                        if (jumlahJaket[0] - kurang < 0) {
                            System.out.println("Input tidak valid");
                            break;
                        }
                        jumlahJaket[0] -= kurang;
                        break;
                }
            }
        }
    }

    private class BeliJaketB extends Labkomdas {
        BeliJaketB() {
            super("Jaket B");
        }

        @Override
        public void display() {
            System.out.println("===== " + getTitle() + " =====");
            System.out.println("Jumlah Jaket B: " + jumlahJaket[1]);
            System.out.println("1. Tambah");
            System.out.println("2. Kurang");
            System.out.println("3. Back");
        }

        @Override
        public void execute() {
            int pilihan = 0;
            while (pilihan != 3) {
                display();
                pilihan = getUserInput();
                switch (pilihan) {
                    case 1:
                        jumlahJaket[1] += getDoubleInput("Tambah : ");
                        break;
                    case 2:
                        double kurang = getDoubleInput("Kurang : ");
                        if (jumlahJaket[1] - kurang < 0) {
                            System.out.println("Input tidak valid");
                            break;
                        }
                        jumlahJaket[1] -= kurang;
                        break;
                }
            }
        }
    }

    private class BeliJaketC extends Labkomdas {
        BeliJaketC() {
            super("Jaket C");
        }

        @Override
        public void display() {
            System.out.println("===== " + getTitle() + " =====");
            System.out.println("Jumlah Jaket C: " + jumlahJaket[2]);
            System.out.println("1. Tambah");
            System.out.println("2. Kurang");
            System.out.println("3. Back");
        }

        @Override
        public void execute() {
            int pilihan = 0;
            while (pilihan != 3) {
                display();
                pilihan = getUserInput();
                switch (pilihan) {
                    case 1:
                        jumlahJaket[2] += getDoubleInput("Tambah : ");
                        break;
                    case 2:
                        double kurang = getDoubleInput("Kurang : ");
                        if (jumlahJaket[2] - kurang < 0) {
                            System.out.println("Input tidak valid");
                            break;
                        }
                        jumlahJaket[2] -= kurang;
                        break;
                }
            }
        }
    }
}