package Arrays.Easy;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr={16,17,4,3,5,2};
        int n=arr.length;

        int maxi=arr[n-1];
        ArrayList<Integer> list=new ArrayList<>();
        list.add(maxi);

        for(int i=n-1;i>=0;i--){
            if(arr[i]>=maxi){
                maxi=arr[i];
                list.add(arr[i]);
            }
        }
        Collections.reverse(list);
        for(int x:list){
            System.out.println(x);
        }
    }
}
