package String.Easy;

import java.util.*;
import java.util.stream.Collectors;
//Given two strings A and B consisting of lowercase english characters. Find the characters that are not common in the two strings.
//
//        Note :- Return the string in sorted order.
//
//        Example 1:
//
//        Input:
//        A = geeksforgeeks
//        B = geeksquiz
//        Output: fioqruz
public class UncommonCharacters {
    public static void main(String[] args) {
        String A="geeksforgeeks";
        String B="geeksquiz";
        //Logic-
        //1. create a hashmap of one string           ////////TRICK - HASH MAP////////////
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<A.length();i++){
            map.put(A.charAt(i),map.getOrDefault(A.charAt(i),0)+1);
        }
        String res="";
        //2.iterate over 2nd string and for each character check if it is present in map hence its common, and make its value 0 in map
        //else if not present in map, mean not common element hence add to result string and also make sure to add this character in map to avoid duplicacy in result string
        for(int i =0 ;i<B.length();i++){
            if(map.containsKey(B.charAt(i))){
                map.put(B.charAt(i),0);
            }
            else{
                res=res+B.charAt(i);
                map.put(B.charAt(i),0);
            }
        }
        //3. now you get all characters from string 2 , now get all un common characters from string 1 by iterating over map and see characters whose value is still not 0, add them to result string
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue()!=0){
                res=res+entry.getKey();
            }
        }
        //4.Sort the string
        //For this convert string to character array using ToCharArray() And do sort, and iterate over array and add to  a new string
        String ans="";
        char[] arr=res.toCharArray();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            ans=ans+arr[i];
        }

        System.out.println(ans);
    }
}
