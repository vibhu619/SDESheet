package String.Easy;

//Given an array of N strings, find the longest common prefix among all strings present in the array.
//
//
//        Example 1:
//
//        Input:
//        N = 4
//        arr[] = {geeksforgeeks, geeks, geek,
//        geezer}
//        Output: gee
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String [] ar={"geeksforgeeks", "geeks", "geek",
                "geezer"};
        int n= ar.length;
        String res=ar[0];
        for(int i=1;i<n;i++){
            res=prefix(res,ar[i]);
        }
        if(res.isEmpty()){
            System.out.println(-1);
        }
        else
            System.out.println(res);

    }

    private static String prefix(String str1, String str2) {
        String str="";
        for(int i=0;i<Math.min(str1.length(),str2.length());i++){
            if(str1.charAt(i)==str2.charAt(i)){
                str=str+str1.charAt(i);
            }
            else{
                break;
            }
        }
        return str;

    }
}
