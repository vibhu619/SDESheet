package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

//You are given an array arr[] of size n. Find the total count of sub-arrays having their sum equal to 0.
//
//
//        Example 1:
//
//        Input:
//        n = 6
//        arr[] = {0,0,5,5,0,0}
//        Output: 6
//        Explanation: The 6 subarrays are
//        [0], [0], [0], [0], [0,0], and [0,0].
public class NumberOSubarrayWith0Sum {
    public static void main(String[] args) {
        long[] arr = {0, 0, 5, 5, 0, 0};
        int n = arr.length;
        System.out.println(findSubarray(arr, n));
    }

    public static long findSubarray(long[] arr, int n) {
        //Your code here
        Map<Long, Long> m = new HashMap<>();
        long s = 0;
        m.put(0L, 1L);
        for (int i = 0; i < n; i++) {
            s = s + arr[i];
            if (m.containsKey(s)) {
                m.put(s, m.get(s) + 1);
            } else {
                m.put(s, 1l);
            }

        }
        long ans = 0;
        for (Map.Entry<Long, Long> entry : m.entrySet()) {
            if (entry.getValue() > 1) {
                ans = ans + nCr(entry.getValue());
            }
        }
        return ans;
    }

    public static long factorial(long n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Method to calculate nCr
    public static long nCr(long n) {
        long r = 2;
        if (r > n) {
            return 0;
        }
        // Using the formula nCr = n! / (r! * (n-r)!)
        long nFact = factorial(n);
        long rFact = factorial(r);
        long nMinusRFact = factorial(n - r);
        return nFact / (rFact * nMinusRFact);
    }
}
