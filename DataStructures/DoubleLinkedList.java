class DNode{
	int data;
	DNode next,prev;
	DNode(int data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}
class DoubleLinkedList{
	DNode head;
	DNode last;
	DoubleLinkedList(){
		this.head = null;
		this.last = null;
	}
	void addFront(int data){
		DNode node = new DNode(data);
		if(head == null){
			head = node;
			last = node;
			return ;
		}
		node.next = head;
		head.prev = node;
		head = node;
	}
	void addLast(int data){
		DNode node = new DNode(data);
		if(head == null){
			head = node;
			last = node;
			return ;
		}
		node.prev = last;
		last.next = node;
		last = node;
	}
	int getSize(){
		if(head == null) return 0;
		DNode ptr = this.head;
		int size = 0;
		while (ptr!=null) {
			size++;
			ptr = ptr.next;
		}
		return size;
	}
	boolean isValidIndex(int index){
		return index>=0 && index<=this.getSize();
	}
	void addAt(int data, int index){
		if(!isValidIndex(index)){
			System.out.println("Position is invalid.\nPosition: "+index);
		}else{
			if(index == 0){
				addFront(data);
			}else if(index == this.getSize()){
				addLast(data);
			}else{
				DNode node = new DNode(data);
				DNode ptr = this.head.next;
				DNode prev = this.head;
				int pos = 1;
				while (ptr!=null) {
					if(index == pos){
						prev.next = node;
						node.prev = prev;
						node.next = ptr;
						ptr.prev = node;
						return ;
					}
					pos++;
					prev = ptr;
					ptr = ptr.next;
				}
			}
		}
	}
	void removeFront(){
		if(head == null) return ;
		if(head.next == null){
			head = null;
			last = null;
			return ;
		}
		head = head.next;
		head.prev = null;
	}
	void removeLast(){
		if(head == null) return ;
		if(head.next == null){
			head = null;
			last = null;
			return ;
		}
		DNode ptr = this.head;
		DNode prev = this.head;
		while (ptr.next!=null) {
			prev = ptr;
			ptr = ptr.next;
		}
		//ptr.prev = null;
		prev.next = null;
		last = prev;
	}
	void removeAt(int index){
		if(!isValidIndex(index)){
			System.out.println("Position is invalid.\nPosition: "+index);
		}else {
			if(index == this.getSize()){
				System.out.println("Position is invalid.\nPosition: "+index);
				return ;
			}
			if(index == 0){
				removeFront();
			}else if(index == this.getSize()-1){
				removeLast();
			}else{
				DNode ptr = this.head;
				int pos = 0;
				DNode prev = this.head;
				while (ptr!=null) {
					if(pos == index){
						prev.next = ptr.next;
						ptr.next.prev = prev;
						return ;
					}
					pos++;
					prev = ptr;
					ptr = ptr.next;
				}
			}
		}
	}
	void reverse(){
		if(head == null) return ;
		this.last = this.head;
		DNode p1 = this.head;
		DNode p2 = this.head.next;
		p1.next = null;
		p1.prev = p2;
		while (p2!=null) {
			DNode ptr = p2;
			p2 = p2.next;
			ptr.next = p1;
			p1.prev = ptr;
			p1 = ptr;
		}
		p1.prev = null;
		head = p1;
	}
	void print(){
		if(head == null) return ;
		DNode ptr = this.head;
		while (ptr.next!=null) {
			System.out.print(ptr.data+" -> ");
			ptr = ptr.next;
		}
		System.out.println(ptr.data);
	}
	void printReverse(){
		if(head == null) return ;
		DNode ptr = this.last;
		while (ptr.prev!=null) {
			System.out.print(ptr.data+" -> ");
			ptr = ptr.prev;
		}
		System.out.println(ptr.data);
	}
	public static void main(String[] args) {
		DoubleLinkedList dl = new DoubleLinkedList();
		dl.addFront(1);
		dl.addFront(4);
		dl.addLast(3);
		dl.addLast(2);
		dl.addAt(7,0);
		dl.addAt(8,5);
		dl.addAt(9,3);
		dl.print();
		dl.printReverse();
		dl.removeFront();
		dl.removeFront();
		dl.print();
		dl.printReverse();
		dl.addFront(1);
		dl.addLast(4);
		dl.print();
		dl.printReverse();
		dl.removeAt(1);
		dl.removeAt(3);
		dl.print();
		dl.printReverse();
		dl.reverse();
		dl.print();
		dl.printReverse();
	}
}