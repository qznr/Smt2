package Java.PBO.Mei.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class InputStream {
    public static void main(String[] args) {
        String namafile;
        byte[] bufferData = new byte[1024];
        int jumlahByte = 0;
        Scanner in = new Scanner(System.in);
        FileInputStream input = null;
        System.out.print("Masukkan nama file : ");
        namafile = in.next();
        try {
            input = new FileInputStream(namafile);
        } catch (Exception e) {
            System.err.println("Data Tak Terbaca");
        }
        try {
            jumlahByte = input.available();
        } catch (IOException e) {
            System.err.println("Error");
            System.exit(1);
        }
        while(jumlahByte > 0) {
            try {
                int jumlahDibaca = input.read(bufferData, 0 ,bufferData.length);
                System.out.write(bufferData, 0, jumlahDibaca);
                jumlahByte = input.available();
            } catch (Exception e) {
                System.err.println("I/O Error");
                System.exit(1);
            }
        }
    }
}
