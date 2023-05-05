package Java.ASD.Praktikum.Heap;

class Node<T> {
    Node<T> left, right, parent;
    T data;
    
    Node(T data){
        this.data = data;
    }
}
