package Arrays.Easy;

//Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.
//        Input:
//        N = 10
//        A[] = {6,1,2,8,3,4,7,10,5}
//        Output: 9
public class missingNumber {
    public static void main(String[] args) {
        int[] array = {6, 1, 2, 8, 3, 4, 7, 10, 5};           /////////////TRICK -- SUM  //////
        int n = 10;
        int totalSum = 0;
        int sum = 0;
        //Find total sum from 1 to N and subtract it with Sum of all elements of array
        for (int i = 1; i <= n; i++) {
            totalSum += i;
        }
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println(totalSum - sum);
    }
}
