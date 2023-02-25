package Java.ASD;

public class LinkedList {
    Node kepala;
    Node ekor;
    int size;

    public LinkedList(){
        this.kepala = null;
        this.ekor = null;
    }

    public void add(int nilai){
        Node temp = new Node();
        temp.data = nilai;
        size++;
        addLast(temp);
    }

    public void addFirst(Node nodeBaru){
        if (kepala == null){
            kepala = nodeBaru;
            ekor = nodeBaru;
        } else {
            nodeBaru.pointer = kepala;
            kepala = nodeBaru;
        }
    }

    public void addLast (Node nodeBaru){
        if (kepala == null){
            kepala = nodeBaru;
            ekor = nodeBaru;
        } else {
            ekor.pointer = nodeBaru;
            ekor = nodeBaru;
            ekor.pointer = null;
        }
        size++;
    }

    public void addAfter(int key, Node nodeBaru){
        Node temp = kepala;
        while (temp != null){
            if (key == temp.data){
                nodeBaru.pointer = temp.pointer;
                temp.pointer = nodeBaru;
                size++;
                break;
            }
            temp = temp.pointer;
        }
    }

    public
}
