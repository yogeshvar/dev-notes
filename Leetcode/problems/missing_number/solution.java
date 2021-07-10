class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = 0;
        int actualSum = 0;
        expectedSum = (nums.length * (nums.length+1)) / 2;
        for (int e: nums) {
            actualSum += e;
        }
        return expectedSum - actualSum;
    }
}