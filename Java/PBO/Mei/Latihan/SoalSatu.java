package Java.PBO.Mei.Latihan;

public class SoalSatu {
    public static void main(String[] args) {
        String text = "Saya belajar bahasa Java. Java adalah salah satu bahasa pemrograman. Belajar Java sangat mudah apabila rajin berlatih. Belajar bahasa JAVA dilakukan seminggu dua kali.";
        int jumlahJava = hitungJumlahKata(text, "Java");
        int jumlahBahasa = hitungJumlahKata(text, "bahasa");
        int jumlahBelajar = hitungJumlahKata(text, "belajar");
    
        System.out.println("Jumlah kata 'Java': " + jumlahJava);
        System.out.println("Jumlah kata 'bahasa': " + jumlahBahasa);
        System.out.println("Jumlah kata 'belajar': " + jumlahBelajar);
    }

    public static int hitungJumlahKata(String teks, String kata) {
        String[] kataArray = teks.split("\\W+"); // Memisahkan kata-kata dengan karakter non-alfanumerik
        int jumlah = 0;
        for (String k : kataArray) {
            if (k.equalsIgnoreCase(kata)) {
                jumlah++;
            }
        }
        return jumlah;
    }
}
