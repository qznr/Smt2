package Java.ASD.Praktikum.Graph;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * MAU NAMBAH CLASS SENDIRI? GAPAPA!!
 */

class Node {
    String username;
    ArrayList<Node> followers;
    ArrayList<Node> following;

    public Node(String username) {
        this.username = username;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public void addFollower(Node follower) {
        followers.add(follower);
    }

    public void addFollowing(Node following) {
        this.following.add(following);
    }
}

class Graph {
    public ArrayList<Node> users;

    public Graph() {
        this.users = new ArrayList<>();
    }

    public void addUser(String username) {
        Node node = new Node(username);
        users.add(node);
    }

    public void addConnection(String sourceUsername, String destUsername) {
        Node sourceNode = findUserByUsername(sourceUsername);
        Node destNode = findUserByUsername(destUsername);
        
        // System.out.println(sourceNode.username + "Source");
        // System.out.println(destNode.username + "Dest");

        if (sourceNode != null && destNode != null && sourceNode != destNode) {
            sourceNode.addFollowing(destNode);
            destNode.addFollower(sourceNode);
        }
    }

    public Node findUserByUsername(String username) {
        for (Node user : users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void printAllConnection() {
        int lastIndex = users.size() - 1;

        for (int i = 0; i < users.size(); i++) {
            Node user = users.get(i);
            System.out.println(user.username + "'s followings :");
            for (Node following : users) {
                if (user.following.contains(following)) {
                    System.out.println(" " + following.username);
                }
            }

            System.out.println(user.username + "'s followers :");
            for (Node follower : users) {
                if (user.followers.contains(follower)) {
                    System.out.println(" " + follower.username);
                }
            }

            if (i != lastIndex) {
                System.out.println();
            }
        }
    }

    public void printConnections(String username) {
        Node user = findUserByUsername(username);
        System.out.println(user.username + "'s followings :");
        for (Node following : users) {
            if (user.following.contains(following)) {
                System.out.println(" " + following.username);
            }
        }

        System.out.println(user.username + "'s followers :");
        for (Node follower : users) {
            if (user.followers.contains(follower)) {
                System.out.println(" " + follower.username);
            }
        }
    }
}

public class GraphMain {

    public static void main(String[] args) {
        /*
         * KATA MASBRO KERJAIN DISINI!!
         */
        Scanner in = new Scanner(System.in);
        int nUsers = in.nextInt(); in.nextLine();
        Graph graf = new Graph();
        for (int i = 0; i < nUsers; i++) {
            String username = in.nextLine();
            graf.addUser(username);
        }
        // for (Node user : graf.users) {
        //     System.out.println(user.username);
        // }
        int nCommands = in.nextInt(); in.nextLine();
        for (int i = 0; i < nCommands; i++) {
            String username = in.next();
            if (username.equals("all")) {
                graf.printAllConnection(); in.nextLine();
            } else {
                String command = in.next();
                if (command.equals("follow")) {
                    String toFollow = in.next();
                    graf.addConnection(username, toFollow);
                } else {
                    graf.printConnections(username);
                }
            }
        }
    }
}