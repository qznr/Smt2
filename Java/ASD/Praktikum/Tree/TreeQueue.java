package Java.ASD.Praktikum.Tree;

public class TreeQueue<T> {
    Node<T> front, rear;
    int size = 0;

    boolean isEmpty(){
        return front == null && rear == null;
    }

    void enqueue(T data){
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()){
            front = rear= newNode;
        } else {
            newNode.left = rear;
            rear.right = newNode;
        }
        size++;
    }

    T dequeue(){
        try {
            T returnValue;
            if (front == rear) {
                returnValue = front.data;
                front = rear = null;
            } else {
                returnValue = front.data;
                front = front.right;
                front.right.left = null;
                front.left = null;
            }
            size--;
            return returnValue;
        } catch (NullPointerException e) {
            return null;
        }
    }
}