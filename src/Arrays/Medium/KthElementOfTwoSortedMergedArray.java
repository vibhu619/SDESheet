package Arrays.Medium;

//Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K.
// The task is to find the element that would be at the kth position of the final sorted array.
//
//
//        Example 1:
//
//        Input:
//        arr1[] = {2, 3, 6, 7, 9}
//        arr2[] = {1, 4, 8, 10}
//        k = 5
//        Output:
//        6
//        Explanation:
//        The final sorted array would be -
//        1, 2, 3, 4, 6, 7, 8, 9, 10
//        The 5th element of this array is 6.
public class KthElementOfTwoSortedMergedArray {
    public static void main(String[] args) {

        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;
        System.out.println(kthElement(arr1, arr2, arr1.length, arr2.length, k));


    }

    public static int kthElement(int arr1[], int arr2[], int n, int m, int k) {
        //Logic without extra space
        //Keep two pointers at head of each array
        //move both pointers and keep count how many elements have been sorted

        int count = 1;
        int i = 0;
        int j = 0;
        int ans = -1;
        while (i < n && j < m) {
            //if number of elements sorted is equal to k, we got the ans
            if (count == k) {
                ans = Math.min(arr1[i], arr2[j]);
                return ans;
            }
            //else move the pointers till we get the ans
            if (arr1[i] < arr2[j]) {
                i++;
                count++;
            } else if (arr1[i] >= arr2[j]) {
                j++;
                count++;
            }

        }

        if (i < n) {
            i = i + (k - count);
            ans = arr1[i];

        }
        if (j < m) {
            j = j + (k - count);
            ans = arr2[j];

        }

        return ans;
    }
}
