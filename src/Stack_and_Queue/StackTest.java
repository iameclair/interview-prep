package Stack_and_Queue;

/**
 * Created by ${Eclair} on 2/16/2019.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Eclair");
        stack.push("Pax");
        stack.push("Gretta");

        StackLinkedList<String> stackLinkedList = new StackLinkedList<>();
        stackLinkedList.push("Mango");
        stackLinkedList.push("Orange");
        stackLinkedList.push("Banana");

        System.out.println("/n Stack Size: "+ stack.size());
        System.out.println("/n Stack pop: "+ stack.pop());
        System.out.println("/n Stack Size: "+ stack.size());
        System.out.println("/n Stack pop: "+ stack.pop());

        System.out.println("/n StackLinkedList Size: "+ stackLinkedList.size());
        System.out.println("/n StackLinkedList pop: "+ stackLinkedList.pop().getData());
        System.out.println("/n StackLinkedList Size: "+ stackLinkedList.size());
        System.out.println("/n StackLinkedList pop: "+ stackLinkedList.pop().getData());
    }
}
