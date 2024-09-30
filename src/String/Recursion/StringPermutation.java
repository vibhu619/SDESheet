package String.Recursion;

import java.util.LinkedHashSet;

public class StringPermutation {
    public static void main(String[] args) {
        String str = "ljr";
        LinkedHashSet<String> hs = new LinkedHashSet<>();
        call(str, hs, "");
        for (String x : hs) {
            System.out.println(x);
            ;
        }
    }

    public static void call(String str, LinkedHashSet<String> h, String newString) {
        if (str.isEmpty()) {
            h.add(newString);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            call(str.substring(0, i) + str.substring(i + 1), h, newString + c);
        }
    }
}
