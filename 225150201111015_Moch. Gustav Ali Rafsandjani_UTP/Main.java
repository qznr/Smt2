public class Main {
    public static void main(String[] args) {
        Pegawai pegawaiPerpus = new Pegawai("Gustav", "225150201111015");
        Perpustakaan perpus = new Perpustakaan(pegawaiPerpus);

        /* 
        Validation test bang

        pegawaiPerpus.menambahBuku("Tutorial Java", "Graita", 2);
        pegawaiPerpus.menambahBuku("Tutorial Phyton", "Safir", 2);
        pegawaiPerpus.menambahBuku("Tutorial Javascript", "Bagus", 2);
        pegawaiPerpus.menambahBuku("Tutorial Golang", "Budi", 2);
        pegawaiPerpus.menambahBuku("Tutorial Javascript", "Shinta", 2);
        
        pegawaiPerpus.menambahPelanggan("Wildan", "1");
        pegawaiPerpus.menambahPelanggan("Machsun", "2");
        pegawaiPerpus.menambahPelanggan("Adin", "3");
        pegawaiPerpus.menambahPelanggan("Machsun", "4");
        
        perpus.pinjam("Wildan", "Tutorial Java");
        perpus.pinjam("Machsun", "Tutorial Java");
        perpus.pinjam("Adin", "Tutorial Java");
        perpus.pinjam("Adin", "Tutorial Phyton");
        perpus.pinjam("Wildan", "Tutorial Golang");
        perpus.pinjam("Wildan", "Tutorial Javascript");
        perpus.pinjam("Wildan", "Tutorial Phyton");
        perpus.pinjam("Cantika", "Tutorial Golang");
        perpus.pinjam("Machsun", "Sastra Inggris");
        perpus.pinjam("Adin", "Tutorial Phyton");
        perpus.pinjam("Cantika", "Cara cepat belajar Phyton");
        */

        // Skenario 1

        // pegawaiPerpus.menambahPelanggan("Hayasaka", "99001110009");
        // pegawaiPerpus.menambahPelanggan("Miyuki", "99001100008");
        // pegawaiPerpus.menambahPelanggan("Kei", "990011110077");

        // pegawaiPerpus.menambahBuku("Heavens", "Tiancan", 3);
        // pegawaiPerpus.menambahBuku("Kaguya-sama", "Akasaka", 3);
        // pegawaiPerpus.menambahBuku("Solo Leveling", "Chugong", 1);
        
        // perpus.pinjam("Hayasaka", "Overlord");
        // perpus.pinjam("Miyuki", "Solo Leveling");
        // perpus.pinjam("Kei", "Solo Leveling");
        // perpus.pinjam("Hayasaka", "Kaguya-sama");

        // pegawaiPerpus.menambahBuku("Overlord", "Maruyama", 3);
        // pegawaiPerpus.menambahBuku("Kaguya-sama", "Akasaka", 3);
        // pegawaiPerpus.menambahBuku("Solo Leveling", "Chugong", 1);

        // perpus.pinjam("Kei", "Heavens");
        // perpus.pinjam("Miyuki", "Solo Leveling");
        // perpus.pinjam("Kei", "Kaguya-sama");

        // pegawaiPerpus.menambahPelanggan("Shinomiya", "2");
        // pegawaiPerpus.menambahPelanggan("Miyuki", "1");

        // perpus.pinjam("Shinomiya", "Solo Leveling");
        // perpus.pinjam("Shirogane", "Kaguya-sama");

        //Skenario 2

        pegawaiPerpus.menambahBuku("Java", "Graita", 5);
        pegawaiPerpus.menambahBuku("Phyton", "Safir", 20);
        pegawaiPerpus.menambahBuku("Javascript", "Machsun", 2);
        pegawaiPerpus.menambahBuku("Javascript", "Machsun", 5);
        pegawaiPerpus.menambahBuku("Cara menjadi Kaya 7 turunan", "Nabila Kol", 10);
        pegawaiPerpus.menambahBuku("Seni Berkayu", "Hashiram Senju", 10);
        pegawaiPerpus.menambahBuku("Attack On Titan 139", "Eren Iyega", 10);
        pegawaiPerpus.menambahBuku("Panduan Bermain Genshin Impact", "Cantika", 3);
        pegawaiPerpus.menambahBuku("Cara membuat toko online", "Pak Kalapak", 5);
        pegawaiPerpus.menambahBuku("Golang", "Cantika", 2);

        pegawaiPerpus.menambahPelanggan("Dilluc", "1");
        pegawaiPerpus.menambahPelanggan("Armin", "2");
        pegawaiPerpus.menambahPelanggan("Pak Steve", "3");
        
        perpus.pinjam("Dilluc", "Golang");
        perpus.pinjam("Dilluc", "Golang");
        perpus.pinjam("Pak Steve", "Panduan Bermain Genshin Impact");
        perpus.pinjam("Pak Steve", "Phyton");
        perpus.pinjam("Armin", "Panduan Bermain Genshin Impact");
        perpus.pinjam("Armin", "Javascript");
        perpus.pinjam("Armin", "Golang");
        perpus.pinjam("Dilluc", "Panduan Bermain Genshin Impact");
        perpus.pinjam("Armin", "Golang");
        perpus.pinjam("Pak Steve", "Golang");
        perpus.pinjam("Pak Steve", "Cara membuat toko online");

        perpus.tampilkanInfoPerpustakaan();
    }
}
