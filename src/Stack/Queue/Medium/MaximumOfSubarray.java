package Stack.Queue.Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

//Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.
//
//        Example 1:
//
//        Input:
//        N = 9, K = 3
//        arr[] = 1 2 3 1 4 5 2 3 6
//        Output:
//        3 3 4 5 5 5 6
public class MaximumOfSubarray {
    public static void main(String[] args) {
        int[] arr={1 ,2 ,3 ,1 ,4 ,5 ,2 ,3, 6};
        int n=arr.length;
        int k=3;

        System.out.println(max_of_subarrays(arr,n,k));
    }

    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here

        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n ; i++){

            //remove any out of bounds
            if(!dq.isEmpty() && dq.peek() == i-k){
                dq.poll();
            }

            //remove samller element befor adding

            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }

            //add i
            dq.offer(i);

            if(i >= k-1){
                list.add(arr[dq.peek()]);
            }
        }

        return list;

    }
}
