class Solution {
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