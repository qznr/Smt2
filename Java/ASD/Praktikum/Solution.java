package Java.ASD.Praktikum;
import java.util.Scanner;

class Node{
    String nama;
    float ipk;
    boolean sertifikat;
    Node pointer;

    public Node(String nama, float ipk, boolean sertifikat){
        this.nama = nama;
        this.ipk = ipk;
        this.sertifikat = sertifikat;
        this.pointer = null;
    }
}

class Queue {
    Node rear, front;
    int size;

    public Queue(){
        this.rear = null;
        this.front = null;
        this.size = 0;
    }

    boolean isEmpty(){
        return front == null;
    }

    void enqueue(String nama, float ipk, boolean sertifikat){
        Node newNode = new Node(nama, ipk, sertifikat);
        if (rear == null) {
            rear = newNode;
            front = newNode;
        } else {
            rear.pointer = newNode;
            rear = newNode;
        }
        size++;
    }

    Node dequeue(){
        if (isEmpty()) {
            return null;
        }
        Node temp = front;
        front = front.pointer;
        if (front == null) {
            rear = null;
        }
        size--;
        return temp;
    }

    float getIpk(Node node){
        float ipk = node.ipk;
        if (node.sertifikat) {
            ipk += 0.2;
        }
        return ipk;
    }


    void selectionSort(){
        Node i = front;
        while (i != null) {
            Node min = i;
            Node j = i.pointer;
            while (j != null) {
                if (getIpk(j) > getIpk(min)) {
                    min = j;
                }
                j = j.pointer;
            }
            if (min != i) {
                swap(i, min);
            }
            i = i.pointer;
        }
    }

    void swap(Node a, Node b){
        String tempNama = a.nama;
        float tempIpk = a.ipk;
        boolean tempSertifikat = a.sertifikat;

        a.nama = b.nama;
        a.ipk = b.ipk;
        a.sertifikat = b.sertifikat;

        b.nama = tempNama;
        b.ipk = tempIpk;
        b.sertifikat = tempSertifikat;
    }    

}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue q = new Queue();
        int n = in.nextInt(); in.nextLine();
        for (int i = 0; i < n; i++) {
            String commandLine = in.nextLine();
            String[] commands = commandLine.split(" ");
            String nama = commands[0];
            float ipk = Float.parseFloat(commands[1]);
            boolean sertifikat = commands[2].equals("1") ? true : false;
            q.enqueue(nama, ipk, sertifikat);
        }
        q.selectionSort();

        // Print the sorted queue
        Node current = q.front;
        while (current != null) {
            System.out.printf("%s %.1f %d\n", current.nama, current.ipk, current.sertifikat ? 1 : 0);
            current = current.pointer;
        }
    }
}