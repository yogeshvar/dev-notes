package Array101;

import java.util.Arrays;

public class DuplicateZeros {

    public static void duplicateZeros(int[] arr) {
        int[] dup = new int[arr.length];
        int dupCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                dup[dupCount] = 0;
                dupCount += 1;
                dup[dupCount] = 0;
            } else {
                dup[dupCount] = arr[i];
            }

            dupCount += 1;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] a = { 1, 0, 2, 3, 0, 4, 5, 0 };
        duplicateZeros(a);
    }
}
