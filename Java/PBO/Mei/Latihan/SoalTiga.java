package Java.PBO.Mei.Latihan;
import java.util.Calendar;

public class SoalTiga {
    public static void main(String[] args) {
        // Mengatur tanggal dan waktu pertama
        Calendar tanggalPertama = Calendar.getInstance();
        tanggalPertama.set(Calendar.YEAR, 2023);
        tanggalPertama.set(Calendar.MONTH, Calendar.MAY); // Perhatikan, bulan dimulai dari 0 (Januari) hingga 11 (Desember)
        tanggalPertama.set(Calendar.DAY_OF_MONTH, 23);
        tanggalPertama.set(Calendar.HOUR_OF_DAY, 10);
        tanggalPertama.set(Calendar.MINUTE, 0);
        tanggalPertama.set(Calendar.SECOND, 0);

        // Mengatur tanggal dan waktu kedua
        Calendar tanggalKedua = Calendar.getInstance();
        tanggalKedua.set(Calendar.YEAR, 2023);
        tanggalKedua.set(Calendar.MONTH, Calendar.JUNE);
        tanggalKedua.set(Calendar.DAY_OF_MONTH, 1);
        tanggalKedua.set(Calendar.HOUR_OF_DAY, 12);
        tanggalKedua.set(Calendar.MINUTE, 0);
        tanggalKedua.set(Calendar.SECOND, 0);

        // Menghitung selisih waktu dalam milidetik
        long selisihMilidetik = tanggalKedua.getTimeInMillis() - tanggalPertama.getTimeInMillis();

        // Mengonversi selisih waktu dari milidetik ke jam
        long selisihJam = selisihMilidetik / (60 * 60 * 1000);
        long selisihMenit = selisihMilidetik / (60 * 1000);

        // Menampilkan selisih waktu
        System.out.println("Selisih waktu antara " + tanggalPertama.getTime() + " dan " + tanggalKedua.getTime() + " adalah " + selisihMenit + " menit atau " + selisihJam + " jam.");
    }
}
