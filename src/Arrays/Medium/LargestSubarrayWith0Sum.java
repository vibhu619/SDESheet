package Arrays.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.
//
//        Example 1:
//
//        Input:
//        N = 8
//        A[] = {15,-2,2,-8,1,7,10,23}
//        Output: 5
//        Explanation: The largest subarray with
//        sum 0 will be -2 2 -8 1 7.
public class LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        int[] arr= {15,-2,2,-8,1,7,10,23};

        int n=arr.length;
        System.out.println(maxLen(arr,n));
    }

    static int maxLen(int ar[], int n)
    {
        // Your code here
        int sum = 0, len=0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            sum=sum+ar[i];
            // System.out.println("sum:"+sum+" len:"+len+" map:"+mp);
            if(sum==0)
                len=i+1;
            else{
                if(mp.containsKey(sum)){
                    len = Math.max(len,(i-mp.get(sum)));
                } else mp.put(sum,i);
            }
        }
        return len;
    }
}
