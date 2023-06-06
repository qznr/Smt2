package Mei.Latihan;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SoalSatu {
    public static void main(String[] args) {
        String text = "Saya belajar bahasa Java. Bahasa Java mempunyai kelas berupa String. Belajar String Java itu mudah. String Java juga sering diimplementasikan.";
        Map<String, Integer> tokenCounts = hitungJumlahKata(text);

        printTokenCounts(tokenCounts);
    }

    public static Map<String, Integer> hitungJumlahKata(String teks) {
        StringTokenizer tokenizer = new StringTokenizer(teks, " .,?!"); // Specify delimiters here
        Map<String, Integer> tokenCounts = new LinkedHashMap<>();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            String lowercaseToken = token.toLowerCase();

            if (tokenCounts.containsKey(lowercaseToken)) {
                int count = tokenCounts.get(lowercaseToken);
                tokenCounts.put(lowercaseToken, count + 1);
            } else {
                tokenCounts.put(lowercaseToken, 1);
            }
        }

        return tokenCounts;
    }

    public static void printTokenCounts(Map<String, Integer> tokenCounts) {
        System.out.println("+--------------------+--------+");
        System.out.println("| Token              | Jumlah |");
        System.out.println("+--------------------+--------+");

        for (Map.Entry<String, Integer> entry : tokenCounts.entrySet()) {
            String token = entry.getKey();
            int count = entry.getValue();
            System.out.printf("| %-18s | %6d |\n", token, count);
        }

        System.out.println("+--------------------+--------+");
    }
}
