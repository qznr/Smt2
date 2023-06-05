package Praktikum.SortingBalls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Collection<Pemain> timA = new ArrayList<>();
        timA.add(new Pemain(1, 168, 50));
        timA.add(new Pemain(2, 170, 60));
        timA.add(new Pemain(3, 165, 56));
        timA.add(new Pemain(4, 168, 55));
        timA.add(new Pemain(5, 172, 60));
        timA.add(new Pemain(6, 170, 70));
        timA.add(new Pemain(7, 169, 66));
        timA.add(new Pemain(8, 165, 56));
        timA.add(new Pemain(9, 171, 72));
        timA.add(new Pemain(10, 166, 56));
    
        Collection<Pemain> timB = new ArrayList<>();
        timB.add(new Pemain(1, 170, 66));
        timB.add(new Pemain(2, 167, 60));
        timB.add(new Pemain(3, 165, 59));
        timB.add(new Pemain(4, 166, 58));
        timB.add(new Pemain(5, 168, 58));
        timB.add(new Pemain(6, 175, 71));
        timB.add(new Pemain(7, 172, 68));
        timB.add(new Pemain(8, 171, 68));
        timB.add(new Pemain(9, 168, 65));
        timB.add(new Pemain(10, 169, 60));

        ArrayList<Pemain> sortedByHeightTimA = sortHeight(timA);
        ArrayList<Pemain> sortedByHeightTimB = sortHeight(timB);
        System.out.println("\nTIM A dan TIM B urut tinggi Ascending\nTIM A\t\t\tTIM B");
        print(sortedByHeightTimA,sortedByHeightTimB);

        Collections.reverse(sortedByHeightTimA);
        Collections.reverse(sortedByHeightTimB);
        System.out.println("\nTIM A dan TIM B urut tinggi Descending\nTIM A\t\t\tTIM B");
        print(sortedByHeightTimA,sortedByHeightTimB);

        ArrayList<Pemain> sortedByWeightTimA = sortWeight(timA);
        ArrayList<Pemain> sortedByWeightTimB = sortWeight(timB);
        System.out.println("\nTIM A dan TIM B urut berat Ascending\nTIM A\t\t\tTIM B");
        print(sortedByWeightTimA, sortedByWeightTimB);

        Collections.reverse(sortedByWeightTimA);
        Collections.reverse(sortedByWeightTimB);
        System.out.println("\nTIM A dan TIM B urut berat Descending\nTIM A\t\t\tTIM B");
        print(sortedByWeightTimA, sortedByWeightTimB);

        System.out.println("\nMin dan Max Tinggi\n");
        minMaxHeight(timA, timB);

        System.out.println("\nMin dan Max Berat\n");
        minMaxWeight(timA, timB);

        Collection<Pemain> timC = timB;
        System.out.println("\nTIM B yang dicopy ke TIM C\nTIM B\t\t\tTIM C");
        print(timB, timC);

        System.out.println("\nImplementasi ArrayList terpisah untuk TIM A dan TIM B\nTIM A\t\t\tTIM B");
        print(timA, timB);

        System.out.println("\nJumlah pemain TIM B yang tingginya 168cm dan 160cm");
        int satuNamLapan = countPlayersWithHeight(timB, 168);
        int satuNamPuluh = countPlayersWithHeight(timB, 160);
        System.out.println("Jumlah 168cm :\t" + satuNamLapan);
        System.out.println("Jumlah 160cm :\t" + satuNamPuluh);
        System.out.println("Jumlah Total :\t" + (satuNamLapan+satuNamPuluh));

        System.out.println("\nJumlah pemain TIM A yang beratnya 56kg dan 53kg");
        int limaNam = countPlayersWithWeight(timA, 56);
        int limaTiga = countPlayersWithWeight(timA, 53);
        System.out.println("Jumlah 56kg :\t" + limaNam);
        System.out.println("Jumlah 53kg :\t" + limaTiga);
        System.out.println("Jumlah Total :\t" + (limaTiga+limaNam));

        boolean sameHeightAndWeightExists = findPlayerWithSameHeightOrWeight(timA, timB);

        if (sameHeightAndWeightExists) {
            System.out.println("\nPemain yang memiliki tinggi atau berat yang sama ada di kedua tim (TIM A dan TIM B)");
        } else {
            System.out.println("\nTidak ada pemain yang memiliki tinggi atau berat yang sama ada di kedua tim (TIM A dan TIM B)");
        }
    }

    static ArrayList<Pemain> sortHeight(Collection<Pemain> players) {
        ArrayList<Pemain> sort = new ArrayList<>(players);
        Collections.sort(sort, Comparator.comparingInt(p -> p.tinggi));
        return sort;
    }

    static ArrayList<Pemain> sortWeight(Collection<Pemain> players) {
        ArrayList<Pemain> sort = new ArrayList<>(players);
        Collections.sort(sort, Comparator.comparingInt(p -> p.berat));
        return sort;
    }

    static void print(Collection<Pemain> players) {
        for (Pemain pemain : players) {
            System.out.println(pemain.tinggi + " | " + pemain.berat);
        }
    }

    static void print(Collection<Pemain> teamA, Collection<Pemain> teamB) {
        Iterator<Pemain> iteratorA = teamA.iterator();
        Iterator<Pemain> iteratorB = teamB.iterator();
    
        while (iteratorA.hasNext() && iteratorB.hasNext()) {
            Pemain pemainA = iteratorA.next();
            Pemain pemainB = iteratorB.next();
            System.out.println(pemainA.tinggi + " | " + pemainA.berat +
                    "\t\t" + pemainB.tinggi + " | " + pemainB.berat);
        }
    }

    static void minMaxHeight(Collection<Pemain> teamA, Collection<Pemain> teamB) {
        int minA = Collections.min(teamA, Comparator.comparing(p -> p.tinggi)).tinggi;
        int maxA = Collections.max(teamA, Comparator.comparing(p -> p.tinggi)).tinggi;
        int minB = Collections.min(teamB, Comparator.comparing(p -> p.tinggi)).tinggi;
        int maxB = Collections.max(teamB, Comparator.comparing(p -> p.tinggi)).tinggi;
        System.out.println("\tTIM A\t\t\tTIM B");
        System.out.println("Min :\t" + minA + "\t\t\t" + minB);
        System.out.println("Max :\t" + maxA + "\t\t\t" + maxB);
    }

    static void minMaxWeight(Collection<Pemain> teamA, Collection<Pemain> teamB) {
        int minA = Collections.min(teamA, Comparator.comparing(p -> p.berat)).berat;
        int maxA = Collections.max(teamA, Comparator.comparing(p -> p.berat)).berat;
        int minB = Collections.min(teamB, Comparator.comparing(p -> p.berat)).berat;
        int maxB = Collections.max(teamB, Comparator.comparing(p -> p.berat)).berat;
        System.out.println("\tTIM A\t\t\tTIM B");
        System.out.println("Min :\t" + minA + "\t\t\t" + minB);
        System.out.println("Max :\t" + maxA + "\t\t\t" + maxB);
    }

    static int countPlayersWithHeight(Collection<Pemain> players, int targetHeight) {
        ArrayList<Pemain> sortedPlayers = sortHeight(players);
        // Perform binary search to find the target height
        int index = Collections.binarySearch(sortedPlayers, new Pemain(-1, targetHeight, -1),
                    Comparator.comparingInt(p -> p.tinggi));
        if (index < 0) {
            // The target height was not found
            return 0;
        } else {
            // Count the number of players with the target height
            int count = 1;
            // Check for additional players with the same height towards the left
            int left = index - 1;
            while (left >= 0 && sortedPlayers.get(left).tinggi == targetHeight) {
                count++;
                left--;
            }
            // Check for additional players with the same height towards the right
            int right = index + 1;
            while (right < sortedPlayers.size() && sortedPlayers.get(right).tinggi == targetHeight) {
                count++;
                right++;
            }
            return count;
        }
    }

    static int countPlayersWithWeight(Collection<Pemain> players, int targetWeight) {
        ArrayList<Pemain> sortedPlayers = new ArrayList<>(players);
        Collections.sort(sortedPlayers, Comparator.comparingInt(p -> p.berat));
        int index = Collections.binarySearch(sortedPlayers, new Pemain(-1, -1, targetWeight),
                    Comparator.comparingInt(p -> p.berat));
    
        if (index < 0) {
            return 0;
        } else {
            int count = 1;
            int left = index - 1;
            while (left >= 0 && sortedPlayers.get(left).berat == targetWeight) {
                count++;
                left--;
            }
            int right = index + 1;
            while (right < sortedPlayers.size() && sortedPlayers.get(right).berat == targetWeight) {
                count++;
                right++;
            }
            return count;
        }
    }
     
    static boolean findPlayerWithSameHeightOrWeight(Collection<Pemain> teamA, Collection<Pemain> teamB) {
        ArrayList<Pemain> sortedTeamA = sortHeight(teamA);
        ArrayList<Pemain> sortedTeamB = sortHeight(teamB);
    
        for (Pemain pemainA : sortedTeamA) {
            int index = Collections.binarySearch(sortedTeamB, pemainA,
                    Comparator.comparingInt(Pemain::getTinggi).thenComparingInt(Pemain::getTinggi));
    
            if (index >= 0) {
                // Player with the same height found in both teams
                return true;
            }
    
            index = Collections.binarySearch(sortedTeamB, pemainA,
                    Comparator.comparingInt(Pemain::getBerat).thenComparingInt(Pemain::getBerat));
    
            if (index >= 0) {
                // Player with the same weight found in both teams
                return true;
            }
        }
        // Player not found in both teams
        return false;
    }
}