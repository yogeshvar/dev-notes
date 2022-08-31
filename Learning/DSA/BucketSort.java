
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    int arr[];

    public BucketSort(int arr[]) {
        this.arr = arr;
    }

    public void printArray() {
        for (int i = 0; i <= arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public void bucketSort() {
        int totalBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MAX_VALUE;
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        ArrayList<Integer>[] buckets = new ArrayList[totalBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int value : arr) {
            int bucketNumber = (int) Math.ceil(value * totalBuckets / maxValue);
            buckets[bucketNumber].add(value);
        }

        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        System.out.println(Arrays.toString(buckets));
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 6, 4, 6 };
        BucketSort bucketSort = new BucketSort(arr);
        bucketSort.bucketSort();

    }
}
