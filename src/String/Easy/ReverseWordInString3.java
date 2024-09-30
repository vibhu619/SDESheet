package String.Easy;

public class ReverseWordInString3 {
    public static void main(String[] args) {
        String S = "i.like.this.program.very.much";
        System.out.println(reverseWords(S));
    }

    //wITH CONSTANT SPACE COMPLEXITY.
    private static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder(); //to store new ans
        String temp = "";  //to store one word from a list of words
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //if character is "." that means its end of onr word
            if (ch == '.') {
                //hence add temp which is carrying one word to ans at index 0 of ans
                if (!(temp.isEmpty())) {
                    ans.insert(0, temp + ".");
                }
                //and make temp empty for next word
                temp = "";
            }
            //if ch is not "." then add ch to temp
            else {
                temp = temp + ch;
            }
        }

        //now as we dont have "." at last of our string , hence we will not be able to add last word in our ans. Therefore we add temp to ans
        if (!(temp.isEmpty())) {
            ans.insert(0, temp + ".");
        }
        return ans.substring(0, ans.length() - 1);  //return substring without the last ".".
    }
}
