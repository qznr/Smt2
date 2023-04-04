/*/  
Nama    : Moch. Gustav Ali Rafsandjani
NIM     : 225150201111015
Kelas   : TIF-C
/*/

package Java.ASD.quiz1;
import java.util.NoSuchElementException;

public class Queue {
    Node rear;
    Node front;
    int size;

    public Queue() {
        this.rear = null;
        this.front = null;
        size = 0;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void enqueue(Node newNode){
        if (rear == null){
            rear = front = newNode;
        } else {
            rear.pointer = newNode;
            rear = newNode;
        }
        size++;
    }

    public Node dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node dequeue = front;
        front = front.pointer;
        if (front == null){
            rear = null;
        }
        size--;
        return dequeue;
    }

    public void printQueue() {
        Node current = front;
        if (isEmpty()) {
            System.out.println("Queue Kosong!");
            return;
        }
        while (current != null) {
            System.out.print(current.index + " ");
            current = current.pointer;
        }
        System.out.println();
        return;
    }
}
