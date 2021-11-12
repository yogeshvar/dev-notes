package Array101;

import java.util.Arrays;

public class SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] a = { -7, -3, 2, 3, 11 };
        System.out.println(Arrays.toString(sortedSquares(a)));
    }
}
