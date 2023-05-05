package Java.ASD.Praktikum.Heap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        Heap h = new Heap();
        for (int i = 0; i < n; i++) {
            h.insert(in.nextInt());
        }
        h.preorder();
    }
    
}
