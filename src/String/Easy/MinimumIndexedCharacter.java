package String.Easy;

import java.util.HashMap;
import java.util.Map;
//Given a string str and another string patt. Find the minimum index of the character in str that is also present in patt.
//
//
//        Example 1:
//
//        Input:
//        str = geeksforgeeks
//        patt = set
//        Output: 1
public class MinimumIndexedCharacter {
    public static void main(String[] args) {

        String str="geeksforgeeks";
        String pat="zdt";
        str=str.toLowerCase();
        pat=pat.toLowerCase();

        Map<Character,Integer> map=new HashMap<>();            ///////////////TRICK - MAP ///////////////
        //1) Iterate over str and create map with character:index. Make sure index of each character in map is minimum, hence if a character has already been in map then continue
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                continue;
            }
            else{
                map.put(str.charAt(i),i);
            }
        }
        int ans=str.length();
        //2) iterate over pattern and if character of pattern is found in map check its index if its minimum or not
        for(int i =0;i<pat.length();i++){
            if(map.containsKey(pat.charAt(i)))
                ans=Math.min(ans,map.get(pat.charAt(i)));
        }
        if(ans==str.length()){
            System.out.println("-1");
        }
        else {
            System.out.println(ans);
        }
    }
}
