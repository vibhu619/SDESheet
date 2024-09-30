package Arrays.Medium;

//Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.
//
//        Example 1:
//
//        Input:
//        N = 3, M = 4
//        Mat[] = {
//        {0 1 1 1},
//        {0 0 1 1},
//        {0 0 1 1}
//        }
//        Output: 0
//        Explanation: Row 0 has 3 ones whereas
//        rows 1 and 2 have just 2 ones.
public class RowWithMaxOne {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1}};

        int n = 3;
        int m = 4;

        int row = findRow(arr, n, m);
        System.out.println(row);
    }

    private static int findRow(int[][] arr, int n, int m) {
        int minIndex = Integer.MAX_VALUE;
        int ans = -1;
        //1) traverse each row
        for (int i = 0; i < n; i++) {


            //2) in each row , find the index of first 1 if present using binary search
            int index = firstOne(arr[i], 0, m);
            if (index == -1) {
                continue;
            }

            //3) store index which is minimum

            if (index < minIndex) {
                ans = i;
                minIndex = index;
            }
        }
        return ans;
    }

    private static int firstOne(int[] a, int start, int m) {
        int end = m - 1;
        int potAns = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == 1) {
                potAns = mid;
                end = mid - 1;
            }
            if (a[mid] == 0) {
                start = mid + 1;
            }
        }

        return potAns;

    }
}
