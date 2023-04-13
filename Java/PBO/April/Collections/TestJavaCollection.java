package April.Collections;
import java.util.*;

public class TestJavaCollection {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Adi");
        list.add("Putra");
        list.add("Putra");
        list.add("Tari");
        list.add("Syila");
        list.removeIf(s -> s.equals("Putra"));
        Iterator itr = list.iterator();
        while (itr.hasNext()){
            Object iter = itr.next();
            // if (iter=="Putra"){
            //     list.remove(iter);
            //     continue;
            // } else {
            //     System.out.println(iter);
            // }
            System.out.println(iter);
        }
    }
}