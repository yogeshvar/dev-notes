class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0; //intitialize count
        int result = 0; //initialize max
     
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
                count = 0;
            else
            {
                count++;//increase count
                result = Math.max(result, count);
            }
        }
     
        return result;
    }
}