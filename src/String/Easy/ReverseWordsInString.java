package String.Easy;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String S = "i.like.this.program.very.much";
        String res="";
        for(String str: S.split("\\.")){
            res=res+reverseString(str);

        }
        System.out.println(res);
        System.out.println(reverseString(res));
    }

    private static String reverseString(String str) {

        String nstr="";
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            nstr=ch+nstr;
        }
        return nstr;
    }
}
