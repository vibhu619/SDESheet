package Arrays.Hard;
//Given a sorted array of positive integers. Your task is to rearrange the array elements alternatively i.e first element should be max value,
//        second should be min value, third should be second max, fourth should be second min and so on.
//        Note: Modify the original array itself. Do it without using any extra space. You do not have to return anything.
//
//        Example 1:
//
//        Input:
//        n = 6
//        arr[] = {1,2,3,4,5,6}
//        Output: 6 1 5 2 4 3
//        Explanation: Max element = 6, min = 1,
//        second max = 5, second min = 2, and
//        so on... Modified array is : 6 1 5 2 4 3.
public class RearrangeArrayAlternately {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int n=arr.length;
        
        rearrange(arr,n);
        for(int x: arr){
            System.out.println(x );
        }
    }

    private static void rearrange(int[] arr, int n) {
        if(n==1){
            return;
        }
        int i=0;
        int j=n-1;
        int m=arr[n-1]+1;
        boolean flag=true;
        for(int start=0;start<n;start++){
            if(flag && j>=0){
                arr[start]=m*(arr[j]%m)+(arr[start]);
                j--;
                flag=false;
                continue;
            }
            if(!flag && i<n){
                arr[start]=m*(arr[i]%m)+(arr[start]);
                i++;
                flag=true;
                continue;
            }

        }

        for(int x=0;x<n;x++){
            arr[x]=arr[x]/m;
        }
    }
}
