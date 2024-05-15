package Hash.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
//Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.
//
//        Example 1:
//
//        Input:
//        N = 7, K = 4
//        A[] = {1,2,1,3,4,2,3}
//        Output: 3 4 4 3
public class CountDistinct {
    public static void main(String[] args) {
        int n=7;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(1);
            arr.add(2);
            arr.add(1);
            arr.add(3);
            arr.add(4);
            arr.add(2);
            arr.add(3);
        }

        int k=4;
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        int j=0; //tpo keep track of window cycle
        int l=0;  //to keep track of first element of current window,
        for(int i=0;i<n;i++){
            //1. keep j to check if 1 window cycle is completed or not
            if(j<k){  //if j has not complete one cycle then let it complete
                j++;
            }
            //else
            else{
                j=0;   //start cycle
                l++;    //increase start element
                i=l-1;  //assign it to i, so that window start from i=l
                System.out.println(count); //print number of distinct element of current window
                count=0;  //make count 0 for next cycle and clear map
                map.clear();
                continue;
            }

            //check if element is there in map or not , if not increase count
            if(!map.containsKey(arr.get(i))){
                map.put(arr.get(i),1);
                count++;

            }
            else {
                map.put(arr.get(i),map.get(arr.get(i))+1);
            }
        }
        System.out.println(count);  //for last window

    }
}
