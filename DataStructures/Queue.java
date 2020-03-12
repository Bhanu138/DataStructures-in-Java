class QNode{
    Object data;
    QNode next;
    
    QNode(Object data) {
        this.data = data;
        this.next = null;
    }
}
class Queue{
	QNode queue;
	QNode last;
	Queue(){
		this.queue = null;
		this.last = null; 
	}
	void enqueue(Object data){
		QNode node = new QNode(data);
		if(this.queue == null){
			queue = node;
			last = node;
			return ;
		}
		last.next = node;
		last = node;
	}
	void dequeue(){
		if(this.queue == null){
			System.out.println("Queue is empty");
			return ;
		}
		System.out.println(queue.data+" popped.");
		queue = queue.next;
	}
	Object peek(){
		if(this.queue == null){
			System.out.println("Queue is empty");
			return -1;
		}
		return queue.data;
	}
	void print(){
		if(this.queue == null){
			System.out.println("Queue is empty");
			return ; 
		}
		QNode ptr = this.queue;
		while (ptr!=null) {
			System.out.print(ptr.data+" ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {  
		Queue q = new Queue();
		q.enqueue("Bhanu");
		q.enqueue("Divya");
		q.enqueue("Prathima");
		q.print();
		q.dequeue();
		q.print();
		System.out.println(q.peek());

	}
}