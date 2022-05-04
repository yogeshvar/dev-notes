import math
nums1 = [1, 2]
nums2 = [3, 4]

nums = list(nums1 + nums2)
nums.sort()

# TODO: Find Optimal Solution.

if len(nums) % 2 is 0:
    median = ((len(nums) + 1.0) / 2)
    calc_median = nums[int(math.floor(median))-1] + nums[int(math.ceil(median))-1]
    print calc_median / 2.0
else:
    median = (len(nums)) // 2
    print float(nums[int(median)])