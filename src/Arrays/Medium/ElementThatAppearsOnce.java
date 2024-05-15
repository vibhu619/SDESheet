package Arrays.Medium;

public class ElementThatAppearsOnce {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 3};
        int n=arr.length;

        System.out.println(appearOnce(arr,n));
    }

    private static int appearOnce(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }

        int s = 0;
        int e = n - 1;
        int ans=0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if(mid==n-1 || mid==0){
                System.out.println(arr[mid]);   //Index out of bound
                break;
            }
            if (mid % 2 != 0) {
                if (arr[mid] == arr[mid - 1]) {
                    s = mid + 1;
                } else if (arr[mid] == arr[mid + 1]) {
                    e=mid-1;
                }
                else{
                    ans= arr[mid];
                    break;
                }

            }
            else{
                if(mid==0){
                    ans=arr[mid];
                    break;
                }
                if (arr[mid] == arr[mid - 1]) {
                    e = mid - 1;
                } else if (arr[mid] == arr[mid + 1]) {
                    s=mid+1;
                }
                else{
                    ans= arr[mid];
                    break;
                }

            }

        }
        return ans;
    }
}
