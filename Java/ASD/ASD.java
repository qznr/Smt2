package Java.ASD;

public class ASD {
    public static void main(String[] args) {
        LinkedList barisan = new LinkedList();
        Node node1 = new Node();
        node1.data = 10;
        barisan.addFirst(node1);
        System.out.println(barisan.kepala.data);
    }
}
