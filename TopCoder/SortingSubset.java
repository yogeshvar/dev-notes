import java.util.Arrays;

/**
 * Method 1: Brute Force Method 2: Recursion.
 */
public class SortingSubset {
    public static int getMinimalSize(int[] a) {
        int[] b = a.clone();
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            if (a[i] != b[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = { 3, 2, 1 };
        System.out.println(getMinimalSize(a));

    }
}