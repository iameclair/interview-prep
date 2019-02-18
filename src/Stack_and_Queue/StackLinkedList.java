package Stack_and_Queue;

import Linkedlists.MyLinkedList;

/**
 * Created by ${Eclair} on 2/16/2019.
 */
public class StackLinkedList<T> {

    private Node<T> last;
    private Node<T> head;
    private int size;

    class Node<T>{
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public boolean push(T data){
       Node<T> newNode = new Node<>(data);
       if(this.head == null){
           this.head = newNode;
           this.last = head;
           size++;
           return true;
       }
       Node<T> temp = this.head;
       while(temp.next != null) temp = temp.next;
       temp.next = newNode;
       newNode.prev = temp;
       this.last = newNode;
       size++;
       return true;
    }

    public Node<T> pop(){
        if(this.isEmpty()) return null;
        Node<T> previous = this.last.prev;
        Node<T> nodeToPop = this.last;
        this.last = previous;
        size--;
        return nodeToPop;
    }

    public Object peak(){
        return this.last;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }
}
