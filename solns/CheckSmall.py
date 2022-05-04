"""
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
Return the answer in an array.
"""
nums = [8, 1, 2, 2, 3]
# sorting to minimize the time complexity.
nums.sort()
result = []

for x in nums:
    result.append(nums.index(x))

print result
