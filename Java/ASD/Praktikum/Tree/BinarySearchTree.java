package Java.ASD.Praktikum.Tree;

public class BinarySearchTree<T> {
    NodeBST root;
    int size;

    boolean isEmpty(){
        return root == null;
    }

    void insert(int data){
        NodeBST newNode = new NodeBST(data);
        if (isEmpty()){
            root = newNode;
        } else {
            insertRecursive(data, root);
        }
    }

    private void insertRecursive(int data, NodeBST currentNode){
        if (data < currentNode.data){
            
        }
    }

}
