import math
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums = list(nums1 + nums2)
        nums.sort()
        if len(nums) % 2 is 0:
            median = ((len(nums) + 1.0) / 2)
            calc_median = nums[int(math.floor(median))-1] + nums[int(math.ceil(median))-1]
            return (calc_median / 2.0)
        else:
            median = (len(nums)) // 2
            return float(nums[median])