public class Pelanggan {
    private String nama;
    private String nomorPelanggan;
    private Buku[] bukuPinjaman = new Buku[3];
    private int jumlahTerpinjam;
    
    public Pelanggan(String nama, String nomorPelanggan) {
        this.nama = nama;
        this.nomorPelanggan = nomorPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public void setNomorPelanggan(String nomorPelanggan) {
        this.nomorPelanggan = nomorPelanggan;
    }

    void tambahBuku(Buku bukuPinjam) {
        if (jumlahTerpinjam < 3){
            bukuPinjaman[jumlahTerpinjam] = bukuPinjam;
            jumlahTerpinjam++;
        } else {
            // System.out.println("Buku terpinjam sudah maksimal!");
        }
    }

    void tampilkanInfoPelanggan() {
        System.out.println("Nama\t\t\t: " + nama);
        System.out.println("Nomor Pelanggan\t\t: " + nomorPelanggan);
        System.out.println("Buku yang Dipinjam\t:");
        for (int i = 0; i < jumlahTerpinjam; i++) {
            System.out.println((i+1) + ". " + bukuPinjaman[i].getJudul());
        }
        if (bukuPinjaman[0]==null){
            System.out.println("Tidak ada");
        }
    }

    public int getJumlahTerpinjam() {
        return jumlahTerpinjam;
    }

    public void setJumlahTerpinjam(int jumlahTerpinjam) {
        this.jumlahTerpinjam = jumlahTerpinjam;
    }
}