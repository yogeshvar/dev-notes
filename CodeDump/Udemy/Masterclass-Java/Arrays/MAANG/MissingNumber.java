package Arrays.MAANG;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 6 };
        missingNum(arr);
    }

    static void missingNum(int[] arr) {
        int sum = 0;
        int n = arr.length + 1;
        int total = n * (n + 1) / 2;
        for (int i : arr) {
            sum += i;
        }
        System.out.println(total - sum);
    }
}