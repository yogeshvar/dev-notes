package udemyCourse.Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }

        System.out.println(Arrays.toString(arr));
    }
}
