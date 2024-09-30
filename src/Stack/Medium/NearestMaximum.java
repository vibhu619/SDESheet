package Stack.Medium;

import java.util.Stack;

//Given an array arr[ ] of size N having elements, the task is to find the next greater element for each element of the array in order of their appearance in the array.
//        Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
//        If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.
//
//        Example 1:
//
//        Input:
//        N = 4, arr[] = [1 3 2 4]
//        Output:
//        3 4 4 -1
//        Explanation:
//        In the array, the next larger element
//        to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ?
//        since it doesn't exist, it is -1.
public class NearestMaximum {
    public static void main(String[] args) {
        long[] arr = {1, 3, 2, 4};
        int n = arr.length;
        long[] res = nextLargerElement(arr, n);
        for (long x : res) {
            System.out.println(x + " ");
        }

    }

    private static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> st = new Stack<>();
        long[] res = new long[n];

        //Iterate array from backwards and pop top till stack is not empty and top element is smaller or equal to current element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && st.peek() <= arr[i]) {
                st.pop();
            }
            //if stack empty then ans -1
            if (st.empty()) {
                res[i] = -1;
            }
            //else ans is top element
            else {
                res[i] = st.peek();

            }
            st.push(arr[i]);
        }
        return res;
    }
}
