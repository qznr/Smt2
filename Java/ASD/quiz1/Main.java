/*/  
Nama    : Moch. Gustav Ali Rafsandjani
NIM     : 225150201111015
Kelas   : TIF-C
/*/

package Java.ASD.quiz1;

public class Main {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
            {0,1,0,1,0,0,0,0},
            {1,0,1,1,0,0,1,0},
            {0,1,0,0,0,0,0,0},
            {1,1,0,0,1,0,0,0},
            {0,0,0,1,0,1,0,0},
            {0,0,0,0,1,0,0,0},
            {0,1,0,0,0,0,0,1},
            {0,0,0,0,0,0,1,0}
        };
        int start = 0;
        int end = 7;

        // Queue[] queues = new Queue[adjacencyMatrix.length];
        // for (int i = 0; i < adjacencyMatrix.length; i++) {
        //     queues[i] = new Queue();
        //     for (int j = 0; j < adjacencyMatrix[i].length; j++) {
        //         if (adjacencyMatrix[i][j] == 1)
        //         queues[i].enqueue(new Node(j));
        //     }
        // }

        // for (int i = 0; i < queues.length; i++) {
        //     while (!queues[i].isEmpty()) {
        //         Node node = queues[i].dequeue();
        //         System.out.print(node.index + " ");
        //     }
        //     System.out.println();
        // }

        FindPath findPath = new FindPath(adjacencyMatrix, start, end);

        // while(!findPath.queues[start].isEmpty()){
        //     Node node = findPath.queues[start].dequeue();
        //     System.out.println(node.index + " " + node.visited);
        // }

        Stack path = findPath.find();

        // Stack finalStack = new Stack();
        // while(!path.isEmpty()){
        //     finalStack.push(path.peek());
        //     path.pop();
        // }

        // while (!finalStack.isEmpty()) {
        //     Node node = finalStack.pop();
        //     System.out.print(node.index);
        //     if (!finalStack.isEmpty()) {
        //         System.out.print(" - ");
        //     }
        // }
 
        if (path != null) {
            int[] nodeIndices = new int[path.size];
            int i = 0;
            while (!path.isEmpty()) {
                Node node = path.pop();
                nodeIndices[i++] = node.index;
            }
            for (int j = nodeIndices.length - 1; j >= 0; j--) {
                System.out.print(nodeIndices[j]);
                if (j > 0) {
                    System.out.print(" - ");
                }
            }
        } else {
            System.out.println("Jalan dari " + start + " Menuju ke " + end + " tidak ditemukan!");
        }
        
        
    }
}
