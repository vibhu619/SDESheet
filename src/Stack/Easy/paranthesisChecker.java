package Stack.Easy;

import java.util.Stack;

public class paranthesisChecker {
    public static void main(String[] args) {
        String x="({[]})";
        if(paranthesis(x)){
            System.out.println("Balanced");
        }
        else{
            System.out.println("Not Balanced");
        }
    }

    private static boolean paranthesis(String x) {
        int n=x.length();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(x.charAt(i)=='{'){
                stack.push('}');
            }
            else if(x.charAt(i)=='('){
                stack.push(')');
            }
            else if((x.charAt(i)=='[')){
                stack.push(']');
            }
            else{
                if(!stack.empty() && x.charAt(i)==stack.peek()){
                    stack.pop();
                }
                else{
                    return false;
                }
            }

        }
        return stack.empty();
    }
}
