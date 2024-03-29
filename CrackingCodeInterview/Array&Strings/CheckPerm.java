import java.util.Arrays;

/**
 * Chapter 1: Array and Strings
 * Interview Questions: 1.2
 */

public class CheckPerm {

    public static Boolean checkPerm(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);

        if (Arrays.equals(aChars, bChars)) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(checkPerm("ABC", "DEG"));
    }

}
