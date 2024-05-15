package String.Easy;
//Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating (in any direction) string 'a' by exactly 2 places.
//
//        Example 1:
//
//        Input:
//        a = amazon
//        b = azonam
//        Output:
//        1
public class RotatableString {
    public static void main(String[] args) {
        String a = "amazon";
        String b = "azonam";

        boolean result = isRotatedByTwoPlaces(a, b);

        System.out.println("Output: " + (result ? 1 : 0));
    }

    static boolean isRotatedByTwoPlaces(String a, String b) {
        // Check if the lengths of strings are equal
        if (a.length() != b.length()) {
            return false;
        }

        // Rotate string 'a' to the left by 2 places
        String rotatedLeft = a.substring(2) + a.substring(0, 2);

        // Rotate string 'a' to the right by 2 places
        String rotatedRight = a.substring(a.length() - 2) + a.substring(0, a.length() - 2);

        // Check if 'b' is equal to either rotated string
        return b.equals(rotatedLeft) || b.equals(rotatedRight);
    }
}
