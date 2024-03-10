package lab_programs;

interface Stack {
    void push(int item);
    int pop();
    int peek();
}
class ArrayStack implements Stack {
    int a[];
    int top;
    int size;

    public ArrayStack(int size) {
    	this.size=size;
        a=new int[size];
        top = -1;
    }
    public void push(int item) {
        if (top == size - 1) {
            System.out.println("Stack overflow!");
            return;
        }
        a[++top] = item;
    }
    public int pop() {
        if (top==-1) {
            System.out.println("Stack underflow!");
            return 0;
        }
        return a[top--];
    }
    public int peek() {
        if (top==-1) {
            System.out.println("Stack is empty!");
            return 0;
        }
        return a[top];
    }
}
class Node {
    int data;
    Node next;
}

class LinkedListStack implements Stack {
    private Node top;

    public LinkedListStack() {
        top = null;
    }
    public void push(int item) {
        Node newNode = new Node();
        newNode.data=item;
        newNode.next = top;
        top = newNode;
    }
    public int pop() {
        if (top==null) {
            System.out.println("Stack underflow!");
            return 0;
        }
        int item = top.data;
        top = top.next;
        return item;
    }
    public int peek() {
        if (top==null) {
            System.out.println("Stack is empty!");
            return 0;
        }
        return top.data;
    }
}
public class EXP1 {
    public static void main(String[] args) {
        System.out.println("ArrayStack Test:");
        Stack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println("Peek: " + arrayStack.peek()); 
        System.out.println("Pop: " + arrayStack.pop());   
        System.out.println("Peek: " + arrayStack.peek()); 
        System.out.println();

        System.out.println("LinkedListStack Test:");
        Stack linkedListStack = new LinkedListStack();
        linkedListStack.push(1);
        linkedListStack.push(2);
        System.out.println("Peek: " + linkedListStack.peek()); 
        System.out.println("Pop: " + linkedListStack.pop());   
        System.out.println("Peek: " + linkedListStack.peek()); 
    }
}
