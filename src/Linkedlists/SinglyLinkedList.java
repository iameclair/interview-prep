package Linkedlists;

public class SinglyLinkedList
{
	Node head;
	Node last;

	static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	public void push(int new_data)
	{
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}


	public boolean delete(int position){
		if(head == null) return false;

		if(position == 0) {
			Node next = head.next;
			head = next;
			return true;
		}

		Node temp = head.next;
		Node prev = head;
		int i = 1;
		while(temp != null){
			if(position == i){
				prev.next = temp.next;
				return true;
			}
			prev = temp;
			temp = temp.next;
			i+=1;
		}
		return false;
	}

	public void printList()
	{
		Node tnode = head;
		while (tnode != null)
		{
			System.out.print(tnode.data+" ");
			tnode = tnode.next;
		}
	}

	//detecting loop
    public boolean detectLoop(){
	    Node fastPtr = head;
	    Node slowPtr = head;

	    if(head == null) return false;

	    while(fastPtr != null && fastPtr.next != null)
        {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr == slowPtr) return true;
        }
        return false;
    }

    public int printLengthOfLoop(){
	    if(head == null) return 0;
        Node fastPtr = head;
        Node slowPtr = head;
        while(fastPtr != null && fastPtr.next != null)
        {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr == slowPtr){
               Node newPointer = slowPtr.next;
               int count = 1;

               while (newPointer != slowPtr){
                   count++;
                   newPointer=newPointer.next;
               }
               return count;
            }
        }
        return 0;
    }

    public boolean detectLoopAndRemoveIt(){
		if(head == null) return false;
		Node fastPtr = head;
		Node slowPtr = head;
		while(fastPtr != null && fastPtr.next != null)
		{
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if(fastPtr == slowPtr){
				Node temp = slowPtr.next;
				int count = 1;

				while (temp != slowPtr){
					count++;
					temp = temp.next;
				}
				Node newPtr1 = head;
				Node newPtr2 = head;
				for(int i = 0; i < count; i++){
					newPtr1= newPtr1.next;
				}

				while(newPtr2.next != newPtr1.next){
					newPtr2 = newPtr2.next;
				}

				newPtr1.next = null;
				return true;
			}
		}
		return false;
	}

   //iterative
	public int size(){
		if(head == null) return 0;
		Node temp = head;
		int size = 0;
		while(temp != null) {
			size +=1;
			temp = temp.next;
		}
		return size;
	}
	//recursive
	public Node search(Node node, int key){
		if(node == null) return null;
		if(node.data == key) return node;
		return search(node.next, key);
	}

	public Node getNode(int key)
	{
		return search(head, key);
	}

	public static void main(String[] args)
	{
//		SinglyLinkedList llist = new SinglyLinkedList();
//		llist.push(7);
//		llist.push(1);
//		llist.push(3);
//		llist.push(2);
//		llist.push(8);
//
//		System.out.println("\nCreated Linked list is: ");
//		llist.printList();
//
//		llist.delete(4);  // Delete node at position 4
//
//		System.out.println("\nLinked List after Deletion at position 4: ");
//		llist.printList();
//
//		System.out.println("\nThe list size: "+ llist.size());
//
//		System.out.println("\nNode found : "+ llist.getNode(3).data);
////
//

		SinglyLinkedList loop = new SinglyLinkedList();

		Node first = new Node(1);
        Node sec = new Node(2);
        Node thir = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        loop.head = first;
        first.next = sec;
        sec.next = thir;
        thir.next = four;
        four.next = five;
        five.next = sec;
  //      System.out.println("\nDetect loop: "+ loop.detectLoop());
        System.out.println("\nLength of loop: "+ loop.detectLoopAndRemoveIt());
	}
}
