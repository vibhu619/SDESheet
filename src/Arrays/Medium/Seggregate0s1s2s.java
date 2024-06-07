package Arrays.Medium;

public class Seggregate0s1s2s {
    public static void main(String[] args) {
        int[] arr={1,0,1,2,0,0,1,2};

        int n=arr.length;

        segg(arr,n);
    }

    private static void segg(int[] arr, int n) {
        int s=0;
        int e=n-1;
        int i=0;
        while(i<=e){
            if(arr[i]==0){
                int temp=arr[i];
                arr[i]=arr[s];
                arr[s]=temp;
                s++;
                i++;
            }
            else if(arr[i]==1){
                i++;
            }
            else{
                int temp=arr[i];
                arr[i]=arr[e];
                arr[e]=temp;
                e--;
            }
        }

        for(int x: arr){
            System.out.print(x+" ");
        }

    }
}
