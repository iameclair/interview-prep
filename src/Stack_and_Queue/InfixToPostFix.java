package Stack_and_Queue;

import java.util.Stack;


/**
 * Created by ${Eclair} on 2/17/2019.
 */
public class InfixToPostFix {
    public boolean isOperand(char ch){
        return (ch >= 'a' && ch <='z' ) || (ch >= 'A' && ch <='Z' );
    }

    public int isPrecedenceGreater(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public String infixToPostFix(char [] expressionList){
        StringBuilder expression = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < expressionList.length; i++){
            char character = expressionList[i];

            /** 1. if character is an operand add it to output*/
            if(isOperand(character)){
                expression.append(character);
            }else if(character == '(') stack.push(character);
            else if(character == ')'){
                while(!stack.isEmpty() && stack.peek() != '(')
                    expression.append(stack.pop());
                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression";
                else
                    stack.pop();
            }else
                if(stack.isEmpty() || isPrecedenceGreater(character) > isPrecedenceGreater(stack.peek())){
                    stack.push(character);
                 }else{
                    while (!stack.isEmpty() && isPrecedenceGreater(character) <= isPrecedenceGreater(stack.peek()))
                        expression.append(stack.pop());
                    stack.push(character);
                }
        }
        while (!stack.isEmpty()) expression.append(stack.pop());
        return expression.toString();
    }

    public String postfixToInfix(String expression){
        Stack<String> stack = new Stack<>();

        for(int i = 0 ; i < expression.length(); i++){
            char character = expression.charAt(i);
            if(isOperand(character)){
                stack.push(String.valueOf(character));
            }else{
                if(!stack.isEmpty()){
                    int count = 0;
                    String one = stack.pop();
                    String two = stack.pop();
                    stack.push("("+two+expression.charAt(i)+one+")");
                }
            }
        }
        return stack.peek();
    }
    public char [] reverse(char [] array){
        char [] reversed = new char[array.length];
        int x = 0;
        for(int i = array.length-1; i >=0; i--){
            reversed[x++] = array[i];
        }
        return reversed;
    }
    public String infixToPrefix(char [] expressionList)
    {
        char [] reversedExpression = reverse(expressionList);
        char [] postFixExpression = infixToPostFix(reversedExpression).toCharArray();
        char [] reversedPostfixed = reverse(postFixExpression);
        return reversedPostfixed.toString();
    }

    // Driver method
    public static void main(String[] args)
    {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        //String exp = "a+b+c*(d^e)";
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostFix.infixToPostFix(exp.toCharArray()));
        String exp1 = "ab*c+";
        System.out.println(infixToPostFix.postfixToInfix(exp1));
        String s = ("(a-b/c)*(a/k-l)");
        System.out.println(infixToPostFix.infixToPrefix(s.toCharArray()));
    }
}
