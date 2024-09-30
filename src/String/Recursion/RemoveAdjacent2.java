package String.Recursion;

import java.util.Stack;

//Recursion+stack
public class RemoveAdjacent2 {
    public static void main(String[] args) {
        String str = "abcccbccbde";
        int n = str.length();

        System.out.println(removeDuplicate(str) + " --- final string");
    }

    private static String removeDuplicate(String str) {
        Stack<Character> stack = new Stack<>();
        String oldStr = str;
        int i = 0; // Initialize the index variable
        while (i < str.length()) {
            // Check if stack is not empty and top of stack is the same as S[i]
            if (!stack.empty() && stack.peek() == str.charAt(i)) {
                // Remove consecutive characters equal to the top of the stack. If top of stack and current char of str are equal move index till char is different from top of stack
                //after that pop that from stack
                while (!stack.empty() && stack.peek() == str.charAt(i)) {
                    i++;
                }
                stack.pop(); //bcz we don't want that duplicated character at all
            }
            // If S[i] is different from top of the stack, push it onto the stack
            if (i < str.length()) {
                stack.push(str.charAt(i));
                i++;
            }
        }


        String newString = "";
        for (char x : stack) {
            newString += x;
        }
// Check if the resulting string is the same as the original string
        if (newString.equals(oldStr)) {
            //if equal means return , this is the final one
            return newString;
        }
        System.out.println(newString);
        //else recursively call on new string
        return removeDuplicate(newString);

    }
}
