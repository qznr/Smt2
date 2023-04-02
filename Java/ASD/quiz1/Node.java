/*/  
Nama    : Moch. Gustav Ali Rafsandjani
NIM     : 225150201111015
Kelas   : TIF-C
/*/

package Java.ASD.quiz1;

public class Node {
    int index;
    boolean visited;
    Node pointer;

    public Node() {
        this.visited = false;
        this.pointer = null;
    }

    public Node(int index) {
        this.index = index;
        this.visited = false;
        this.pointer = null;
    }

    public Node(int index, boolean visited) {
        this.index = index;
        this.visited = visited;
        this.pointer = null;
    }
}