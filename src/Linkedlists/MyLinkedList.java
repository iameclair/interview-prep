package Linkedlists;

public class MyLinkedList<T>
{
	//linked list
	private Node<T> head = null;
	private Node<T> tail = null;

	public MyLinkedList(){
		super();
	}

	public static class Node<T>
	{
		private T data;
		Node<T> next;
		private Node<T> previous;

		public Node(T data){
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}



	//Linked List operations
	//add first add at the beginning of the linked list
	public void addFirst(T data){
		if(this.head == null) {
			this.head = new Node<>(data);
			this.tail = this.head;
		}else{
			Node<T> temp = this.head;

			temp.previous = new Node<>(data);

			this.head = temp.previous;
			this.head.next = temp;
		}
	}

	//add last
	//add at the end of the linked list
	public void addLast(T data){
		if(this.head == null) {
			this.head = new Node<>(data);
			this.tail = this.head;
		}else{
			Node<T> temp = this.tail;
			temp.next = new Node<>(data);
			this.tail = temp.next;
			this.tail.previous = temp;
		}
	}

	//insert afeter
	public void insertAfter(T key, T data)
	{
		if(this.head == null) {
			this.head = new Node<>(data);
			this.tail = this.head;
		}else{
			Node temp = searchKey(key);
			if(temp == null) return;
			Node<T> nextNode = temp.next;
			temp.next = new Node<>(data);
			temp.next.previous = temp;
			temp.next.next = nextNode;
			if(nextNode != null)
			{
				nextNode.previous = temp.next;
			}else{
				this.tail = temp.next;
			}
		}
	}

	public void insertBefore(T key, T data)
	{
		if(this.head == null) {
			this.head = new Node<>(data);
			this.tail = this.head;
		}else{
			Node temp = searchKey(key);
			if(temp == null) return;
			Node<T> previous = temp.previous;
			temp.previous = new Node<>(data);
			temp.previous.next = temp;
			temp.previous.previous = previous;
			if(previous != null)
			{
				previous.next = temp.previous;
			}else{
				this.head = temp.previous;
			}
		}
	}

	public Node<T> searchKey(T key){
		if(this.head.data == key) return this.head;
		if(this.tail.data == key) return this.tail;
		Node<T> temp = this.head;
		while(temp != null)
		{
			if(temp.data.equals(key)) return temp;
			temp = temp.next;
		}
		return null;
	}

	public void delete(T data){
		if(this.head.data == data){
			Node<T> nextNode = head.next;
			if(nextNode != null)
				this.head = nextNode;
		}else
			if(this.tail.data == data){
				Node<T> previousNode = this.tail.previous;
				if(previousNode != null)
					this.tail = previousNode;
			}else{
				Node<T> nodeToDelete = searchKey(data);
				Node<T> previousNode = nodeToDelete.previous;
				Node<T> nextNode = nodeToDelete.next;
				previousNode.next = nextNode;
				nextNode.previous = previousNode;
			}
	}

	public void traversing(){
		Node<T> temp = this.head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
}
