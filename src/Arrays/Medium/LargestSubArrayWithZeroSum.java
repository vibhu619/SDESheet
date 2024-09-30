package Arrays.Medium;

import java.util.HashMap;


//Using prefix sum sub array technique
public class LargestSubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        int n = arr.length;
        System.out.println(maxLen(arr, n));
    }

    private static int maxLen(int[] arr, int n) {
        int lastKey = 0;  //cumulative value for till last index
        HashMap<Integer, Integer> m = new HashMap<>();  //to store cumulative value and index
        m.put(0, 0);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int newKey = lastKey + arr[i];   //we will find new cumulative value by adding new element to last cumulative value, hence avoiding new array
            if (m.containsKey(newKey)) {  //if cumulative array is found in map ,means a subarray is there bw index i and index at which same cumulative array was found
                int len = i - (m.get(newKey) + 1) + 1;  //+1 FOR WIRDTH
                max = Math.max(max, len);
            } else {
                m.put(newKey, i);  //else put cumulative array and its index
            }

            lastKey = newKey;  //update last cumulative array
        }

        return max;
    }
}
