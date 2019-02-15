package Linkedlists;

public class CircularLinkedList<T>
{
	Node<T> last;
	int size;

	public static class Node<T>{
		private T data;
		private Node<T> next;

		public Node(final T data)
		{
			this.data = data;
			this.next = null;
		}
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return last == null;
	}

	/**
	 * Insert at the begining of the list
	 * @param data
	 */
	public void push(T data){
		Node<T> newNode = new Node<>(data);
		if(this.isEmpty()){
			this.last = newNode;
			newNode.next = this.last;
		}else{
			newNode.next = last.next;
			last.next = newNode;
		}
		size++;
	}

	/**
	 * Insert at the end of the list
	 * @param data
	 */
	public void append(final T data){
		final Node<T> newNode = new Node<>(data);
		if(this.isEmpty()){
			this.last = newNode;
		}
		final Node<T> temp = this.last;
		final Node<T> first = this.last.next;
		temp.next = newNode;
		newNode.next = first;
	}

	public static void main(final String[] args)
	{
		final CircularLinkedList<String> circularLinkedList = new CircularLinkedList<>();
		circularLinkedList.push("Eclair");
		circularLinkedList.push("Divin");
		circularLinkedList.push("Pax");
		circularLinkedList.push("Dan");
		circularLinkedList.append("Gretta");

	}
}
