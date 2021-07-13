package LeetCode;

import java.util.Arrays;

class Solution {
    // O(n^2)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
}

class TwoSums {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = { 3, 2, 4 };
        int result[] = solution.twoSum(nums, 6);
        System.out.println("Result " + Arrays.toString(result));
    }
}