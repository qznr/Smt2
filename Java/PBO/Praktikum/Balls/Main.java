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

        findPlayersWithSameHeight(timA, timB);
        findPlayersWithSameWeight(timA, timB);

        findPlayersWithUniqueHeight(timA, timB);
        findPlayersWithUniqueWeight(timA, timB);

        findPlayersWithUniqueHeight(timB, timA);
        findPlayersWithUniqueWeight(timB, timA);
        
        analyzePlayerHeight(timA, "A");
        analyzePlayerHeight(timB, "B");

        analyzePlayerWeight(timA, "A");
        analyzePlayerWeight(timB, "B");

    }

    public static void analyzePlayerHeight(List<Pemain> team, String teamName) {
        System.out.println("\nKategori Range Tinggi di Tim " + teamName + ":");
        int minRangeTinggi = Collections.min(team, Comparator.comparing(p -> p.tinggi)).tinggi;
        int maxRangeTinggi = Collections.max(team, Comparator.comparing(p -> p.tinggi)).tinggi;
        System.out.println("Tinggi Min: " + minRangeTinggi + " cm");
        System.out.println("Tinggi Max: " + maxRangeTinggi + " cm");

        TreeMap<Integer, List<Pemain>> rangeTinggi = new TreeMap<>();
        for (Pemain pemain : team) {
            int tinggiGroup = pemain.tinggi / 10 * 10; // Mengelompokkan pemain berdasarkan kelipatan 10 tinggi badan
            if (!rangeTinggi.containsKey(tinggiGroup)) {
                rangeTinggi.put(tinggiGroup, new ArrayList<>());
            }
            rangeTinggi.get(tinggiGroup).add(pemain);
        }

        for (Map.Entry<Integer, List<Pemain>> entry : rangeTinggi.entrySet()) {
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
    }

    public static void analyzePlayerWeight(List<Pemain> team, String teamName) {
        System.out.println("\nKategori Range Berat di Tim " + teamName + ":");
        int minRangeBerat = Collections.min(team, Comparator.comparing(p -> p.berat)).berat;
        int maxRangeBerat = Collections.max(team, Comparator.comparing(p -> p.berat)).berat;
        System.out.println("Berat Min: " + minRangeBerat + " kg");
        System.out.println("Berat Max: " + maxRangeBerat + " kg");

        TreeMap<Integer, List<Pemain>> rangeBerat = new TreeMap<>();
        for (Pemain pemain : team) {
            int beratGroup = pemain.berat / 10 * 10; // Mengelompokkan pemain berdasarkan kelipatan 10 berat badan
            if (!rangeBerat.containsKey(beratGroup)) {
                rangeBerat.put(beratGroup, new ArrayList<>());
            }
            rangeBerat.get(beratGroup).add(pemain);
        }

        for (Map.Entry<Integer, List<Pemain>> entry : rangeBerat.entrySet()) {
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
    private static void findPlayersWithSameHeight(List<Pemain> teamA, List<Pemain> teamB) {
        Map<Integer, Pemain> heightMap = createHeightMap(teamA);
        System.out.println("Tinggi badan yang sama:");
        for (Pemain pemain : teamB) {
            if (heightMap.containsKey(pemain.tinggi)) {
                Pemain pemainTimA = heightMap.get(pemain.tinggi);
                System.out.println("Pemain dengan tinggi " + pemain.tinggi +
                        " ditemukan di kedua tim (Tim A Pemain No dan berat : " + pemainTimA.noPemain +
                        ", " + pemainTimA.berat + "kg, Tim B Pemain No dan berat : " +
                        pemain.noPemain + ", " + pemain.berat + "kg)");
            }
        }
    }

    private static void findPlayersWithSameWeight(List<Pemain> teamA, List<Pemain> teamB) {
        Map<Integer, Pemain> weightMap = createWeightMap(teamA);
        System.out.println("\nBerat badan yang sama:");
        for (Pemain pemain : teamB) {
            if (weightMap.containsKey(pemain.berat)) {
                Pemain pemainTimA = weightMap.get(pemain.berat);
                System.out.println("Pemain dengan berat " + pemain.berat +
                        " ditemukan di kedua tim (Tim A Pemain No dan tinggi : " +
                        pemainTimA.noPemain + ", " + pemainTimA.tinggi + "cm, Tim B Pemain No dan tinggi : " +
                        pemain.noPemain + ", " + pemain.tinggi + "cm)");
            }
        }
    }

    private static void findPlayersWithUniqueHeight(List<Pemain> teamA, List<Pemain> teamB) {
        Map<Integer, Pemain> heightMapB = createHeightMap(teamB);
        System.out.println("\nKomplemen tinggi badan tim A:");
        for (Pemain pemain : teamA) {
            if (!heightMapB.containsKey(pemain.tinggi)) {
                System.out.println("Pemain dengan tinggi " + pemain.tinggi + " hanya ada di Tim A");
            }
        }
    }

    private static void findPlayersWithUniqueWeight(List<Pemain> teamA, List<Pemain> teamB) {
        Map<Integer, Pemain> weightMapB = createWeightMap(teamB);
        System.out.println("\nKomplemen berat badan tim A:");
        for (Pemain pemain : teamA) {
            if (!weightMapB.containsKey(pemain.berat)) {
                System.out.println("Pemain dengan berat " + pemain.berat + " hanya ada di Tim A");
            }
        }
    }

    private static Map<Integer, Pemain> createHeightMap(List<Pemain> team) {
        Map<Integer, Pemain> heightMap = new HashMap<>();
        for (Pemain pemain : team) {
            heightMap.put(pemain.tinggi, pemain);
        }
        return heightMap;
    }

    private static Map<Integer, Pemain> createWeightMap(List<Pemain> team) {
        Map<Integer, Pemain> weightMap = new HashMap<>();
        for (Pemain pemain : team) {
            weightMap.put(pemain.berat, pemain);
        }
        return weightMap;
    }
}