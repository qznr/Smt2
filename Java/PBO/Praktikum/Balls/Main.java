package Java.PBO.Praktikum.Balls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pemain> timA = new ArrayList<>(
            Arrays.asList(
                new Pemain(1, 168, 50),
                new Pemain(2, 170, 60),
                new Pemain(3, 165, 56),
                new Pemain(4, 168, 55),
                new Pemain(5, 172, 60),
                new Pemain(6, 170, 70),
                new Pemain(7, 169, 66),
                new Pemain(8, 165, 56),
                new Pemain(9, 171, 72),
                new Pemain(10, 166, 56)
            )
        );

        ArrayList<Pemain> timB = new ArrayList<>(
            Arrays.asList(
                new Pemain(1, 170, 66),
                new Pemain(2, 167, 60),
                new Pemain(3, 165, 59),
                new Pemain(4, 166,58),
                new Pemain(5, 168,58),
                new Pemain(6, 175, 71),
                new Pemain(7, 172, 68),
                new Pemain(8, 171, 68),
                new Pemain(9, 168, 65),
                new Pemain(10, 169, 60)
            )
        );

        Map<Integer, Pemain> tinggiMap = new HashMap<>();
        Map<Integer, Pemain> beratMap = new HashMap<>();

        Map<Integer, Pemain> tinggiMapB = new HashMap<>();
        Map<Integer, Pemain> beratMapB = new HashMap<>();

        // Membuat HashMap untuk kesamaan tinggi dan berat
        for (Pemain pemain : timA) {
            tinggiMap.put(pemain.tinggi, pemain);
            beratMap.put(pemain.berat, pemain);
        }

        for (Pemain pemain : timB) {
            tinggiMapB.put(pemain.tinggi, pemain);
            beratMapB.put(pemain.berat, pemain);
        }

        System.out.println("Tinggi badan yang sama:");
        for (Pemain pemain : timB) {
            if (tinggiMap.containsKey(pemain.tinggi)) {
                Pemain pemainTimA = tinggiMap.get(pemain.tinggi);
                System.out.println("Pemain dengan tinggi " + pemain.tinggi +
                        " ditemukan di kedua tim (Tim A Pemain No dan berat : " + pemainTimA.noPemain + ", " + pemainTimA.berat + "kg, Tim B Pemain No dan berat : " + pemain.noPemain + ", " + pemain.berat + "kg)");
            }
        }

        System.out.println("\nBerat badan yang sama:");
        for (Pemain pemain : timB) {
            if (beratMap.containsKey(pemain.berat)) {
                Pemain pemainTimA = beratMap.get(pemain.berat);
                System.out.println("Pemain dengan berat " + pemain.berat +
                        " ditemukan di kedua tim (Tim A Pemain No dan tinggi : " + pemainTimA.noPemain + ", " + pemainTimA.tinggi + "cm, Tim B Pemain No dan tinggi : " + pemain.noPemain + ", " + pemain.tinggi + "cm)");
            }
        }

        System.out.println("\nKomplemen tinggi badan tim A:");
        for (Pemain pemain : timA) {
            if (!tinggiMapB.containsKey(pemain.tinggi)) {
                System.out.println("Pemain dengan tinggi " + pemain.tinggi + " hanya ada di Tim A");
            }
        }

        System.out.println("\nKomplemen berat badan tim A:");
        for (Pemain pemain : timA) {
            if (!beratMapB.containsKey(pemain.berat)) {
                System.out.println("Pemain dengan berat " + pemain.berat + " hanya ada di Tim A");
            }
        }

        System.out.println("\nKomplemen tinggi badan tim B:");
        for (Pemain pemain : timB) {
            if (!tinggiMap.containsKey(pemain.tinggi)) {
                System.out.println("Pemain dengan tinggi " + pemain.tinggi + " hanya ada di Tim B");
            }
        }

        System.out.println("\nKomplemen berat badan tim B:");
        for (Pemain pemain : timB) {
            if (!beratMap.containsKey(pemain.berat)) {
                System.out.println("Pemain dengan berat " + pemain.berat + " hanya ada di Tim B");
            }
        }
        
        // Kategori range tinggi di Tim A
        System.out.println("\nKategori Range Tinggi di Tim A:");
        int minRangeTinggiA = Collections.min(timA, Comparator.comparing((Pemain p) -> p.tinggi)).tinggi;
        int maxRangeTinggiA = Collections.max(timA, Comparator.comparing((Pemain p) -> p.tinggi)).tinggi;
        System.out.println("Tinggi Min: " + minRangeTinggiA + " cm");
        System.out.println("Tinggi Max: " + maxRangeTinggiA + " cm");
        TreeMap<Integer, List<Pemain>> rangeTinggiTimA = new TreeMap<>();
        for (Pemain pemain : timA) {
            int tinggiGroup = pemain.tinggi / 10 * 10; // Mengelompokkan pemain berdasarkan kelipatan 10 tinggi badan
            if (!rangeTinggiTimA.containsKey(tinggiGroup)) {
                rangeTinggiTimA.put(tinggiGroup, new ArrayList<>());
            }
            rangeTinggiTimA.get(tinggiGroup).add(pemain);
        }
        for (Map.Entry<Integer, List<Pemain>> entry : rangeTinggiTimA.entrySet()) {
            int tinggiGroup = entry.getKey();
            List<Pemain> pemainList = entry.getValue();
            int minTinggi = Collections.min(pemainList, Comparator.comparing(p -> p.tinggi)).tinggi;
            int maxTinggi = Collections.max(pemainList, Comparator.comparing(p -> p.tinggi)).tinggi;
            System.out.printf("Range %d - %d cm:%n", tinggiGroup, (tinggiGroup + 9));
            System.out.printf("Min: %d cm, Max: %d cm%n", minTinggi, maxTinggi);
            for (Pemain pemain : pemainList) {
                System.out.printf("- %d (%d cm)%n", pemain.noPemain, pemain.tinggi);
            }
        }

        // Kategori range tinggi di Tim B
        System.out.println("\nKategori Range Tinggi di Tim B:");
        int minRangeTinggiB = Collections.min(timB, Comparator.comparing((Pemain p) -> p.tinggi)).tinggi;
        int maxRangeTinggiB = Collections.max(timB, Comparator.comparing((Pemain p) -> p.tinggi)).tinggi;
        System.out.println("Tinggi Min: " + minRangeTinggiB + " cm");
        System.out.println("Tinggi Max: " + maxRangeTinggiB + " cm");
        TreeMap<Integer, List<Pemain>> rangeTinggiTimB = new TreeMap<>();
        for (Pemain pemain : timB) {
            int tinggiGroup = pemain.tinggi / 10 * 10; // Mengelompokkan pemain berdasarkan kelipatan 10 tinggi badan
            if (!rangeTinggiTimB.containsKey(tinggiGroup)) {
                rangeTinggiTimB.put(tinggiGroup, new ArrayList<>());
            }
            rangeTinggiTimB.get(tinggiGroup).add(pemain);
        }
        for (Map.Entry<Integer, List<Pemain>> entry : rangeTinggiTimB.entrySet()) {
            int tinggiGroup = entry.getKey();
            List<Pemain> pemainList = entry.getValue();
            int minTinggi = Collections.min(pemainList, Comparator.comparing(p -> p.tinggi)).tinggi;
            int maxTinggi = Collections.max(pemainList, Comparator.comparing(p -> p.tinggi)).tinggi;
            System.out.printf("Range %d - %d cm:%n", tinggiGroup, (tinggiGroup + 9));
            System.out.printf("Min: %d cm, Max: %d cm%n", minTinggi, maxTinggi);
            for (Pemain pemain : pemainList) {
                System.out.printf("- %d (%d cm)%n", pemain.noPemain, pemain.tinggi);
            }
        }

        // Kategori range berat di Tim A
        System.out.println("\nKategori Range Berat di Tim A:");
        int minRangeBeratA = Collections.min(timA, Comparator.comparing((Pemain p) -> p.berat)).berat;
        int maxRangeBeratA = Collections.max(timA, Comparator.comparing((Pemain p) -> p.berat)).berat;
        System.out.println("Berat Min: " + minRangeBeratA + " kg");
        System.out.println("Berat Max: " + maxRangeBeratA + " kg");
        TreeMap<Integer, List<Pemain>> rangeBeratTimA = new TreeMap<>();
        for (Pemain pemain : timA) {
            int beratGroup = pemain.berat / 10 * 10; // Mengelompokkan pemain berdasarkan kelipatan 10 berat badan
            if (!rangeBeratTimA.containsKey(beratGroup)) {
                rangeBeratTimA.put(beratGroup, new ArrayList<>());
            }
            rangeBeratTimA.get(beratGroup).add(pemain);
        }
        for (Map.Entry<Integer, List<Pemain>> entry : rangeBeratTimA.entrySet()) {
            int beratGroup = entry.getKey();
            List<Pemain> pemainList = entry.getValue();
            int minBerat = Collections.min(pemainList, Comparator.comparing(p -> p.berat)).berat;
            int maxBerat = Collections.max(pemainList, Comparator.comparing(p -> p.berat)).berat;
            System.out.printf("Range %d - %d kg:%n", beratGroup, (beratGroup + 9));
            System.out.printf("Min: %d kg, Max: %d kg%n", minBerat, maxBerat);
            for (Pemain pemain : pemainList) {
                System.out.printf("- %d (%d kg)%n", pemain.noPemain, pemain.berat);
            }
        }

        // Kategori range berat di Tim B
        System.out.println("\nKategori Range Berat di Tim B:");
        int minRangeBeratB = Collections.min(timB, Comparator.comparing((Pemain p) -> p.berat)).berat;
        int maxRangeBeratB = Collections.max(timB, Comparator.comparing((Pemain p) -> p.berat)).berat;
        System.out.println("Berat Min: " + minRangeBeratB + " kg");
        System.out.println("Berat Max: " + maxRangeBeratB + " kg");
        TreeMap<Integer, List<Pemain>> rangeBeratTimB = new TreeMap<>();
        for (Pemain pemain : timB) {
            int beratGroup = pemain.berat / 10 * 10; // Mengelompokkan pemain berdasarkan kelipatan 10 berat badan
            if (!rangeBeratTimB.containsKey(beratGroup)) {
                rangeBeratTimB.put(beratGroup, new ArrayList<>());
            }
            rangeBeratTimB.get(beratGroup).add(pemain);
        }
        for (Map.Entry<Integer, List<Pemain>> entry : rangeBeratTimB.entrySet()) {
            int beratGroup = entry.getKey();
            List<Pemain> pemainList = entry.getValue();
            int minBerat = Collections.min(pemainList, Comparator.comparing(p -> p.berat)).berat;
            int maxBerat = Collections.max(pemainList, Comparator.comparing(p -> p.berat)).berat;
            System.out.printf("Range %d - %d kg:%n", beratGroup, (beratGroup + 9));
            System.out.printf("Min: %d kg, Max: %d kg%n", minBerat, maxBerat);
            for (Pemain pemain : pemainList) {
                System.out.printf("- %d (%d kg)%n", pemain.noPemain, pemain.berat);
            }
        }

    }
}
