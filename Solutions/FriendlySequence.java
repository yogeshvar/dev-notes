import java.util.Arrays;

public class FriendlySequence {
    public static void main(String[] args) {
        int[] arr = { 112, 12, 21, 354, 534345, 345, 2221 };
        int result = count(arr);
        System.out.println("Result : " + result);
    }

    private static int count(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (isFriendly(i, j, a))
                    result++;
                else
                    break;
            }
        }
        return result;
    }

    private static boolean isFriendly(int a, int b, int[] arr) {
        for (int i = a + 1; i <= b; i++) {
            if (!friendly(arr[a], arr[i]))
                return false;
        }
        return true;
    }

    private static boolean friendly(int i, int j) {
        int[] a = digits(i);
        int[] b = digits(j);
        return Arrays.equals(a, b);
    }

    private static int[] digits(int x) {
        int[] ret = new int[10];
        if (x == 0)
            ret[0] = 1;
        else {
            while (x != 0) {
                ret[x % 10] = 1;
                x /= 10;
            }
        }
        return ret;
    }
}
