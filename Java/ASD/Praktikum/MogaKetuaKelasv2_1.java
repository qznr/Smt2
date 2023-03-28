package Java.ASD.Praktikum;

import java.util.Scanner;

class NodeDLL {
    NodeDLL next;
    NodeDLL prev;
    String data;

    NodeDLL() {
        this.next = null;
        this.prev = null;
    }

    NodeDLL(String newData) {
        this.data = newData;
    }
}

class DLL {
    NodeDLL head;
    NodeDLL tail;
    int size;

    boolean isEmpty() {
        return head == null && tail == null;
    }

    int getSize() {
        return size;
    }

    void addFirst(String newData) {
        NodeDLL newNode = new NodeDLL(newData);
        if(isEmpty()){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    void addLast(String newData) {
        NodeDLL newNode = new NodeDLL(newData);
        if(isEmpty()){
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void removeFirst() {
        if(isEmpty()){
            System.out.println("List masih kosong.");
        } else if (getSize()==1){
            head = tail = null;
        } else {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }
        size--;
    }

    void removeLast() {
        if(isEmpty()){
            System.out.println("List masih kosong.");
        } else if (getSize()==1){
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
        size--;
    }

    void addAtIndex(int targetIndex, String newData){
        NodeDLL newNode = new NodeDLL(newData);
        NodeDLL temp = new NodeDLL();
        temp = head;
        if (targetIndex>getSize() || targetIndex<0){
            System.out.println("Index tidak valid.");
        } else if(targetIndex == 0){
            this.addFirst(newData);
        } else if(targetIndex == getSize()){
            this.addLast(newData);
        } else {
            for(int i=0;i<targetIndex;i++){
                temp = temp.next;
            }
            newNode.prev = temp.prev;
            newNode.next = temp;
            temp.prev.next = newNode;
            temp.prev = newNode;
            size++;
        }
    }

    void removeTarget(String targetData) {
        NodeDLL temp = new NodeDLL();
        temp = head;
        if(isEmpty()){
            System.out.println("List masih kosong.");
        } else {
            while(!temp.data.equals(targetData)){
                temp = temp.next;
            }
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            temp.prev = temp.next = null;
        }
    }

    void printForward() {
        NodeDLL temp = new NodeDLL();
        temp = head;
        if(isEmpty()){
            System.out.println("List masih kosong.");
        } else {
            while(temp!=null){
                System.out.printf("%s <--> ",temp.data);
                temp = temp.next;
            }
            System.out.println("");
        }
    }

    void printBackward() {
        NodeDLL temp = new NodeDLL();
        temp = tail;
        if(isEmpty()){
            System.out.println("List masih kosong.");
        } else {
            while(temp!=null){
                System.out.printf("%s <--> ",temp.data);
                temp = temp.prev;
            }
            System.out.println("");
        }
    }
}

public class MogaKetuaKelasv2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DLL dll = new DLL();

        int n = sc.nextInt();
        sc.nextLine();

        String command = "";
        String[] splitted = new String[3];
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");

            if (splitted[0].toUpperCase().equals("ADD")) {
                if (splitted[1].toUpperCase().equals("FIRST")) {
                    dll.addFirst(splitted[2]);
                } else if (splitted[1].toUpperCase().equals("LAST")) {
                    dll.addLast(splitted[2]);
                }
            } else if (splitted[0].toUpperCase().equals("REMOVE")) {
                if (splitted[1].toUpperCase().equals("FIRST")) {
                    dll.removeFirst();
                } else if (splitted[1].toUpperCase().equals("LAST")) {
                    dll.removeLast();
                } else if (splitted[1].toUpperCase().equals("TARGET")) {
                    dll.removeTarget(splitted[2]);
                }
            } else if (splitted[0].toUpperCase().equals("INDEX")) {
                dll.addAtIndex(Integer.valueOf(splitted[1]), splitted[2]);
            } else if (splitted[0].toUpperCase().equals("PRINT")) {
                if (splitted[1].toUpperCase().equals("FWD")) {
                    dll.printForward();
                } else if (splitted[1].toUpperCase().equals("BWD")) {
                    dll.printBackward();
                }
            }
        }
    }
}