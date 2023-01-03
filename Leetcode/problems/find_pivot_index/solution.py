class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        for idx, i in enumerate(nums):
            if sum(nums[:idx]) == sum(nums[idx:]) - i:
                return idx
        return -1