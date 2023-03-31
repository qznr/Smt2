package Java.ASD;

public class Stack {
    Node top;
    int size;

    boolean isEmpty(){
        return top == null;
    }

    void makeEmpty(){
        top = null;
        size = 0;
    }

    void push(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            top = newNode;
        } else {
            newNode.pointer = top;
            top = newNode;
        }
        size++;
    }

    int peek(){
        return (isEmpty())? null : top.data;
    }

    int pop(){
        if (isEmpty()){
            return null;
        } else {
            int data = top.data;
            top = top.pointer;
            size--;
            return data;
        }
    }
}