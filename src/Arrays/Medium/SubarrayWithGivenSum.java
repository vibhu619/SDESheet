package Arrays.Medium;
//Given an unsorted array A of size N that contains only non negative integers, find a continuous sub-array that adds to a given number S and return the left and right index(1-based indexing) of that subarray.
//
//        In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.
//
//        Note:- You have to return an ArrayList consisting of two elements left and right. In case no such subarray exists return an array consisting of element -1.
//
//        Example 1:
//
//        Input:
//        N = 5, S = 12
//        A[] = {1,2,3,7,5}
//        Output: 2 4
public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr= {1,2,3,7,5};
        int n=arr.length;

        int sum=12;
        int start=0;
        int cs=arr[0];      /////////////TRICK - SLIDING WINDOW ////////////

        for(int i=1;i<n;i++){
            while(cs>sum){
                cs=cs-arr[start];
                start++;
            }

            if(cs==sum){
                System.out.println(start+1 + " " + i);
                break;
            }

            cs=cs+arr[i];
        }
    }
}
