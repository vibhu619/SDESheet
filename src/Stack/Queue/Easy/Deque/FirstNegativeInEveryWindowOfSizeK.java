package Stack.Queue.Easy.Deque;

import java.util.ArrayDeque;


//Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.

//Input :
//        N = 8
//        A[] = {12, -1, -7, 8, -15, 30, 16, 28}
//        K = 3
//        Output :
//        -1 -1 -7 -15 -15 0
public class FirstNegativeInEveryWindowOfSizeK {
    public static void main(String[] args) {
        int A[] = {-8, 2, 3, -6, 10};
        int k = 2;
        long[] ans = printFirstNegativeInteger(A, A.length, k);
        for (long x : ans) {
            System.out.println(x + " ");
        }

    }

    public static long[] printFirstNegativeInteger(int[] A, int N, int k) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();  // A deque (double-ended queue) is used to store the indexes of the negative numbers in the current window.
        long[] ans = new long[N - k + 1];

        //Processing the First Window: The first K elements are processed, and if an element is negative, its index is stored in the deque.
        for (int i = 0; i < k; i++) {
            if (A[i] < 0) {
                ad.addLast(i);
            }
        }
        int j = 0;


        //Sliding Window Logic: For the rest of the elements, the code:
        for (int i = k; i < N; i++) {

            //Prints the first negative integer from the previous window (or 0 if there was none).
            if (!ad.isEmpty()) {
                ans[j] = A[ad.peek()];
            } else {
                ans[j] = 0;
            }
            j++;


            //Removes elements that are out of the current window's range.
            while (!ad.isEmpty() && ad.peek() <= i - k) {
                ad.removeFirst();
            }


            //Adds the current element to the deque if it is negative.
            if (A[i] < 0) {
                ad.addLast(i);
            }
        }


        //Finally, the first negative integer of the last window is printed.
        if (!ad.isEmpty()) {
            ans[j] = A[ad.peek()];
        } else {
            ans[j] = 0;
        }

        return ans;
    }
}
