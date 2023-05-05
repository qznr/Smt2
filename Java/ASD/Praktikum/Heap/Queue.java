package Java.ASD.Praktikum.Heap;

class Queue<T> {
    Node<T> front;
    Node<T> rear;
    int size;
    
    boolean isEmpty(){
        return front == null && rear == null;
    }
    
    void enqueue(T data){
        Node<T> newNode = new Node<>(data);
        if (isEmpty()){
            front = rear = newNode;
            return;
        } 
        newNode.left = rear;
        rear.right = newNode;
        rear = newNode;
        size++;
    }
    
    T dequeue(){
        if (isEmpty()){
            return null;
        }
        T data = front.data;
        front = front.right;
        if (front != null) {
            front.left.right = null;
            front.left = null;
        } else {
            rear = null;
        }
        size--;
        return data;
    }
}