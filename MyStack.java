//package intro;

class EmptyStackException extends Exception{
	EmptyStackException(){
		super();
	}
	EmptyStackException(String str){
		super(str);
	}
}
class Node <E> {
	private E val;
	private Node <E> next;
	
	Node(E val){		
		this.val = val;
		this.next= null;
	}
	
	void SetNext(Node <E> A) {
		this.next=A;
		return;
	}
	
	E GetVal() {
		return this.val;
	}
	
	Node <E> GetNext(){
		return this.next;
	}
}

public class MyStack <E> {
	private Node <E> head;
	MyStack() {
		this.head = null;
	}
	public void push(E item) {
		Node <E> temp = new Node<>(item);
		temp.SetNext(this.head);
		this.head = temp;
		return;
	}
	
	public E pop() throws EmptyStackException{
		// if head==None  "nothing to pop" 
		Node <E> temp = this.head;
		if (this.head == null) {
			throw new EmptyStackException("Stack is Empty");
		}
		this.head = this.head.GetNext();
		return temp.GetVal();
	}
	public E peek() throws EmptyStackException{
		//if head is None return nothing to show
		if (this.head == null) {
			throw new EmptyStackException("Stack is Empty");
		}
		return this.head.GetVal();
	}
	public boolean empty() {
		if (this.head == null){
			return true;	
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<Integer[]> ine = new MyStack<>();
		System.out.println(Boolean.toString(ine.empty()));
//		ine.peek();
//		ine.peek();
//		System.out.println(Integer.toString(ine.pop()));
		Integer[] n = {2, 4};
		ine.push(n) ;
		//ine.peek();
		//ine.push(10);
		//System.out.println(Boolean.toString(ine.empty()));
		//System.out.println(Integer.toString(ine.peek()));
		//System.out.println(Integer.toString(ine.pop()));
	}

}
