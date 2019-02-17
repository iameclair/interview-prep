package Stack_and_Queue;

/**
 * Created by ${Eclair} on 2/17/2019.
 */
public class InfixToPostFix {
    public boolean isOperand(char ch){
        return (ch >= 'a' && ch <='z' ) || (ch >= 'A' && ch <='Z' );
    }

    public int isGreater(char ch){
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

    public String infixToPostFix(char [] expres){
        StringBuilder expression = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expres.length; i++){
            if(isOperand(expres[i])){
                expression.append(expres[i]);
            }else
                if(expres[i] == '(') {
                    stack.push(expres[i]);
                }else
                    if (expres[i] == ')') {
                    while (!stack.isEmpty() && (char) stack.peak() != '(') {
                        expression.append((char) stack.pop());
                    }
                    stack.pop();
                }
            else
                if (stack.isEmpty() || isGreater((Character) stack.peak()) <= isGreater(expres[i])) {
                    stack.push(expres[i]);
                } else {
                    while(!stack.isEmpty() && isGreater((Character) stack.peak()) >= isGreater(expres[i]))
                    {
                        expression.append((char) stack.pop());
                    }
                }

        }
        while (!stack.isEmpty()) expression.append((char) stack.pop());
        return expression.toString();
    }

    // Driver method
    public static void main(String[] args)
    {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostFix.infixToPostFix(exp.toCharArray()));
    }
}
