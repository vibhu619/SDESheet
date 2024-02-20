package Arrays.Easy;

import java.util.Arrays;
//You are given two arrays, A and B, of equal size N. The task is to find the minimum value of A[0] * B[0] + A[1] * B[1] + .... + A[N-1] * B[N-1], where shuffling of elements of arrays A and B is allowed.
//
//
//        Example 1:
//
//        Input:
//        N = 3
//        A[] = {3, 1, 1}
//        B[] = {6, 5, 4}
//        Output:
//        23
//        Explanation:
//        1*6+1*5+3*4 = 6+5+12
//        = 23 is the minimum sum
public class MinimizeTheSumOfProduct {
    public static void main(String[] args) {
        long a[] = {3, 1, 1};
        long b[] = {6, 5, 4};
        int n=3;
        Arrays.sort(a);   ////TRICK --- SORTING /////
        Arrays.sort(b);

        long sum=0;
        for(int i=0;i<n;i++){
            sum=sum+(a[i]*b[n-i-1]);
        }
        System.out.println(sum);


    }
}
