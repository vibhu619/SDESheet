package Arrays.Medium;
//Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
//
//
//        Example 1:
//
//        Input:
//        N = 5
//        Arr[] = {1,2,3,-2,5}
//        Output:
//        9
public class kadaneAlgo {
    public static void main(String[] args) {
        long[] arr={2,5,7,-2,-5,4};
        int n=arr.length;
        long cs=0;
        long ms=0;
        long largestNegative=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                largestNegative=Math.max(largestNegative,arr[i]);
            }
            cs=cs+arr[i];
            if(cs<0l){
                cs=0l;
            }
            ms=Math.max(cs,ms);
        }
        if(ms==0l){
            System.out.println(largestNegative);
        }
        else
            System.out.println(ms);
    }
}
