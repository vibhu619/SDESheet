package Arrays.Easy;
//Given an array A of n non negative numbers. The task is to find the first equilibrium point in an array. Equilibrium point in an array is an index (or position) such that the sum of all elements before that index is same as sum of elements after it.
//
//Note: Return equilibrium point in 1-based indexing. Return -1 if no such point exists.
//
//Example 1:
//
//Input:
//n = 5
//A[] = {1,3,5,2,2}
//Output:
//3
//Explanation:
//equilibrium point is at position 3 as sum of elements before it (1+3) = sum of elements after it (2+2).
public class EquilibiriumPoint {
    public static void main(String[] args) {
        int[] arr={1,3,5,2,2};
        int n=arr.length;
        System.out.println(findEqui(arr,n));

    }

    private static int findEqui(int[] arr, int n) {
        if(arr.length==1){
            return 1;
        }

        //TRICK --- Find total sum and while iterating from left to right for each element find the right sum,
        // if right sum == left sum return the index of current element]
        //else increment the left sum
        int total_sum = 0;
        int right_sum = 0;
        int left_sum = 0;

        for(int i=0;i<n;i++)
        {

            total_sum += arr[i];

        }


        for(int i=0;i<n;i++)
        {

            right_sum = total_sum - left_sum - arr[i];
            if(right_sum == left_sum)
            {

                return i+1;

            }
            left_sum = arr[i] + left_sum;

        }
        return -1;
    }
}
