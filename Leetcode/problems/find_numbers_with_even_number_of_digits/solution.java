class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            String numString = Integer.toString(nums[i]);
            if (numString.length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}