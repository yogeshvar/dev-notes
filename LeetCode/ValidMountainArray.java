/**
 * 941. Valid Mountain Array
 * 
 */

class ValidMountainArray {
    public static boolean Solution(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int left = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] <= arr[i]) {
                left = i;
                break;
            }
        }
        int right = 0;
        for (int i = arr.length - 1; i < 0; i++) {
            if (arr[i - 1] <= arr[i]) {
                right = i;
                break;
            }
        }
        if (left == right && left > 0 && right + 1 < arr.length - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 3, 2, 1 };
        System.out.println(Solution(arr));
    }
}