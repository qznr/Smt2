import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KRS.tambahMataKuliah();
        KRS.print();
    }
}
class KRS{
    public static Scanner sc = new Scanner(System.in);
    public static int jumlah = sc.nextInt();
    public static String[] matkul = new String[jumlah];
    public static String[] kodeMatkul = new String[jumlah];
    
    public static void tambahMataKuliah(){
        sc.nextLine();
        for (int i = 0; i < jumlah; i++){
            kodeMatkul [i] = sc.next();
            matkul [i] = sc.nextLine();
        }
    }

    public static void print(){
        if (jumlah>5) {
            System.out.println("Error : KRS telah penuh");
            System.out.println("Daftar Mata Kuliah :");
            for (int i = 0; i < 5; i++){
                System.out.println(kodeMatkul[i] + ": ");
                System.out.println(matkul[i]);
            }
        }else{
            System.out.println("Daftar Mata Kuliah :");
            for (int i = 0; i < jumlah; i++){
                System.out.print(kodeMatkul[i] + ": ");
                System.out.println(matkul[i]);
            }
        }

    }
}