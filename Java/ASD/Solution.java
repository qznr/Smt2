package Java.ASD;
import java.util.Scanner;

class NodeCSLL {
    NodeCSLL next;
    String orang;

    NodeCSLL() {}
    NodeCSLL(String namaInput) {
        this.orang = namaInput;    
    }
}

class CSLL {
    NodeCSLL head;
    NodeCSLL tail;
    int size;
    

    boolean isEmpty() {
        return head == null && tail == null;
    }

    int getSize() {
        return size;
    }
    
    void addFirst(String newData) {
        NodeCSLL newNode = new NodeCSLL(newData);
        if(isEmpty()){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        }
        size++;
    }
    
    void addLast(String newData) {
        NodeCSLL newNode = new NodeCSLL(newData);
        if(isEmpty()){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    void printList() {
        NodeCSLL temp = new NodeCSLL();
        temp = head;
        if(isEmpty()){
            System.out.println("List masih kosong.");
        } else {
            do {
                System.out.printf("%s -> ",temp.orang);
                temp = temp.next;
            } while(temp!=head);
        }
    }

    void balloonPass() {
        /*
         * KATA MASBRO KERJAIN DISINI
         */
        
    }
    
    void balloonLocation() {
        /*
         * KATA MASBRO KERJAIN DISINI
         */
        
    }

    void balloonExplode() {
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else {
            /*
             * KATA MASBRO KERJAIN DISINI
             */
            
            System.exit(0);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        CSLL list = new CSLL();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); sc.nextLine();

        String command = "";
        String[] splitted = new String[2];
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");

            if (splitted[0].toLowerCase().equals("addfirst")) {
                list.addFirst(splitted[1].toLowerCase());
            } else if (splitted[0].toLowerCase().equals("addlast")) {
                list.addFirst(splitted[1].toLowerCase());
            } else if (splitted[0].toLowerCase().equals("print")) {
                list.printList();
            } else if (splitted[0].toLowerCase().equals("balloon")) {
                if (splitted[1].toLowerCase().equals("loc")) {
                    /*
                     * KATA MASBRO KERJAIN DISINI
                     */
                    
                } else if (splitted[1].equals("pass")) {
                    /*
                     * KATA MASBRO KERJAIN DISINI
                     */
                    
                } else if (splitted[1].toLowerCase().equals("boom")) {
                    /*
                     * KATA MASBRO KERJAIN DISINI
                     */
                    
                }
            }
        }
    }
}