package Java.ASD.Praktikum;
import java.util.Scanner;


class Node {
	 /*
      * KATA MASBRO KERJAIN DISINI !!
      */
    String title;
    int plays;
    Node next, prev;
    
    Node(String title, int plays) {
        this.title = title;
        this.plays = plays;
    }
}

class LinkedList {
	/*
	 * KATA MASBRO KERJAIN DISINI !!
     */
    Node head, tail;
    int size;
    
    boolean isEmpty() {
        return head == null && tail == null;
    }
    
    void addFirst(String title, int plays) {
        Node newNode = new Node(title, plays);
        if (isEmpty()) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }
    
    void sort() {
        if (isEmpty() || size == 1) {
            return; // No need to sort empty list or list with only one element
        }
        
        Node current = head.next;
        while (current != null) {
            Node insertionNode = current;
            int plays = insertionNode.plays;
            
            // Find the correct position to insert the current node
            Node prevNode = insertionNode.prev;
            while (prevNode != null && prevNode.plays > plays) {
                prevNode.next.plays = prevNode.plays;
                insertionNode = prevNode;
                prevNode = prevNode.prev;
            }
            
            if (insertionNode != current) {
                insertionNode.plays = plays;
            }
            
            current = current.next;
        }
    }
    
    void receipify() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.plays);
            temp = temp.next;
        }
    }
}

/*
 * BOLEH KALO MAU NAMBAH CLASS BARU !! :D
 */

public class Solution {

    public static void main(String[] args) {
        /*
         * KATA MASBRO KERJAIN DISINI !!
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        LinkedList ll = new LinkedList();
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] parts = line.split(" -- ");
            String title = parts[0];
            int number = Integer.parseInt(parts[1].trim());
            ll.addFirst(parts[0],number);
        }
        ll.sort();
        ll.receipify();
    }
}