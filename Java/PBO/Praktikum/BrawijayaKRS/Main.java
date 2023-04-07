package Praktikum.BrawijayaKRS;

public class Main {
    public static void main(String[] args) {
        Dosen d1 = new Dosen("Ir. Primantara Hari Trisnawan, M.Sc.","TIF","FILKOM","LOREM IPSUM", "123", "Rp. 10.000.000,00");
        Dosen d2 = new Dosen("Indriati, S.T., M.Kom.","TIF","FILKOM","LOREM IPSUM", "234", "Rp. 10.000.000,00");
        Dosen d3 = new Dosen("Dr. Eng. Budi Darma Setiawan, S.Kom., M.Cs.","TIF","FILKOM","LOREM IPSUM", "345", "Rp. 10.000.000,00");
        Dosen d4 = new Dosen("Edy Santoso, S.Si., M.Kom.","TIF","FILKOM","LOREM IPSUM", "456", "Rp. 10.000.000,00");
        Dosen d5 = new Dosen("Candra Dewi, S.Kom., M.Sc.","TIF","FILKOM","LOREM IPSUM", "567", "Rp. 10.000.000,00");
        Dosen d6 = new Dosen("Prof. Dr., Drs. Widodo, S.h., M.h.,","TIF","FILKOM","LOREM IPSUM", "678", "Rp. 10.000.000,00");
        Dosen d7 = new Dosen("Harry Soekotjo Dachlan,","TIF","FILKOM","LOREM IPSUM", "789", "Rp. 10.000.000,00");
        KRS krsKel = new KRS();
        MataKuliah m1 = new MataKuliah("CIF62002","Sistem Operasi",4,d1);
        MataKuliah m2 = new MataKuliah("CIF62003","Pemrograman Berbasis Objek",20,d2);
        MataKuliah m3 = new MataKuliah("CIF62004","Algoritma dan Struktur Data",4,d3);
        MataKuliah m4 = new MataKuliah("CIF62005","Aljabar Linear",2,d4);
        MataKuliah m5 = new MataKuliah("CIF62006","Statistika dan Teori Peluang",3,d5);        
        MataKuliah m6 = new MataKuliah("MPK60006","Kewarganegaraan",2,d6);
        MataKuliah m7 = new MataKuliah("UBU60003","Kewirausahaan",2,d7);
        Mahasiswa mhs1 = new Mahasiswa("Moch. Gustav Ali Rafsandjani","TIF","FILKOM","Nganjuk", "225150201111015", "Rp. 0,00");
        Mahasiswa mhs2 = new Mahasiswa("Moch. Gustav Ali Rafsandjani 2","TIF","FILKOM","Nganjuk 2", "225150201111015", "Rp. 0,00");
        krsKel.setMhs(mhs1);
        krsKel.tambahMatkul(m1);
        krsKel.tambahMatkul(m2);
        krsKel.tambahMatkul(m3);
        krsKel.tambahMatkul(m4);
        krsKel.tambahMatkul(m5);
        krsKel.tambahMatkul(m6);
        krsKel.tambahMatkul(m7);
        krsKel.tampilKRS();
        // d1.tampilkanData(); System.out.println();
        // d2.tampilkanData(); System.out.println();
        // d3.tampilkanData(); System.out.println();
        // mhs1.tampilkanData(); System.out.println();
        // mhs2.tampilkanData();
    }
}
