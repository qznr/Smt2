public class Pegawai {
    private String nama;
    private String nomorPegawai;

    public Pegawai(String nama, String nomorPegawai) {
        this.nama = nama;
        this.nomorPegawai = nomorPegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorPegawai() {
        return nomorPegawai;
    }

    public void setNomorPegawai(String nomorPegawai) {
        this.nomorPegawai = nomorPegawai;
    }

    void tampilkanInfoPegawai(){
        System.out.println("Nama\t\t: " + nama);
        System.out.println("Nomor Pegawai\t: " + nomorPegawai);
    }

    void menambahPelanggan(String nama, String nomorPelanggan){
        boolean sudahAda = false;
        for (int i = 0; i < Perpustakaan.jumlahPelanggan; i++) {
            if (Perpustakaan.listPelanggan[i].getNama().equals(nama)){
                sudahAda = true;
                break;
            }
        }
        if (!sudahAda){
            int jumlahPelanggan = Perpustakaan.jumlahPelanggan;
            Perpustakaan.listPelanggan[jumlahPelanggan] = new Pelanggan(nama, nomorPelanggan);
            Perpustakaan.jumlahPelanggan++;
        }
    }

    void menambahBuku(String judul, String penulis, int jumlah){
        boolean sudahAda = false;
        for (int i = 0; i < Perpustakaan.jumlahBuku; i++) {
            if (Perpustakaan.listBuku[i].getJudul().equals(judul)){
                Buku buku = Perpustakaan.listBuku[i];
                sudahAda = true;
                buku.setJumlah(buku.getJumlah()+jumlah);
            }
        }
        if (!sudahAda){
            int jumlahBuku = Perpustakaan.jumlahBuku;
            Perpustakaan.listBuku[jumlahBuku] = new Buku(judul, penulis, jumlah);
            Perpustakaan.jumlahBuku++;
        }
    }
}