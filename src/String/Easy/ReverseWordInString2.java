package String.Easy;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordInString2 {
    public static void main(String[] args) {
        String S = "i.like.this.program.very.much";
        //TRICK -USING STRING SPLIT AND JOIN///
        String str[] = S.split("\\.");
        Collections.reverse(Arrays.asList(str));
        String ss = String.join(".", str);
        System.out.println(ss);
    }
}
