package lab_programs;
import java.util.Scanner;
interface Stacks_Adt{
	public void push(int data);
	public int pop();
	public int peek();
	public void display();
	public void isEmpty();
}
public class Lab1 {
	public static void main(String arg[]) {
		Arrays stack=new Arrays();
		System.out.println("Stacks using arrays....");
		System.out.println("Peek value is : "+stack.peek());
		stack.push(10);
		stack.push(11);
		stack.push(12);
		System.out.println("Peek value is : "+stack.peek());
		System.out.println("Popped value is : "+stack.pop());
		stack.display();
		System.out.println("Stacks using linked lists....");
		LinkedList stack1=new LinkedList();
		stack1.push(1);
		stack1.push(2);
		stack1.push(66);
		stack1.push(11);
		System.out.println("Peek value is: "+stack1.peek());
		System.out.println("Popped value is : "+stack1.pop());
		stack1.display();
	}
}
class Arrays implements Stacks_Adt{
	int array[]=new int[10];
	int top=-1;
	public void push(int data) {
		if(top<9) {
			array[++top]=data;
			System.out.println("The element "+data+" added.");
		}
		else
			System.out.println("Stack overflow!!");
	}
	public int pop() {
		if(top==-1)
			System.out.println("Stack underflow!!");
		else {
			return array[top--];
		}
		return 0;
	}
	public int peek() {
		if(top==-1) {
			System.out.println("Stack underflow!!");
			return 0;
		}
		else
			return array[top];
	}
	public void display() {
		if(top==-1) {
			System.out.println("Stack underflow!!");
		}
		else {
			System.out.println("Elements of the stack are : ");
			for(int i=top;i!=-1;i--) {
				System.out.println(array[i]);
			}
		}
	}
	public void isEmpty() {
		if(top==-1)
			System.out.println("Stack underflow...");
		else
			System.out.println("Not empty..");
	}
	
}
class Node{
	int data;
	Node next;
}
class LinkedList implements Stacks_Adt{
	Node top=null;
	public void push(int data) {
		Node newnode=new Node();
		newnode.data=data;
		if(top==null) {
			top=newnode;
		}
		else {
			newnode.next=top;
			top=newnode;
			System.out.println("The element "+data+" is added");
		}
	}
	public int pop() {
		if(top==null) {
			System.out.println("Stack underflow!!");
		}
		else {
			int x=top.data;
			top=top.next;
			return x;
		}
		return 0;
	}
	public int peek() {
		if(top==null)
			System.out.println("Stack underflow!!");
		else
			return top.data;
		return 0;
	}
	public void display() {
		if(top==null)
			System.out.println("Stack underflow!!");
		else {
			System.out.println("Elements of the stack are : ");
			while(top!=null) {
				System.out.println(top.data);
				top=top.next;
			}
		}
	}
	@Override
	public void isEmpty() {
		if(top==null)
			System.out.println("Stack underflow...");
		else
			System.out.println("Not empty..");
	}
}