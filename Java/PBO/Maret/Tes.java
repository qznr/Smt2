package Maret;

public class Tes {
    public static void main(String[] args) {

        Pegawai tapiManager = new Manager("Keuangan","Bapa Rafael",999999);
        tapiManager.print();
        System.out.println("====================");

        // Polimorfisme hanya bisa memanggil diatasnya
        // Manager tapiPegawai = new Pegawai("Bukan Rafael", 0);
        // tapiPegawai.print();
        // Akan error

        Pegawai pegawai = new Pegawai();
        pegawai.nama = "Pegawai satu";
        pegawai.gaji = 1000000;        
        System.out.printf("Nama : %s\n",pegawai.nama);
        System.out.printf("Gaji : %.1f\n",pegawai.gaji);
        Manager manager = new Manager();
        manager.nama = "Manager satu";
        manager.isiGaji(2000000);
        manager.departemen = "Departemen Kemanusiaan";
        System.out.println("Nama : " + manager.nama);
        System.out.println("Gaji : " + manager.gaji);
        System.out.println("Departemen : " + manager.departemen);

        System.out.println("===================");

        Pegawai stafPegawai[] = new Pegawai[2];
        stafPegawai[0] = new Pegawai("AAA",9999);
        stafPegawai[1] = new Manager("IT","Bukan cepmew",9090909);
        for (int i = 0; i < stafPegawai.length; i++) {
            stafPegawai[i].print();
        }
        // Pegawai stafCampur[] = new Manager[2];
        // stafCampur[0] = new Pegawai("BBB",8888);
        // stafCampur[1] = new Manager("Entertainment","DJ Khaled",9999999);
        // for (int i = 0; i < stafCampur.length; i++) {
        //     stafCampur[i].print();
        // }

    }
}
