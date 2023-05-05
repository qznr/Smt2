package Java.ASD.Praktikum;

class Node<T> {
    Node<T> left;
    Node<T> right;
    T data;
    
    Node(T data){
        this.data = data;
    }
}

class NodeHeap {
    NodeHeap left, right, parent;
    int data;
    
    NodeHeap(int data){
        this.data = data;
    }
}

class Queue<T> {
    Node<T> front;
    Node<T> rear;
    int size;
    
    boolean isEmpty(){
        return front == null && rear == null;
    }
    
    void enqueue(T data){
        Node<T> newNode = new Node(data);
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

class Heap<T> {
    NodeHeap root;
    int size;
    
    boolean isEmpty(){
        return root == null;
    }

    boolean isLeaf(NodeHeap node) {
        return node.left == null && node.right == null;
    }
    
    void insert(int data){
        NodeHeap newNode = new NodeHeap(data);
        if (isEmpty()){
            root = newNode;
            return;
        }
        NodeHeap current = root;
        Queue<NodeHeap> q = new Queue<>();
        q.enqueue(root);
        while(!q.isEmpty()){
            current = q.dequeue();
            if (current.left == null) {
                current.left = newNode;
                newNode.parent = current;
                size++;
                heapify(newNode);
                return;
            } else {
                q.enqueue(current.left);
            }
            if (current.right == null) {
                current.right = newNode;
                newNode.parent = current;
                size++;
                heapify(newNode);
                return;
            } else {
                q.enqueue(current.right);
            }
        }
    }

    void heapify(NodeHeap swap) {
        if (swap == root) {
            return;
        }
        if (swap.data > swap.parent.data) {
            int tmp = swap.parent.data;
            swap.parent.data = swap.data;
            swap.data = tmp;
            heapify(swap.parent);
        }
        return;
    }

    void heapify2(NodeHeap swap) {
        if (isLeaf(swap)) {
            return;
        }
        NodeHeap largerChild = swap.left;
        if (swap.right != null && swap.left.data < swap.right.data) {
            largerChild = swap.right;
        }
        if (swap.data < largerChild.data) {
            int tmp = swap.data;
            swap.data = largerChild.data;
            largerChild.data = tmp;
            heapify2(largerChild);
        }
    }
    
    void newRoot(int data) {
        if (isEmpty()) {
            root = new NodeHeap(data);
            return;
        }
        root.data = data;
        heapify2(root);
        return;
    }

    void preorder(){
        System.out.println("Hasil pre-order:");
        if (isEmpty()) {
            System.out.println("Heap masih kosong.");
        } else {
            preorder(root, 0);    
        }
    }
    
    void preorder(NodeHeap current, int level){
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        System.out.println(current.data);
        if (current.left!=null) preorder(current.left, level + 1);
        if (current.right!=null) preorder(current.right, level + 1);
    }

    void inorder(){
        System.out.println("Hasil in-order:");
        if (isEmpty()) {
            System.out.println("Heap masih kosong.");
        } else {
            inorder(root, 0);
        }

    }

    void inorder(NodeHeap current, int level){
        if (current.left!=null) inorder(current.left, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        System.out.println(current.data);
        if (current.right!=null) inorder(current.right, level + 1);
    }
    
    void postorder() {
        System.out.println("Hasil post-order:");
        if (isEmpty()) {
            System.out.println("Heap masih kosong.");
        } else {
            postorder(root, 0);
        }
    }

    void postorder(NodeHeap current, int level) {
        if (current.left != null) {
            postorder(current.left, level + 1);
        }
        if (current.right != null) {
            postorder(current.right, level + 1);
        }
                for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        System.out.println(current.data);
    }
}

public class HeapHeap2 {
    public static void main(String[] args) {
      	Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        Heap h = new Heap();
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] commands = line.split(" ");
            if (commands[0].equals("print")){
                if (commands[1].equals("preorder")) h.preorder();
                if (commands[1].equals("inorder")) h.inorder();
                if (commands[1].equals("postorder")) h.postorder();
            } else {
                int data = Integer.parseInt(commands[1]);
                h.insert(data);
            }
        }
      	in.close();
    }
}