class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_so_far = nums[0]
        max_end = nums[0]

        for i in range(1, len(nums)):
            max_so_far = max(nums[i], max_so_far + nums[i])
            max_end = max(max_end, max_so_far)
        return max_end 