public class Buku {
    private String judul;
    private String penulis;
    private int jumlah;
    
    public Buku(String judul, String penulis, int jumlah) {
        this.judul = judul;
        this.penulis = penulis;
        this.jumlah = jumlah;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getpenulis() {
        return penulis;
    }

    public void setpenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    void tampilkanInfoBuku(){
        System.out.println("Judul Buku\t: " + judul);
        System.out.println("Penulis\t\t: " + penulis);
        System.out.println("Jumlah\t\t: " + jumlah);
    }
}