package Stack_and_Queue;
import java.util.Stack;
public class QueueUsingStack<T>
{
	private Stack<T> stack1 = new Stack<>();
	private Stack<T> stack2 = new Stack<>();

	public void enQueue(T data){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		stack1.push(data);
		while (!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
	}

	public T deQueue(){
		if(!stack1.isEmpty()) return null;
		return stack1.pop();
	}
}
