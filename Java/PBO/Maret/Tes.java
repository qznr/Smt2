package Maret;

public class Tes {
    public static void main(String[] args) {
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

    }
}
