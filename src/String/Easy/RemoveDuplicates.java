package String.Easy;

//Given a string without spaces, the task is to remove duplicates from it.
//
//        Note: The original order of characters must be kept the same.
//
//        Example 1:
//
//        Input: S = "zvvo"
//        Output: "zvo"
public class RemoveDuplicates {
    public static void main(String[] args) {
        String S = "zvvo";
        int[] arr = new int[26];   ///TRICK - USING PREFIX ARRAY ///  USES CONSTANT SC AND O(N) TC

        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }
        String res = "";
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (arr[ch - 'a'] == -1) {
                res = res + ch;
                arr[ch - 'a'] = i;
            }
        }
        System.out.println(res);
    }
}

