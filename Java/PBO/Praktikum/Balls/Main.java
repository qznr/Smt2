package Praktikum.Balls;

import java.net.SocketTimeoutException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        
        Map<Integer, Pemain> timA = new HashMap<>();
        timA.put(1, new Pemain(1, 168, 50));
        timA.put(2, new Pemain(2, 170, 60));
        timA.put(3, new Pemain(3, 165, 56));
        timA.put(4, new Pemain(4, 168, 55));
        timA.put(5, new Pemain(5, 172, 60));
        timA.put(6, new Pemain(6, 170, 70));
        timA.put(7, new Pemain(7, 169, 66));
        timA.put(8, new Pemain(8, 165, 56));
        timA.put(9, new Pemain(9, 171, 72));
        timA.put(10, new Pemain(10, 166, 56));

        Map<Integer, Pemain> timB = new HashMap<>();
        timB.put(1, new Pemain(1, 170, 66));
        timB.put(2, new Pemain(2, 167, 60));
        timB.put(3, new Pemain(3, 165, 59));
        timB.put(4, new Pemain(4, 166, 58));
        timB.put(5, new Pemain(5, 168, 58));
        timB.put(6, new Pemain(6, 175, 71));
        timB.put(7, new Pemain(7, 172, 68));
        timB.put(8, new Pemain(8, 171, 68));
        timB.put(9, new Pemain(9, 168, 65));
        timB.put(10, new Pemain(10, 169, 60));

        findPlayersWithSameHeight(timA, timB);
        findPlayersWithSameWeight(timA, timB);

        findPlayersWithUniqueHeight(timA, timB, "A");
        findPlayersWithUniqueWeight(timA, timB, "A");

        findPlayersWithUniqueHeight(timB, timA, "B");
        findPlayersWithUniqueWeight(timB, timA, "B");
        
        analyzePlayerHeight(timA, "A");
        analyzePlayerHeight(timB, "B");

        analyzePlayerWeight(timA, "A");
        analyzePlayerWeight(timB, "B");

        System.out.println("\nDimplementasi dua Map terpisah yang lalu di print");
        printTwoMaps(timA, timB);

        System.out.println("\nUpdate berat data TimB yang memiliki tinggi 168cm menjadi 66kg");
        System.out.println("Sebelum : ");
        printMap(timB);
        updatePlayersWithTargetAttribute(timB, 168, "Tinggi", "Berat", 66);
        printMap(timB);

        System.out.println("\nMap data tinggi tim A yang sama dengan tim B");
        Map<Integer, Pemain> sameHeight = getPlayersWithSameHeight(timA,timB);
        printMap(sameHeight);
        
        System.out.println("\nDari map tinggi sama tadi, ini tim A tingginya >168cm");
        printMap(getPlayersWithValueGreaterThan(sameHeight, "tinggi", 168));
    }

    static DecimalFormat cmFormatter = new DecimalFormat("0 cm");
    static DecimalFormat kgFormatter = new DecimalFormat("0 kg");

    public static void analyzePlayerHeight(Map<Integer, Pemain> team, String teamName) {
        System.out.println("\nKategori Range Tinggi di Tim " + teamName + ":");
    
        // Obtain the values from the map as a collection
        Collection<Pemain> pemainCollection = team.values();
    
        // Find the minimum and maximum heights using the collection
        int minRangeTinggi = Collections.min(pemainCollection, Comparator.comparing(p -> p.tinggi)).tinggi;
        int maxRangeTinggi = Collections.max(pemainCollection, Comparator.comparing(p -> p.tinggi)).tinggi;
    
        System.out.println("Tinggi Min: " + minRangeTinggi + " cm");
        System.out.println("Tinggi Max: " + maxRangeTinggi + " cm");
    
        TreeMap<Integer, List<Pemain>> rangeTinggi = new TreeMap<>();
        for (Pemain pemain : pemainCollection) {
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

    public static void analyzePlayerWeight(Map<Integer, Pemain> team, String teamName) {
        System.out.println("\nKategori Range Berat di Tim " + teamName + ":");
    
        // Obtain the values from the map as a collection
        Collection<Pemain> pemainCollection = team.values();
    
        // Find the minimum and maximum weights using the collection
        int minRangeBerat = Collections.min(pemainCollection, Comparator.comparing(p -> p.berat)).berat;
        int maxRangeBerat = Collections.max(pemainCollection, Comparator.comparing(p -> p.berat)).berat;
    
        System.out.println("Berat Min: " + minRangeBerat + " kg");
        System.out.println("Berat Max: " + maxRangeBerat + " kg");
    
        TreeMap<Integer, List<Pemain>> rangeBerat = new TreeMap<>();
        for (Pemain pemain : pemainCollection) {
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
    
    private static void findPlayersWithSameHeight(Map<Integer, Pemain> teamA, Map<Integer, Pemain> teamB) {
        Map<Integer, Pemain> heightMap = createHeightMap(teamA.values());
        System.out.println("Tinggi badan yang sama:");
        System.out.printf("%-35s  | %-35s\n", "Tim A", "Tim B");
        System.out.printf("%-5s|%-15s|%-15s|%-5s|%-15s|%-15s\n", "No", "Tinggi", "Berat", "No", "Tinggi", "Berat");
        for (Pemain pemain : teamB.values()) {
            if (heightMap.containsKey(pemain.tinggi)) {
                Pemain pemainTimA = heightMap.get(pemain.tinggi);
                System.out.printf("%-5d|%-15s|%-15s|%-5d|%-15s|%-15s\n"
                , pemainTimA.noPemain
                , cmFormatter.format(pemain.tinggi)
                , kgFormatter.format(pemainTimA.berat)
                , pemain.noPemain
                , cmFormatter.format(pemain.tinggi)
                , kgFormatter.format(pemain.berat));
            }
        }
    }
    
    private static void findPlayersWithSameWeight(Map<Integer, Pemain> teamA, Map<Integer, Pemain> teamB) {
        Map<Integer, Pemain> weightMap = createWeightMap(teamA.values());
        System.out.println("\nBerat badan yang sama:");
        System.out.printf("%-35s  | %-35s\n", "Tim A", "Tim B");
        System.out.printf("%-5s|%-15s|%-15s|%-5s|%-15s|%-15s\n", "No", "Tinggi", "Berat", "No", "Tinggi", "Berat");
        for (Pemain pemain : teamB.values()) {
            if (weightMap.containsKey(pemain.berat)) {
                Pemain pemainTimA = weightMap.get(pemain.berat);
                System.out.printf("%-5d|%-15s|%-15s|%-5d|%-15s|%-15s\n"
                , pemainTimA.noPemain
                , cmFormatter.format(pemain.tinggi)
                , kgFormatter.format(pemainTimA.berat)
                , pemain.noPemain
                , cmFormatter.format(pemain.tinggi)
                , kgFormatter.format(pemain.berat));
            }
        }
    }

    private static void findPlayersWithUniqueHeight(Map<Integer, Pemain> teamA, Map<Integer, Pemain> teamB, String teamName) {
        Map<Integer, Pemain> heightMap = createHeightMap(teamB.values());
        System.out.println("\nKomplemen tinggi badan tim " + teamName + ":");
        for (Pemain pemain : teamA.values()) {
            if (!heightMap.containsKey(pemain.tinggi)) {
                System.out.println("Pemain dengan tinggi " + pemain.tinggi + " hanya ada di Tim " + teamName);
            }
        }
    }
    
    private static void findPlayersWithUniqueWeight(Map<Integer, Pemain> teamA, Map<Integer, Pemain> teamB, String teamName) {
        Map<Integer, Pemain> weightMap = createWeightMap(teamB.values());
        System.out.println("\nKomplemen berat badan tim " + teamName + ":");
        for (Pemain pemain : teamA.values()) {
            if (!weightMap.containsKey(pemain.berat)) {
                System.out.println("Pemain dengan berat " + pemain.berat + " hanya ada di Tim " + teamName);
            }
        }
    }
    
    private static Map<Integer, Pemain> createHeightMap(Collection<Pemain> team) {
        Map<Integer, Pemain> heightMap = new HashMap<>();
        for (Pemain pemain : team) {
            heightMap.put(pemain.tinggi, pemain);
        }
        return heightMap;
    }
    
    private static Map<Integer, Pemain> createWeightMap(Collection<Pemain> team) {
        Map<Integer, Pemain> weightMap = new HashMap<>();
        for (Pemain pemain : team) {
            weightMap.put(pemain.berat, pemain);
        }
        return weightMap;
    }

    public static void updatePlayersWithTargetAttribute(Map<Integer, Pemain> players, int targetValue, String targetAttribute, String attributeToUpdate, int updateValue) {
        for (Pemain player : players.values()) {
            if (targetAttribute.equalsIgnoreCase("tinggi") && player.tinggi == targetValue) {
                if (attributeToUpdate.equalsIgnoreCase("tinggi")) {
                    player.tinggi = updateValue;
                } else if (attributeToUpdate.equalsIgnoreCase("berat")) {
                    player.berat = updateValue;
                } else {
                    System.out.println("Invalid attribute to update.");
                    return;
                }
            } else if (targetAttribute.equalsIgnoreCase("berat") && player.berat == targetValue) {
                if (attributeToUpdate.equalsIgnoreCase("tinggi")) {
                    player.tinggi = updateValue;
                } else if (attributeToUpdate.equalsIgnoreCase("berat")) {
                    player.berat = updateValue;
                } else {
                    System.out.println("Invalid attribute to update.");
                    return;
                }
            }
        }
        System.out.println("Players with " + targetAttribute + " " + targetValue + " updated successfully.");
    }

    private static Map<Integer, Pemain> getPlayersWithSameHeight(Map<Integer, Pemain> teamA, Map<Integer, Pemain> teamB) {
        Map<Integer, Pemain> heightMap = createHeightMap(teamA.values());
        Map<Integer, Pemain> playersWithSameHeight = new HashMap<>();
    
        for (Pemain pemain : teamB.values()) {
            if (heightMap.containsKey(pemain.tinggi)) {
                Pemain pemainTimA = heightMap.get(pemain.tinggi);
                playersWithSameHeight.put(pemainTimA.noPemain, pemainTimA);
            }
        }
        return playersWithSameHeight;
    }

    private static void printMap(Map<Integer, Pemain> map) {
        System.out.printf("%-5s|%-15s|%-15s\n", "No", "Tinggi", "Berat");
        for (Pemain pemain : map.values()) {
            System.out.printf("%-5d|%-15s|%-15s\n",
                    pemain.noPemain,
                    cmFormatter.format(pemain.tinggi),
                    kgFormatter.format(pemain.berat));
        }
    }

    private static Map<Integer, Pemain> getPlayersWithValueGreaterThan(Map<Integer, Pemain> team, String attribute, double minValue) {
        Map<Integer, Pemain> playersWithGreaterValue = new HashMap<>();
    
        for (Pemain pemain : team.values()) {
            double attributeValue;
            if (attribute.equalsIgnoreCase("tinggi")) {
                attributeValue = pemain.tinggi;
            } else if (attribute.equalsIgnoreCase("berat")) {
                attributeValue = pemain.berat;
            } else {
                throw new IllegalArgumentException("Invalid attribute specified. Must be 'tinggi' or 'berat'.");
            }
            
            if (attributeValue > minValue) {
                playersWithGreaterValue.put(pemain.noPemain, pemain);
            }
        }
    
        return playersWithGreaterValue;
    }

    private static void printTwoMaps(Map<Integer, Pemain> mapA, Map<Integer, Pemain> mapB) {
        System.out.printf("%-35s  | %-35s\n", "Map A", "Map B");
        System.out.printf("%-5s|%-15s|%-15s|%-5s|%-15s|%-15s\n", "No", "Tinggi", "Berat", "No", "Tinggi", "Berat");
        
        for (Map.Entry<Integer, Pemain> entryA : mapA.entrySet()) {
            Integer keyA = entryA.getKey();
            Pemain pemainA = entryA.getValue();
            
            Pemain pemainB = mapB.get(keyA);
            if (pemainB != null) {
                System.out.printf("%-5d|%-15s|%-15s|%-5d|%-15s|%-15s\n",
                        pemainA.noPemain,
                        cmFormatter.format(pemainA.tinggi),
                        kgFormatter.format(pemainA.berat),
                        pemainB.noPemain,
                        cmFormatter.format(pemainB.tinggi),
                        kgFormatter.format(pemainB.berat));
            }
        }
    }
    
}