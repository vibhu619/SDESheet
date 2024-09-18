package String.Easy;
//Given two numbers 'N' and 'S' , find the largest number that can be formed with 'N' digits and whose sum of digits should be equals to 'S'.
//        Return -1 if it is not possible.
//
//        Example 1:
//
//        Input: N = 2, S = 9
//        Output: 90
//        Explaination: It is the biggest number
//        with sum of digits equals to 9.
public class LargestPossibleNumber {
    public static void main(String[] args) {
        int n=5;
        int S=20;

        String ans=getNumber(n,S);
        System.out.println(ans);
    }

    private static String getNumber(int n, int S) {
        if(n>1 && S==0){
            return "-1";
        }
        if(n==1 && S==0){
            return "0";
        }

        StringBuilder s= new StringBuilder();
        while(S!=0){
            //1)find largest number from 0-9 number which is greater than current Sum
            int lnum=large(n,S);
            s.append(lnum);
            S=S-lnum;

        }
        if(s.length()>n){
            return "-1";
        }
        if(s.length()<n){
            while(s.length()!=n){
                s.append("0");
            }
        }
        return s.toString();

}

    private static int large(int n, int S) {
        for(int i=9;i>=0;i--){
            if(S>=i){
                return i;
            }
        }
        return 0;
    }
    }
