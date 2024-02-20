package String.Easy;

import java.util.HashMap;
import java.util.Map;
//Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not.
// An anagram of a string is another string that contains the same characters, only the order of characters can be different.
// For example, act and tac are an anagram of each other.
//
//        Note:-
//
//        If the strings are anagrams you have to return True or else return False
//
//        Input:a = geeksforgeeks, b = forgeeksgeeks
//        Output: YES
public class Anagram {
    public static void main(String[] args) {
        String a="geeksforgeeks";
        String  b="forgeeksgeeks";
        System.out.println(isAnagram(a,b,a.length(),b.length()));
    }

    private static boolean isAnagram(String a, String b, int n, int m) {
        if(n!=m){
            return false;
        }
        Map<Character,Integer> map=new HashMap<>();             ////////////TRICK-  FREQUENCY MAP///////
        for(int i=0;i<n;i++){
            map.put(a.charAt(i),map.getOrDefault(a.charAt(i),0)+1);
        }

        for(int i=0;i<m;i++){
            if(map.containsKey(b.charAt(i)) ){
                if(map.get(b.charAt(i))>0){
                    map.put(b.charAt(i),map.get(b.charAt(i))-1);
                }
                else{
                    return false;
                }

            }
            else
                return false;
        }
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue()!=0){
                return false;

            }
        }
        return true;
    }
}