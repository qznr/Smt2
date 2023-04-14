package Java.ASD.Praktikum.Tree;

public class CompleteBinaryTree<T> {
    Node<T> root;
    int size;

    boolean isEmpty(){
        return root == null;
    }

    void insert(T data){
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()){
            root = newNode;
            size++;
        } else {
            Node<T> pointer = root;
            TreeQueue<Node<T>> queue = new TreeQueue<>();
            queue.enqueue(root);
            while (!isEmpty()){
                pointer = queue.dequeue();
                if (pointer.left == null){
                    pointer.left = newNode;
                    size++;
                    return;
                } else {
                    queue.enqueue(pointer.left);
                }

                if (pointer.right == null) {
                    pointer.right = newNode;
                    size++;
                    return;
                } else {
                    queue.enqueue(pointer.right);
                }
            } 
        }
    }

    void print(){

    }
}