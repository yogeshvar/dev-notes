package udemyCourse;

import java.util.Arrays;

public class MiddleFunction {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        arr = Arrays.copyOfRange(arr, 1, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
