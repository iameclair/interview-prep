package Linkedlists;

public class MyLinkedListTest
{

	public static void main(String[] args)
	{
		MyLinkedList<String> linkedList = new MyLinkedList<>();

		linkedList.addFirst("Eclair");
		linkedList.addFirst("Divin");
		linkedList.addFirst("Dan");
		linkedList.addFirst("Jenovic");
		linkedList.insertAfter("Dan", "Gretta");
		linkedList.addLast("Pax");
		linkedList.insertAfter("Pax", "Jonathan");
		linkedList.insertBefore("Jenovic", "Enoch");
		linkedList.delete("Eclair");

		linkedList.traversing();
	}

}