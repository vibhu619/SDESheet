package Arrays.Medium;

public class SellAndBuyStock1 {
    public static void main(String[] args) {
        int[] arr={3,1,4,8,7,2,5};
        int n=arr.length;
        System.out.println("Approach 1: Using Two for loops ");
        maxProfitWithTwoLoops(arr,n);
        System.out.println("Approach 2: Using extra space ");
        maxProfitUsingExtraSpace(arr,n);
        System.out.println("Approach 3: Using No extra space and in linear time");
        maxProfit(arr,n);
    }

    private static void maxProfit(int[] arr, int n) {
        int min=arr[0];
        int mp=0;
        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i]);
            mp=Math.max(mp,arr[i]-min);
        }
        System.out.println(mp);
    }

    private static void maxProfitUsingExtraSpace(int[] arr, int n) {
        int[] aux=new int[n];
        int mp=0;
        int max=0;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,arr[i]);
            aux[i]=max;
        }

        for(int i=0;i<n;i++){
            mp=Math.max(mp,aux[i]-arr[i]);
        }
        System.out.println(mp);
    }

    private static void maxProfitWithTwoLoops(int[] arr, int n) {
        int mp=0;

        for(int i=0;i<n;i++){
            int max=0;
            for(int j=i;j<n;j++){
                max=Math.max(max,arr[j]);
            }
            mp=Math.max(mp,max-arr[i]);
        }

        System.out.println(mp);
    }
}
