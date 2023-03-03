package Java.ASD;

public class ASD {
    public static void main(String[] args) {
        // SingleLinkedList barisan = new SingleLinkedList();
        // Node node1 = new Node();
        // node1.data = 10;
        // barisan.addFirst(node1);
        // System.out.println(barisan.kepala.data);
        // barisan.print();

        DoubleLinkedList doubleBarisan = new DoubleLinkedList();
        NodeDouble nodeDouble1 = new NodeDouble();
        nodeDouble1.data = 5;
        doubleBarisan.addFirst(nodeDouble1);
        doubleBarisan.print();
    }
}
