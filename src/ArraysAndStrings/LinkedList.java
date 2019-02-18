package ArraysAndStrings;

public class LinkedList<Key, Value>
{
	Node<Key, Value> head;
	public static class Node<Key, Value>{
		Key key;
		Value value;
		Node<Key, Value> next;

		public Node(Key key, Value value){
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	public void add(Key key, Value value)
	{
		Node<Key, Value> newNode = new Node<>(key, value);

		if(this.head == null) this.head = newNode;
		else
			newNode.next = this.head;
		   this.head = newNode;
	}

}
