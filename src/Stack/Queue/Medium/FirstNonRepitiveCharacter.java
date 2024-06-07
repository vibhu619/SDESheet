package Stack.Queue.Medium;

import java.util.*;
//Given an input stream A of n characters consisting only of lower case alphabets.
//        While reading characters from the stream, you have to tell which character has appeared only
//        once in the stream upto that point. If there are many characters that have appeared only once,
//        you have to tell which one of them was the first one to appear. If there is no such character then append '#' to the answer.
//
//        Example 1:
//
//        Input: A = "aabc"
//        Output: "a#bb"
//        Explanation: For every ith character we will
//        consider the string from index 0 till index i first non
//        repeating character is as follow-
//        "a" - first non-repeating character is 'a'
//        "aa" - no non-repeating character so '#'
//        "aab" - first non-repeating character is 'b'
//        "aabc" - there are two non repeating characters 'b' and 'c',
//        first non-repeating character is 'b' because 'b' comes before
//        'c' in the stream.
public interface FirstNonRepitiveCharacter {
    public static void main(String[] args) {
        String str="aabc";

        Map<Character,Integer> m=new HashMap<>();
        Queue<Character> q=new LinkedList<>();

        StringBuilder ans=new StringBuilder();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            m.put(ch,m.getOrDefault(ch,0)+1);

            if(m.get(ch)==1){
                q.add(ch);
            }

            while(!q.isEmpty() && m.get(q.peek())>1){
                q.remove();
            }
            if(q.isEmpty()){
                ans.append('#');
            }
            else{
                ans.append(q.peek());
            }
        }

        System.out.println(ans);
    }
}
