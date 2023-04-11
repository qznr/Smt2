package April.TryWithResources;
import java.io.FileOutputStream;
public class TryWithResources {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Gustav.DESKTOP-R43R30E/Documents/Repository/Smt2/Java/PBO/April/TryWithResources/FILKOM.txt")){
            String msg = "Selamat datang di Filkom!";
            byte[] byteArray = msg.getBytes();
            fileOutputStream.write(byteArray);
            System.out.println("Pesan telah sukses ditulis!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}