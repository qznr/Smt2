package Praktikum.BrawijayaKRS;

public class KRS {
    Mahasiswa mhs;
    MataKuliah[] matkul = new MataKuliah[12];
    int jumlahSksTerambil;
    int jumlahMatkulTerambil;

    public KRS(){
        for (int i = 0; i < matkul.length; i++) {
            matkul[i] = new MataKuliah();
        }
    }

    public KRS(Mahasiswa mhs) {
        this.mhs = mhs;
    }

    public void tambahMatkul(MataKuliah newMatkul){
        if (jumlahSksTerambil < 24){
            jumlahMatkulTerambil++;
            jumlahSksTerambil += newMatkul.getSks();
            matkul[jumlahMatkulTerambil-1] = newMatkul;
        } else {
            System.out.println("MK " + newMatkul.getNamaMatkul() + " Tidak terambil! SKS telah melebihi 24");
        }
    }

    public void tampilKRS(){
        System.out.println("Kartu Rencana Studi (KRS) Mahasiswa");
        System.out.println("NIM: " + mhs.getNim());
        System.out.println("Nama: " + mhs.getNama());
        System.out.println("Jumlah SKS Terambil: " + jumlahSksTerambil);
        System.out.println("Jumlah Mata Kuliah Terambil: " + jumlahMatkulTerambil);
        System.out.println("Daftar Mata Kuliah Terambil:");
    
        for (int i = 0; i < jumlahMatkulTerambil; i++) {
            Dosen dosen = matkul[i].getDsn();
            System.out.println("Mata Kuliah " + (i+1));
            System.out.println("SKS Mata Kuliah: " + matkul[i].getSks());
            System.out.println("Nama Mata Kuliah: " + matkul[i].getNamaMatkul());
            System.out.println("Kode Mata Kuliah: " + matkul[i].getKodeMatkul());
            System.out.println("Dosen Pengampu: " + dosen.getNama());
        }
    }

    public Mahasiswa getMhs() {
        return mhs;
    }

    public void setMhs(Mahasiswa mhs) {
        this.mhs = mhs;
    }

    public MataKuliah[] getMatkul() {
        return matkul;
    }

    public void setMatkul(MataKuliah[] matkul) {
        this.matkul = matkul;
    }

    public int getJumlahSksTerambil() {
        return jumlahSksTerambil;
    }

    public void setJumlahSksTerambil(int jumlahSksTerambil) {
        this.jumlahSksTerambil = jumlahSksTerambil;
    }

    public int getJumlahMatkulTerambil() {
        return jumlahMatkulTerambil;
    }

    public void setJumlahMatkulTerambil(int jumlahMatkulTerambil) {
        this.jumlahMatkulTerambil = jumlahMatkulTerambil;
    }
}