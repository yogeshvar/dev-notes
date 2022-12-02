class Solution:
    def minOperations(self, nums: List[int]) -> int:
        count = 0
        for i in range(0, len(nums) - 1): 
            if nums[i] < nums[i + 1]:
                continue
            else:
                while nums[i] >= nums[i+1]:
                    diff = nums[i] - nums[i + 1] + 1
                    nums[i+1] += diff
                    count += diff
        return count