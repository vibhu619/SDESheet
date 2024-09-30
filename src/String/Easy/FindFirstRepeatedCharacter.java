package String.Easy;

//Given a string S. The task is to find the first repeated character in it. We need to find the character
//        that occurs more than once and whose index of second occurrence is smallest. S contains only lowercase letters.
//
//
//
//        Example 1:
//
//        Input: S="geeksforgeeks"
//        Output: e
//        Explanation: 'e' repeats at third position.
public class FindFirstRepeatedCharacter {
    public static void main(String[] args) {
        String s = "geksforgeeks";
        System.out.println(firstRepeated(s));

    }

    private static String firstRepeated(String s) {
        int[] arr = new int[26];   ///TRICK -- USING CHARACTER ARRAY ////
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (arr[ch - 'a'] != 0) {  //FIND INDEX OF CHARACTER CH
                return Character.toString(ch);
            } else {
                arr[ch - 'a']++;
            }
        }
        return "-1";
    }
}
