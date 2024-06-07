package String.Recursion;
//Given a string s, remove all its adjacent duplicate characters recursively.
//
//        Note: For some test cases, the resultant string would be an empty string. In that case, the function should return the empty string only.
//
//        Example 1:
//
//        Input:
//        S = "geeksforgeek"
//        Output: "gksforgk"
//        Explanation:
//        g(ee)ksforg(ee)k -> gksforgk
//
//        Example 2:
//
//        Input:
//        S = "abccbccba"
//        Output: ""
//        Explanation:
//        ab(cc)b(cc)ba->abbba->a(bbb)a->aa->(aa)->""(empty string)
public class RemoveAdjacent1 {
    public static void main(String[] args) {
        String str = "eabcccbccbad";
        System.out.println(rremove(str));
    }
    static String rremove(String s) {
        String s1="";
        //initially it will enter while loop bcz s1 size 0
        //agar remove method apply hone k baad koi change ni aata string pe that means its final .
        //but agar change aata i.e agar duplicate hata deta h remove method(size differs) then again need to check for duplicates
        while(s1.length()!=s.length()){
            s1=s;
            s=remove_util(s);
        }

        return s;
    }

    public static String remove_util(String s){
        int n=s.length();
        String newString="";
        int i=0;
        while(i<n){
            //while i<n-1 and character at i and i+1 is equal,increment i
            if(i<n-1 && s.charAt(i)==s.charAt(i+1)){
                while(i<n-1 && s.charAt(i)==s.charAt(i+1)){
                    i++;
                }
            }
            //else add character to new string
            else{
                newString=newString+s.charAt(i);
            }
            //do this i++so that after it comes out from while loop at line 43, i is incremented as we cant take the character which is duplicated but its i+1 is different.
            // Ex abbcccb , while loop will end at last 'c' but we dont need to take that c, hence i++
            i++;
        }
        return newString;
    }
}
