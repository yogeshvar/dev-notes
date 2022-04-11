// Leet Code Problem
import java.util.Arrays;

/**
 * 66. Plus One
 */
public class PlusOne {
    public static int[] Solution(int[] digits) {
        int lastDigit = digits[digits.length - 1];
        if (lastDigit == 9) {
            digits[digits.length - 1] = 0;
            if (digits.length == 1) {
                int[] a = { 1, 0 };
                return a;
            } else {
                int zeroCounter = 0;
                for (int i = digits.length - 2; i >= 0; i--) {
                    if (digits[i] == 9) {
                        zeroCounter++;
                        digits[i] = 0;
                    } else {
                        digits[i] = digits[i] + 1;
                        return digits;
                    }
                }
                if (zeroCounter == digits.length) {
                    int[] res;
                    res = new int[zeroCounter + 1];
                    
                }
            }
        } else {
            digits[digits.length - 1] = lastDigit + 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 9 };
        System.out.println(Arrays.toString(Solution(arr)));
    }
}
