package Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;
//Given two unsorted arrays A of size N and B of size M of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.
//
//        Note: All pairs should be printed in increasing order of u. For eg. for two pairs (u1,v1) and (u2,v2), if u1 < u2 then
//        (u1,v1) should be printed first else second.
//
//        Example 1:
//
//        Input:
//        A[] = {1, 2, 4, 5, 7}
//        B[] = {5, 6, 3, 4, 8}
//        X = 9
//        Output:
//        1 8
//        4 5
//        5 4
//        Explanation:
//        (1, 8), (4, 5), (5, 4) are the
//        pairs which sum to 9.
class pair  {
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}
public class PairWithGivenSum {
    public static void main(String[] args) {
        long[] A={1, 2, 4, 5, 7};
        long[] B={5, 6, 3, 4, 8};
        int N=A.length;
        int M=B.length;
        long X=9;
        Arrays.sort(A);      ////////////TRICK --- SORTING AND 2 POINTER TECHNIQUE  /////////////
        Arrays.sort(B);
        ArrayList<pair> arrayList=new ArrayList<>();
        int k=0;
        int i=0;
        int j=M-1;

        while(i<N && j>=0){
            if(A[i]+B[j]==X){
                pair p=new pair(A[i],B[j]);
                arrayList.add(p);
                k++;
                i++;
                j--;

            }
            else if(A[i]+B[j]<X){
                i++;
            }
            else{
                j--;
            }
        }
        for(pair x: arrayList){
            System.out.println(x.first + " " + x.second);
        }
    }
}
