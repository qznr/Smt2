package Java.ASD.Praktikum.AVLTree;

public class Node {
    Node right, left, parent;
    int data, height;

    Node(int data) {
        this.data = data;
        height = 1;
    }
}
