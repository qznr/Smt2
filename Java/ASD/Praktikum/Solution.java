package Java.ASD.Praktikum;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        /*
         * KATA MASBRO KERJAIN DISINI !!
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        for (int i = 0; i < n; i++) {
            String check = in.nextLine();
            String ref = in.nextLine();
            char[] checkArr = check.toCharArray();
            char[] refArr = ref.toCharArray();
            for (char c : refArr) {
                System.out.print(compare(checkArr, c));
            }
            System.out.println();
        }
    }
    
    static String compare(char[] check, char ref) {
        int[] indexes = new int[check.length];
        String fix = "";
        for (int i = 0; i < check.length; i++) {
            System.out.println(check[i]);
            if (check[i] == ref) {
                indexes[i] = i;
                System.out.println("tes");
            }
        }
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i]!=0) fix += indexes[i] + " ";
        }
        if (fix.equals("")) { 
            return "-1 ";
        }
        return fix;
    }
  
  	/*
     * GAPAPA NAMBAH METHOD BARU !! :D
     */
}