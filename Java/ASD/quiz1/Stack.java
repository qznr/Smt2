/*/  
Nama    : Moch. Gustav Ali Rafsandjani
NIM     : 225150201111015
Kelas   : TIF-C
/*/

package Java.ASD.quiz1;
import java.util.EmptyStackException;

public class Stack {
    Node top;
    int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return top == null;
    }

    public void push(Node newNode){
        if (isEmpty()){
            top = newNode;
        } else {
            newNode.pointer = top;
            top = newNode;
        }
        size++;
    }

    public Node pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        Node pop = top;
        top = top.pointer;
        size--;
        return pop;
    }

    public Node peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return top;
    }

    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.index + " ");
            current = current.pointer;
        }
        System.out.println();
    }

    public Node[] getStack() {
        Node[] stackArray = new Node[size];
        Node currentNode = top;
        int index = 0;
        while (currentNode != null) {
            stackArray[index] = currentNode;
            currentNode = currentNode.pointer;
            index++;
        }
        return stackArray;
    }    
}
