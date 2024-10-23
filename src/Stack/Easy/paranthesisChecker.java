package Stack.Easy;

import java.util.Stack;

public class paranthesisChecker {
    public static void main(String[] args) {
        String x = "({[]})";
        if (paranthesis(x)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }

    private static boolean paranthesis(String x) {
        int n=x.length();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=x.charAt(i);

            if(ch=='{' || ch=='(' || ch=='['){  //if opening brackets, then push
                stack.push(ch);
            }
            //if any closing bracket, then check the top element
            //if a top element is corresponding opening bracket then pop
            else if(ch==')' && stack.peek()=='('){
                stack.pop();
            }
            else if(ch=='}' && stack.peek()=='{'){
                stack.pop();
            }
            else if(ch==']' && stack.peek()=='['){
                stack.pop();
            }
            //else not balanced
            else{
                return false;
            }
        }
        return stack.empty();
    }
}
