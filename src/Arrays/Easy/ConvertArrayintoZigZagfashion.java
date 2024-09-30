package Arrays.Easy;
//Given an array arr of distinct elements of size N, the task is to rearrange the elements of the array in a zig-zag fashion so
// that the converted array should be in the below form:
//
//        arr[0] < arr[1]  > arr[2] < arr[3] > arr[4] < . . . . arr[n-2] < arr[n-1] > arr[n].
//
//        NOTE: If your transformation is correct, the output will be 1 else the output will be 0.
//
//        Example 1:
//
//        Input:
//        N = 7
//        Arr[] = {4, 3, 7, 8, 6, 2, 1}
//        Output: 3 7 4 8 2 6 1
//        Explanation: 3 < 7 > 4 < 8 > 2 < 6 > 1


public class ConvertArrayintoZigZagfashion {
    public static void main(String[] args) {
        int arr[] = {4, 3, 7, 8, 6, 2, 1};
        int n = arr.length;
        //Logic-Deal with A B C element and it has to parts A<B and B>C.Keep a flag to deal with each part. Flag=true for A<B and flag =false for B>C
        //When flag=true and arr[i]>arr[i+1] then swap else make flag false as we go to next part
        //When flag=false and arr[i+1]>arr[i] then swap else make flag true
        boolean flag = true;
        for (int i = 0; i < n - 1; i++) {
            if (flag) {
                if (arr[i] > arr[i + 1]) {
                    //swap
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                }
                flag = false;
            } else {
                if (arr[i] < arr[i + 1]) {
                    //swap
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                flag = true;
            }
        }
        for (int x : arr) {
            System.out.println(x);
        }
    }
}
