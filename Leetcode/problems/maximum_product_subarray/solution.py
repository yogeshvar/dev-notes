class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        max_so_far = nums[0]
        min_so_far = nums[0]
        max_end = nums[0]

        for i in range(1, len(nums)):
            if nums[i] > 0:
                max_so_far = max(nums[i], max_so_far * nums[i])
                min_so_far = min(nums[i], min_so_far * nums[i])
            else:
                temp = max_so_far
                max_so_far = max(nums[i], min_so_far * nums[i])
                min_so_far = min(nums[i], temp * nums[i])
            max_end = max(max_end, max_so_far)
        return max_end
        