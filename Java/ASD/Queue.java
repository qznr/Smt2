package Java.ASD;

public class Queue {
    Node rear, front;
    SingleLinkedList sll;
    int size;

    boolean isEmpty(){
        return front == null;
    }

    void enqueue(int data){
        Node newNode = new Node(data);
        sll.addLast(newNode);
    }

    int dequeue(){
        int data = sll.kepala.data;
        sll.deleteFirst();
        return data;
    }
}