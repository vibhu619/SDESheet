package String.Easy;

import java.util.Stack;

public class ParanthesisChecker {
    public static void main(String[] args) {
        String x = "(]";
        if (isParanthesisOk(x)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }

    private static boolean isParanthesisOk(String x) {
        if(x.length()==1){
            return false;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            } else if (st.isEmpty() && (ch == '}' || ch == ']' || ch == ')')) {
                return false;
            } else if ((ch == ')' && st.peek() == '(') || (ch == ']' && st.peek() == '[') || (ch == '}' && st.peek() == '{')) {
                st.pop();
            } else {
                return false;
            }
        }
        if (!(st.isEmpty())) {
            return false;
        }
        return true;
    }
}
