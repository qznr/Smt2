package Java.ASD.Praktikum.AVLTree;

public class AVLTree {
    Node root;

    // Cek tree apakah kosong.
    Boolean isEmpty() {
        return root == null;
    }

    void insert(int data) {
        // Memanggil fungsi insert rekursif dengan node root dan data yang ingin dimasukkan
        root = insertRecursive(root, data);
    }

    // Recursive data baru ke AVL Tree.
    Node insertRecursive(Node node, int data) {

        // Jika node kosong buat baru.
        if (node == null) {
            return (new Node(data));
        }

        // Binary Search Tree seperti biasa.
        // Kalau data lebih kecil dari node maka masuk subtree kiri.
        if (data < node.data) {
            node.left = insertRecursive(node.left, data);
        } else if (data > node.data) {
            // Kalau data lebih besar dari node maka masuk subtree kanan.
            node.right = insertRecursive(node.right, data);
        } else {
            // Tidak perlu memasukkan node yg sudah ada
            return node;
        }

        // Mengupdate height setelah insertion
        node.height = 1 + compareMax(getHeight(node.left), getHeight(node.right));
        
        // Balance factor
        int balance = getBalanceFactor(node);

        // Tidak seimbang

        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }

    Node rightRotate(Node node) {
        Node leftNode = node.left;
        Node rightOfLeftNode = leftNode.right;

        leftNode.right = node;
        node.left = rightOfLeftNode;

        node.height = compareMax(getHeight(node.left), getHeight(node.right)) + 1;
        leftNode.height = compareMax(getHeight(leftNode.left), getHeight(leftNode.right)) + 1;

        return leftNode;
    }

    Node leftRotate(Node node) {
        Node rightNode = node.right;
        Node leftOfRightNode = rightNode.left;

        rightNode.left = node;
        node.right = leftOfRightNode;

        node.height = compareMax(getHeight(node.left), getHeight(node.right)) + 1;
        rightNode.height = compareMax(getHeight(rightNode.left), getHeight(rightNode.right)) + 1;

        return rightNode;
    }

    int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    int compareMax(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    void preorder(){
        System.out.println("Hasil pre-order:");
        if (isEmpty()) {
            System.out.println("Tree masih kosong.");
        } else {
            preorder(root, 0);    
        }
    }
    
    void preorder(Node current, int level){
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
            System.out.println("Tree masih kosong.");
        } else {
            inorder(root, 0);
        }

    }

    void inorder(Node current, int level){
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
            System.out.println("Tree masih kosong.");
        } else {
            postorder(root, 0);
        }
    }

    void postorder(Node current, int level) {
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
