/*/  
Nama    : Moch. Gustav Ali Rafsandjani
NIM     : 225150201111015
Kelas   : TIF-C
/*/

package Java.ASD.quiz1;

public class FindPath {
    int[][] adjacencyMatrix;
    int start;
    int end;
    Queue[] queues;
    Stack s = new Stack();
    
    public FindPath(int[][] adjacencyMatrix, int start, int end) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.start = start;
        this.end = end;
        this.queues = new Queue[adjacencyMatrix.length];
        queues[start] = new Queue();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[start][i] == 1 && i != start){
                queues[start].enqueue(new Node(i));
            }
        }
    }
    
    public Stack find() {
        if (end < 0 || end >= adjacencyMatrix.length) {
            return null;
        }

        boolean isConnected = false;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[end][i] == 1) {
                isConnected = true;
                break;
            }
        }
        if (!isConnected) {
            return null;
        }

        Node nodeStart = new Node(start);
        nodeStart.visited = true;
        s.push(nodeStart);
        while (!s.isEmpty()) {
            Node current = s.peek();
            // System.out.println("Current : " + current.index);
            // Check end node
            if (current.index == end) {
                return s;
            }
            // Make new queue if null
            if (queues[current.index] == null) {
                queues[current.index] = new Queue();
                for (int i = 0; i < adjacencyMatrix.length; i++) {
                    if (adjacencyMatrix[current.index][i] == 1 && !isVisited(i)) {
                        queues[current.index].enqueue(new Node(i));
                    }
                }
                // System.out.print("New Queue : ");
                // queues[current.index].printQueue();
            } else {
                // System.out.print("Current Queue : ");
                // queues[current.index].printQueue();
            }
            if (!queues[current.index].isEmpty()) {
                Node next = queues[current.index].dequeue();
                if (!next.visited) {
                    next.visited = true;
                    s.push(next);
                }
                // System.out.println("Next : " + next.index);
            } else {
                // System.out.println("Pop : " + s.peek().index);
                s.pop();
                
            }
        }
        return s;
    }

    boolean isVisited(int index){
        Node[] nodes = s.getStack();
        for (Node node : nodes) {
            if (node.index == index && node.visited) {
                return true;
            }
        }
        return false;
    }
}