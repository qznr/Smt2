package Java.ASD.Praktikum.Heap;

public class Heap<T> {
    NodeHeap root;
    int size;
    
    boolean isEmpty(){
        return root == null;
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

    void preorder(){
        System.out.println("Hasil pre-order:");
        if (isEmpty()) {
            System.out.println("Heap masih kosong.");
        } else {
            preorder(root, 0);
            System.out.println();            
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
            System.out.println();
        }

    }

    void inorder(NodeHeap current, int level){
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        if (current.left!=null) inorder(current.left, level + 1);
        System.out.println(current.data);
        if (current.right!=null) inorder(current.right, level + 1);
    }
    
    void postorder() {
        System.out.println("Hasil post-order:");
        if (isEmpty()) {
            System.out.println("Heap masih kosong.");
        } else {
            postorder(root, 0);
            System.out.println();
        }
    }

    void postorder(NodeHeap current, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        if (current.left != null) {
            postorder(current.left, level + 1);
        }
        if (current.right != null) {
            postorder(current.right, level + 1);
        }
        System.out.println(current.data);
    }
}
