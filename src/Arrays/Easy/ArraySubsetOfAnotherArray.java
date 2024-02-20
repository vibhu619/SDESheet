package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;
//Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m,
//        where both arrays may contain duplicate elements.
//        The task is to determine whether array a2 is a subset of array a1.
//        It's important to note that both arrays can be sorted or unsorted.
//        Additionally, each occurrence of a duplicate element within an array is considered as a separate element of the set.
//
//        Example 1:
//
//        Input:
//        a1[] = {11, 7, 1, 13, 21, 3, 7, 3}
//        a2[] = {11, 3, 7, 1, 7}
//        Output:
//        Yes
public class ArraySubsetOfAnotherArray {
    public static void main(String[] args) {
        int[] arr1={1, 2 ,3 ,4 ,5 ,6 ,7, 8 };
        int[] arr2={1, 2, 3 ,1};
        int n=arr1.length;
        int m= arr2.length;
        if(SubsetOrNot(arr1,arr2,n,m)){
            System.out.println("Is a subset");
        }
        else {
            System.out.println("Not a subset");
        }

    }

    private static boolean SubsetOrNot(int[] arr1, int[] arr2, int n, int m) {
        Map<Integer,Integer> map=new HashMap<>();  ///trick -- create a hashmap /////

        //Create a map for arr1
        for(int i=0;i<n;i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }

        //For each element in arr2 check if that element is present as key and also check if value for this key is not null
        // than reduce value of that key by 1 else return false
        for(int i=0;i<m;i++){
            if(!map.containsKey(arr2[i]) || map.get(arr2[i])==null || map.get(arr2[i])==0){
                return false;

            }

            else{
                map.put(arr2[i],map.get(arr2[i])-1);
            }
        }
        return true;
    }
}
