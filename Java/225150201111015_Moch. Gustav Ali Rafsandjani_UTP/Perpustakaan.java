public class Perpustakaan {
    static Buku[] listBuku = new Buku[100];
    public Pegawai pegawaiPerpus;
    static Pelanggan[] listPelanggan = new Pelanggan[20];
    static int jumlahPelanggan;
    static int jumlahBuku;

    Perpustakaan(Pegawai pegawai){
        this.pegawaiPerpus = pegawai;
    }

    void pinjam(String namaPelanggan, String judulBuku){
        Buku buku = cariBuku(judulBuku);
        if (buku!=null){
            Pelanggan pelanggan = cariPelanggan(namaPelanggan);
            if (pelanggan!=null){
                if (buku.getJumlah()>0 && pelanggan.getJumlahTerpinjam()<3){
                    pelanggan.tambahBuku(buku);
                    // System.out.println("Pelanggan : " + pelanggan.getNama());
                    // System.out.println("Buku : " + buku.getJudul() + " Jumlah awal : " + buku.getJumlah());
                    buku.setJumlah(buku.getJumlah()-1);
                    // System.out.println("Jumlah akhir : " + buku.getJumlah());
                    // System.out.println();
                }
            }
        }
    }

    Pelanggan cariPelanggan(String namaPelanggan){
        for (Pelanggan pelanggan : listPelanggan){
            if (pelanggan!=null){
                if (pelanggan.getNama().equals(namaPelanggan)){
                    return pelanggan;
                }
            }
        }
        return null;
    }

    Buku cariBuku(String judulBuku){
        for (Buku buku : listBuku){
            if (buku!=null){
                if (buku.getJudul().equals(judulBuku)){
                    return buku;
                }
            }
        }
        return null;
    }

    void tampilkanInfoPerpustakaan(){
        System.out.println("Informasi Pegawai di Perpustakaan :");
        pegawaiPerpus.tampilkanInfoPegawai();
        System.out.println("==================");
        System.out.println("Daftar Pelanggan di Perpustakaan");
        for (int i = 0; i < jumlahPelanggan; i++) {
            System.out.println("");
            Pelanggan pelanggan = listPelanggan[i];
            pelanggan.tampilkanInfoPelanggan();
        }
        System.out.println("==================");
        System.out.println("Daftar Buku di Perpustakaan");
        for (int i = 0; i < jumlahBuku; i++) {
            System.out.println("");
            Buku buku = listBuku[i];
            buku.tampilkanInfoBuku();
        }
    }
}