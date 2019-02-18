package Stack_and_Queue;

import java.lang.reflect.Array;

/**
 * Created by ${Eclair} on 2/16/2019.
 */
public class Stack<T> {

    private Object [] array;
    private int size;

    private int top;


   public Stack(){
       this.array = new Object[100];
       this.top = -1;
   }

    public void push(T data){
        if(this.size > 100) return;

        top +=1;
        this.array[top] = data;
        size++;
   }

   public Object pop(){
         if(this.isEmpty()){
            return null;
         }
         int index = this.top;
         top -=1;
         size--;
        return this.array[index];
   }

   public Object peak(){
       return this.array[this.top];
   }

   public int size(){
        return this.size;
   }

   public boolean isEmpty()
   {
       return this.top == -1;
   }

}
