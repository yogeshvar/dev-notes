package udemyCourse.Sorting;

public class QuickSort {

    static int partition(int[] arr, int start, int end) {
        int pivot = end;
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (arr[j] <= arr[pivot]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }

    private static void QuickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            QuickSort(arr, start, pivot - 1);
            QuickSort(arr, pivot + 1, end);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 2, 8, 9, 10 };
        QuickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
