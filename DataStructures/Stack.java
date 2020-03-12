import java.util.*;
class SNode{
	Object data;
	SNode next;
	SNode(Object data){
		this.data = data;
		this.next = null;
	}
}
class Stack{
	SNode stack;
	Stack(){
		this.stack = null;
	}
	public void push(Object data){
		SNode node = new SNode(data);
		if (this.stack == null) {
			this.stack = node;
			return ;
		}
		node.next = this.stack;
		this.stack = node;
	}
	public Object pop(){
		if(this.stack == null){
			System.out.println("Stack is empty.");
			return null;
		}
		//System.out.println(this.stack.data+" popped.");
		Object pop = this.stack.data;
		this.stack = this.stack.next;
		return pop;
	}
	public Object peek(){
		if(this.stack == null){
			System.out.println("Stack is empty.");
			return -1;
		}
		return this.stack.data;
	}
	public boolean isEmpty(){
		return this.stack == null;
	}
	public void print(){
		SNode ptr = this.stack;
		if(stack == null){
			System.out.println("Stack is empty");
			return ;
		}
		while (ptr!=null) {
			System.out.print(ptr.data+" ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.print();
		st.pop();
		st.print();
		System.out.println(st.peek());
	}
}