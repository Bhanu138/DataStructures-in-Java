class Node{
    String data;
    Node next;
    
    Node(final String data) {
        this.data = data;
        this.next = null;
    }
}
public class CircularLinkedList{
	Node head;
	Node last;
	CircularLinkedList(){
		this.head = null;
		this.last = head;
	}
	void addFront(String item){
		Node node = new Node(item);
		if(head == null){
			head = node;
			last = node;
			head.next = last;
			last.next = head;
			return ;
		}
		node.next = head;
		head = node;
		last.next = head;
	}
	void addLast(String item){
		Node node = new Node(item);
		if(head == null){
			head = node;
			last = node;
			head.next = last;
			last.next = head;
			return ;
		}
		last.next = node;
		node.next = head;
		last = node;
	}
	int getSize(){
		if(head == null) return 0;
		Node ptr = this.head;
		int size = 1;
		while (ptr.next!=head) {
			size++;
			ptr = ptr.next;
		}
		return size;
	}
	boolean isValidIndex(int index){
		return index>=0 && index<=this.getSize();
	}
	void addAt(String item, int index){
		if(!isValidIndex(index)){
			System.out.println("Position is invalid. Position: "+index);
		}else{
			if(index == 0){
				addFront(item);
			}else if(index == this.getSize()){
				addLast(item);
			}else{
				Node node = new Node(item);
				int pos = 0;
				Node ptr = this.head;
				Node prev = this.head;
				while (ptr!=null) {
					if(pos == index){
						prev.next = node;
						node.next = ptr;
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
		if (head == null) return ;
		if(head.next == head){
			head = null;
			last = null;
			return ;
		}
		head = head.next;
		last.next = head;
	}
	void removeLast(){
		if (head == null) return ;
		if(head.next == head){
			head = null;
			last = null;
			return ;
		}
		Node ptr = this.head;
		Node prev = this.head;
		while (ptr.next!=head) {
			prev = ptr;
			ptr = ptr.next;
		}
		last = prev;
		prev.next = head;
	}
	void removeAt(int index){
		if(!isValidIndex(index)){
			System.out.println("Position is invalid. Position: "+index);
		}else{
			if(index == this.getSize()){
				System.out.println("Position is invalid. Position: "+index);
				return ;
			}
			if(index == 0){
				removeFront();
			}else if(index == this.getSize()-1){
				removeLast();
			}else{
				int pos = 0;
				Node ptr = this.head;
				Node prev = this.head;
				while (ptr!=null) {
					if(pos == index){
						prev.next = ptr.next;
						return ; 
					}
					pos++;
					prev = ptr;
					ptr = ptr.next;
				}
			}
		}
	}
	void sort(){
		for (Node ptri = this.head;ptri.next!=this.head;ptri = ptri.next ) {
			for(Node ptrj = this.head;ptrj.next!=this.head;ptrj = ptrj.next){
				if (ptrj.data.compareTo(ptrj.next.data)>0) {
					String s = ptrj.data;
					ptrj.data = ptrj.next.data;
					ptrj.next.data = s;
				}
			}
		}
	}
	void reverse(){
		Node p1 = this.head;
		Node p2 = this.head.next;
		p1.next = last;
		this.last = this.head;
		while (p2!=head) {
			Node ptr = p2;
			p2 = p2.next;
			ptr.next = p1;
			p1 = ptr;
		}
		head = p1;
	}
	void print() {
        if (this.head == null) {
            System.out.println("No nodes");
            return;
        }
        Node node;
        for (node = this.head; node.next != head; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println(node.data);
    }
	public static void main(String[] args) {
		CircularLinkedList cl = new CircularLinkedList();
		cl.addFront("Bhanu");
		cl.addFront("Divya");
		cl.addFront("Surendra");
		cl.addLast("Prathima");
		cl.addLast("Sai");
		cl.addAt("Vice",0);
		cl.addAt("Swetha",3);
		cl.addAt("Bindu",6);
		cl.print();
		cl.removeLast();
		cl.removeLast();
		cl.removeFront();
		cl.print();
		cl.addLast("Vice");
		cl.addLast("Swetha");
		cl.addLast("Bindu");
		cl.print();
		cl.removeAt(0);
		cl.removeAt(8);
		cl.removeAt(6);
		cl.removeAt(3);
		cl.print();
		cl.sort();
		cl.print();
		cl.reverse();
		cl.print();
		cl.addLast("ABC");
		cl.print();
	}
}