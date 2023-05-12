package Java.ASD.Praktikum.AVLTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AVLTree tree = new AVLTree();
        while (true) {
            String line = in.nextLine();
            String[] commands = line.split(" ");
            if (commands[0].equals("insert")) {
                tree.insert(Integer.parseInt(commands[1]));
            }
            if (commands[0].equals("print")) {
                if (commands[1].equals("preorder")) {
                    tree.preorder();
                }
                if (commands[1].equals("inorder")) {
                    tree.inorder();
                }
                if (commands[1].equals("postorder")) {
                    tree.postorder();
                }
                if (commands[1].equals("levels")) {
                    System.out.println("Levels : " + tree.getHeight(tree.root));
                }
            }
            if (commands[0].equals("exit")) {
                break;
            }
        }
        // tree.root = tree.insertRecursive(tree.root, 100);
        // tree.root = tree.insertRecursive(tree.root, 55);
        // tree.root = tree.insertRecursive(tree.root, 24);
        // tree.root = tree.insertRecursive(tree.root, 37);
        // tree.root = tree.insertRecursive(tree.root, 48);
        // tree.root = tree.insertRecursive(tree.root, 40);
        // tree.preorder();
        // tree.inorder();
        // tree.postorder();
        // System.out.println(tree.getHeight(tree.root));
    }
}