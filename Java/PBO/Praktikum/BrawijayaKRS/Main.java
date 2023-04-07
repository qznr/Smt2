package Praktikum.BrawijayaKRS;

public class Main {
    public static void main(String[] args) {
        Dosen d1 = new Dosen("Indriati","TIF","FILKOM","LOREM IPSUM", "123", "Rp. 10.000.000,00");
        Dosen d2 = new Dosen("Budi","TIF","FILKOM","LOREM IPSUM", "234", "Rp. 10.000.000,00");
        KRS krsKel = new KRS();
        MataKuliah m1 = new MataKuliah("CIF62002","SISOP",4,d1);
        MataKuliah m2 = new MataKuliah("CIF62004","ASD",4,d1);
        MataKuliah m3 = new MataKuliah("CIF62006","STP",3,d2);
        MataKuliah m4 = new MataKuliah("CIF62003","PBO",5,d2);
        krsKel.setMhs(new Mahasiswa("Moch. Gustav Ali Rafsandjani","TIF","FILKOM","Nganjuk", "225150201111015", "Rp. 0,00"));
        krsKel.tambahMatkul(m1);
        krsKel.tambahMatkul(m2);
        krsKel.tambahMatkul(m3);
        krsKel.tambahMatkul(m4);
        krsKel.tampilKRS();
    }
}
