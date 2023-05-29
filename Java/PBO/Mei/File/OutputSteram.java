package Java.PBO.Mei.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class OutputSteram {
    public static void main(String[] args) {
        String namafile;
        byte[] bufferData = new byte[1024];
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan nama file : ");
        namafile = in.nextLine();
        System.out.print("\nMasukkan Data Teks: ");
        try {
            System.in.read(bufferData);
        } catch (Exception e) {
            System.err.println("Data Tak Terbaca");
        }
        try {
            FileOutputStream output = new FileOutputStream(namafile);
            output.write(bufferData,0 ,bufferData.length);
            output.close();
        } catch (IOException e) {
            System.err.println("Error");
        }
        System.out.println("\nFile berhasil");
    }
}
